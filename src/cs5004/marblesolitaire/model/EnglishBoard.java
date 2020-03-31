package cs5004.marblesolitaire.model;

import cs5004.marblesolitaire.model.hw09.AbstractBoard;
import cs5004.marblesolitaire.model.hw09.BoardType;

/**
 * This class represents an English Board for Marble Solitaire. Traditionally, this
 * board is 9x9 and in the shape of a cross. Each cell contains an Enum Type representing
 * the invalid, empty and occupied cells.
 * */
public class EnglishBoard extends AbstractBoard {
  /**
   * This is the board constructor.
   */
  public EnglishBoard() {
    super(BoardType.EUROPEAN);

    initializeBoard();
  }

  /**
   * This is a second board constructor. It takes an int parameter to set
   * the width of the arm.
   *
   * @param arm the thickness of the arm
   */
  public EnglishBoard(int arm) {
    super(BoardType.ENGLISH, arm);

    initializeBoard();
  }

  /**
   * Initializes a new board and sets all cells to contain a peg; then calls the invalidCells()
   * function to establish all invalid cells.
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
    // set invalid cells in the top left corner
    for (int row = 0; row < (this.length - this.arm) / 2; row++) {
      for (int col = 0; col < (this.length - this.arm) / 2; col++) {
        this.board[row][col] = Cell.NULL;
      }
    }

    // set invalid cells in the top right corner
    for (int row = 0; row < (this.length - this.arm) / 2; row++) {
      for (int col = ((this.length - this.arm) / 2) + this.arm; col < this.length; col++) {
        this.board[row][col] = Cell.NULL;
      }
    }

    // set invalid cells in the bottom left corner
    for (int row = ((this.length - this.arm) / 2) + this.arm; row < this.length; row++) {
      for (int col = 0; col < (this.length - this.arm) / 2; col++) {
        this.board[row][col] = Cell.NULL;
      }
    }

    // set invalid cells in the bottom right corner
    for (int row = ((this.length - this.arm) / 2) + this.arm; row < this.length; row++) {
      for (int col = ((this.length - this.arm) / 2) + this.arm; col < this.length; col++) {
        this.board[row][col] = Cell.NULL;
      }
    }
  }

  /**
   * Iterates through the board and checks whether or not each cell has a peg, if it does, it calls
   * checkNeighbor() to make sure the peg has valid moves left. If it does, it returns through,
   * otherwise it returns false.
   *
   * @return true if there are moves left, otherwise returns false
   */
  public boolean isGameOver() {
    // check if cells have valid move
    for (int row = 0; row < this.length; row++) {
      for (int col = 0; col < this.length; col++) {
        // return false if at least one move can be made
        if (this.board[row][col] == Cell.PEG && checkNeighbors(row, col)) {
          return false;
        }
      }
    }
    return true;
  }

  /**
   * This is a helper function to check whether or not there are still moves available in the game.
   * It returns true if at least one move exists, otherwise returns false.
   *
   * @return true if at least one move exists, otherwise returns false
   */
  private boolean checkNeighbors(int row, int col) {
    // check neighbors of first 2 rows
    if (row == 0 || row == 1) {
      // check left neighbors
      if (this.board[row][col - 1] == Cell.PEG && this.board[row][col - 2] == Cell.EMPTY) {
        return true;
      }
      // check right neighbors
      else if (this.board[row][col + 1] == Cell.PEG && this.board[row][col + 2] == Cell.EMPTY) {
        return true;
      }
      // check bottom neighbors
      else if (this.board[row + 1][col] == Cell.PEG && this.board[row + 2][col] == Cell.EMPTY) {
        return true;
      }
    }
    // check neighbors of last 2 rows
    else if (row == this.length - 2 || row == this.length - 1) {
      // check left neighbors
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
    }
    // check neighbors of first 2 cols
    else if (col == 0 || col == 1) {
      // check right neighbors
      if (this.board[row][col + 1] == Cell.PEG && this.board[row][col + 2] == Cell.EMPTY) {
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
    // check neighbors of last 2 cols
    else if (col == this.length - 2 || col == this.length - 1) {
      // check left neighbors
      if (this.board[row][col - 1] == Cell.PEG && this.board[row][col - 2] == Cell.EMPTY) {
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
    // check all other cells
    else {
      // check left neighbors
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
    return false;
  }
}