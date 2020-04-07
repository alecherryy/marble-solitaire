package cs5004.marblesolitaire.model.hw09;

import cs5004.marblesolitaire.model.Cell;

/**
 * This class represents an English Board for Marble Solitaire. Traditionally, this
 * board is 9x9 and in the shape of a cross. Each cell contains an Enum Type representing
 * the invalid, empty and occupied cells.
 * */
public class TriangleBoard extends AbstractBoard {

  /**
   * This is the board constructor.
   */
  public TriangleBoard() {
    super(BoardType.EUROPEAN);

    invalidCells();
  }

  /**
   * This is a second board constructor. It takes an int parameter to set the width of the arm.
   *
   * @param arm the thickness of the arm
   */
  public TriangleBoard(int arm) {
    super(BoardType.ENGLISH, arm);

    invalidCells();
  }

  /**
   * Helper function to set the corner quadrants of the board to be invalid.
   */
  private void invalidCells() {

    // set invalid cells in the top left corner
    for (int row = this.length - 1; row >= 0; row--) {
      for (int col = row; col >= 0; col--) {
        this.board[row][col] = Cell.NULL;
      }
    }
  }
}