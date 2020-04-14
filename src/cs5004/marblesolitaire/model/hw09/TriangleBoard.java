package cs5004.marblesolitaire.model.hw09;

import cs5004.marblesolitaire.model.Cell;

/**
 * This class represents a Triangle Board for Marble Solitaire. Each cell
 * contains an enumerate type representing the invalid, empty and occupied cells.
 * */
public class TriangleBoard extends AbstractBoard {

  /**
   * This is the board constructor.
   */
  public TriangleBoard() {
    super(BoardType.TRIANGLE);
    this.length = 5;
    this.arm = 5;
    invalidCells();

    changeCell(3,3, Cell.PEG);
    changeCell(0,0, Cell.EMPTY);
  }

  /**
   * This is a second board constructor. It takes an int parameter
   * to set the width of the arm.
   *
   * @param dimensions the thickness of the arm
   */
  public TriangleBoard(int dimensions) {
    super(BoardType.TRIANGLE, dimensions);
    this.length = dimensions;
    this.arm = dimensions;
    invalidCells();

    changeCell(3,3, Cell.PEG);
    changeCell(0,0, Cell.EMPTY);
  }

  /**
   * Helper function to set the corner quadrants of the board to be invalid.
   */
  private void invalidCells() {

    // set invalid cells in the top left corner
    for (int row = 0; row < this.length - 1; row++) {
      for (int col = row + 1; col < this.length; col++) {
        this.board[row][col] = Cell.NULL;
      }
    }
  }

  /**
   * Returns the board in a string.
   *
   * @return the board in a string
   */
  public String toString() {
    StringBuilder str = new StringBuilder();
    int num = this.length - 1;
    for (int row = 0; row < this.length; row++) {
      if (row != this.length - 1) {
        str.append(boardWhitespace(num));
      }

      for (int col = 0; col < this.length; col++) {
        if (col < this.length - this.arm - 1 || this.board[row][col] != Cell.NULL) {
          // append a space before each cell, unless it's the first one
          if (col != 0) {
            str.append(" ");
          }
          switch (this.board[row][col]) {
            // if cell is null, append a space
            case NULL:
              str.append(" ");
              break;
            // if cell is a peg, append a O
            case PEG:
              str.append("O");
              break;
            // if cell is empty, append an underscore
            case EMPTY:
              str.append("_");
              break;
            default:
              break;
          }
        }
      }
      if (row != (this.length - 1)) {
        str.append("\n");
      }
      num--;
    }

    return str.toString();
  }

  /**
   * Private method to offset triangle rows.
   *
   * @param num the number of spaces
   */
  private String boardWhitespace(int num) {
    StringBuilder str = new StringBuilder();

    for (int i = num; i >= 1; i--) {
      str.append(" ");
    }

    return str.toString();
  }

  /**
   * Iterates through the board and checks whether or not
   * each cell has a peg, if it does, it calls checkNeighbor() to make
   * sure the peg has valid moves left. If it does, it returns through,
   * otherwise it returns false.
   *
   * @return true if there are moves left, otherwise returns false
   */
  public boolean isGameOver() {

    // check each cell for valid move
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
   * Override the helper function in the abstract class to check a peg's neighbors.
   *
   * @return true if at least one move exists, otherwise returns false
   */
  protected boolean checkNeighbors(int row, int col) {
    // check neighbors of current cell
    try {
      // check bottom left neighbors
      if (this.board[row + 1][col] == Cell.PEG && this.board[row + 2][col] == Cell.EMPTY) {
        return true;
      }
      // check bottom right neighbors
      if (this.board[row + 1][col + 1] == Cell.PEG && this.board[row + 2][col + 2] == Cell.EMPTY) {
        return true;
      }
      // check top left neighbors
      if (this.board[row - 1][col] == Cell.PEG && this.board[row - 2][col] == Cell.EMPTY) {
        return true;
      }
      // check top right neighbors
      if (this.board[row - 1][col - 1] == Cell.PEG && this.board[row - 2][col - 2] == Cell.EMPTY) {
        return true;
      }
      // check left neighbors
      if (this.board[row][col - 1] == Cell.PEG && this.board[row][col - 2] == Cell.EMPTY) {
        return true;
      }
      // check right neighbors
      if (this.board[row][col + 1] == Cell.PEG && this.board[row][col + 2] == Cell.EMPTY) {
        return true;
      }
    }
    catch (IndexOutOfBoundsException e) {
      // do nothing
    }
    return false;
  }
}