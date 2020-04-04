package cs5004.marblesolitaire.model.hw09;

import cs5004.marblesolitaire.model.Cell;

/**
 * This class represents an English Board for Marble Solitaire. Traditionally, this
 * board is 9x9 and in the shape of a cross. Each cell contains an Enum Type representing
 * the invalid, empty and occupied cells.
 * */
public class EuropeanBoard extends AbstractBoard {

  /**
   * This is the board constructor.
   */
  public EuropeanBoard() {
    super(BoardType.EUROPEAN);

    initializeBoard();
  }

  /**
   * This is a second board constructor. It takes an int parameter to set
   * the width of the arm.
   *
   * @param arm the thickness of the arm
   */
  public EuropeanBoard(int arm) {
    super(BoardType.ENGLISH, arm);

    initializeBoard();
  }

  /**
   * Initializes a new board and sets all cells to contain a peg; then
   * calls the invalidCells() function to establish all invalid cells.
   */
  private void initializeBoard() {
    for (int row = 0; row < this.length; row++) {
      for (int col = 0; col < this.length; col++) {
        this.board[row][col] = Cell.PEG;
      }
    }
    // calculate the center
    int center = (int) Math.floor(this.length / 2);
    // set empty cell
    this.board[center][center] = Cell.EMPTY;
    invalidCells();
  }

  /**
   * Helper function to set the corner quadrants of the board to be invalid.
   */
  private void invalidCells() {
    int i = 0;

    // set invalid cells in the top left corner
    for (int row = 0; row < (this.length - this.arm) / 2; row++) {
      for (int col = 0; col < ((this.length - this.arm) / 2) - i; col++) {
        this.board[row][col] = Cell.NULL;
      }
      i++;
    }

    // set invalid cells in the top right corner
    i = 0;
    for (int row = 0; row < (this.length - this.arm) / 2; row++) {
      for (int col = ((this.length - this.arm) / 2) + this.arm + i; col < this.length; col++) {
        this.board[row][col] = Cell.NULL;
      }
      i++;
    }

    // set invalid cells in the bottom left corner
    i = 0;
    for (int row = this.length - 1; row > this.length - this.arm; row-- ) {
      for (int col = 0; col < ((this.length - this.arm) / 2) - i; col++) {
        this.board[row][col] = Cell.NULL;
      }
      i++;
    }

    // set invalid cells in the bottom right corner
    i = 0;
    for (int row = this.length - 1; row > this.length - this.arm; row-- ) {
      for (int col = ((this.length - this.arm) / 2) + this.arm + i; col < this.length; col++) {
        this.board[row][col] = Cell.NULL;
      }
      i++;
    }
  }

  /**
   * Iterates through the board and checks whether or not each cell has a peg,
   * if it does, it calls checkNeighbor() to make sure the peg has valid
   * moves left. If it does, it returns through, otherwise it returns false.
   *
   * @return true if there are moves left, otherwise returns false
   */
  public boolean isGameOver() {
    // check if cells have valid move
    for (int row = 0; row < this.length; row++) {
      for (int col = 0; col < this.length; col++) {
        // return false if at least one move can be made
        if (this.board[row][col] == Cell.PEG) {
          checkNeighbors(row, col);
        }
      }
    }
    return false;
  }

  /**
   * This is a helper function to check whether or not there are still
   * moves available in the game. It returns true if at least one move exists,
   * otherwise returns false. Catches {@IndexOutOfBoundsException} and ignores it.
   *
   * @param row the row
   * @param col the column
   * @return true if at least one move exists, otherwise returns false
   */
  private boolean checkNeighbors(int row, int col) {
    try {
      // check left
      if (this.board[row][col - 1] == Cell.PEG && this.board[row][col - 2] == Cell.EMPTY) {
        return true;
      }
      // check right neighbors
      else if (this.board[row][col + 1] == Cell.PEG && this.board[row][col + 2] == Cell.EMPTY) {
        return true;
      }
      // check top neighbors
      else if (this.board[row - 1][col] == Cell.PEG && this.board[row - 2][col] == Cell.EMPTY) {
        return true;
      }
      // check bottom neighbors
      else if (this.board[row + 1][col] == Cell.PEG && this.board[row + 2][col] == Cell.EMPTY) {
        return true;
      }
    }
    catch (IndexOutOfBoundsException e) {
      // do nothing
    }
    return false;
  }
}
