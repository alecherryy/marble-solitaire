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
}
