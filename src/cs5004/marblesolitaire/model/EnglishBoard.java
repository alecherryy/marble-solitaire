package cs5004.marblesolitaire.model;

import cs5004.marblesolitaire.model.hw09.AbstractBoard;
import cs5004.marblesolitaire.model.hw09.BoardType;

/**
 * This class represents an English Board for Marble Solitaire. Traditionally,
 * this board is in the shape of a cross. Each cell contains
 * an enumerate type representing the invalid, empty and occupied cells.
 * */
public class EnglishBoard extends AbstractBoard {

  /**
   * This is the board constructor.
   */
  public EnglishBoard() {
    super(BoardType.ENGLISH);

    invalidCells();
  }

  /**
   * This is a second board constructor. It takes an int parameter to set
   * the width of the arm.
   *
   * @param arm the thickness of the arm
   */
  public EnglishBoard(int arm) {
    super(BoardType.ENGLISH, arm);

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
}