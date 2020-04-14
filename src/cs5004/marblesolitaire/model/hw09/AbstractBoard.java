package cs5004.marblesolitaire.model.hw09;

import cs5004.marblesolitaire.model.Cell;

/**
 * This abstract class represents a board for a game of Marble
 * Solitaire; it implements all methods listed in the Board Interface.
 * There are two concrete classes extending this abstract class.
 * */
public abstract class AbstractBoard implements Board {
  protected BoardType type;
  protected int arm;
  protected int length;
  protected Cell[][] board;

  /**
   * This is the board constructor. Its only parameter is the
   * type of board to be initialized.
   *
   * @param type of board
   */
  public AbstractBoard(BoardType type) {
    // standard arm size
    this.type = type;
    // standard arm size
    this.arm = 3;
    // standard board size
    this.length = 7;
    this.board = new Cell[this.length][this.length];

    initializeBoard();
  }

  /**
   * This is a second board constructor. It takes an int parameter to set
   * the width of the arm.
   *
   * @param arm the width of the arm
   */
  public AbstractBoard(BoardType type, int arm) {
    this.type = type;
    this.arm = arm;
    // calculate the size of the board based on the arm
    this.length = ((this.arm - 1) * 3) + 1;
    this.board = new Cell[this.length][this.length];

    initializeBoard();
  }

  /**
   * Initializes a new board and sets all cells to contain a peg.
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
  }
  /**
   * Returns the size of the board, i.e. the length of a single row
   * or single column.
   *
   * @return the size of the board
   */
  public int getLength() {
    return this.length;
  }

  /**
   * Returns the total number of pegs on the board.
   *
   * @return the size of the board
   */
  public int countPegs() {
    int count = 0;
    // iterate through board and count how many pegs there are
    for (int row = 0; row < this.length; row++) {
      for (int col = 0; col < this.length; col++) {
        if (this.board[row][col] == Cell.PEG) {
          count++;
        }
      }
    }
    return count;
  }

  /**
   * Given a row and a col, returns the value of that cell.
   *
   * @param row the row on the board
   * @param col the row on the board
   * @return a specified cell within the board
   */
  public Cell getCell(int row, int col) {
    return this.board[row][col];
  }

  /**
   * Given a row and a col, updates the value of that cell with
   * a new given value.
   *
   * @param row the row on the board
   * @param col the row on the board
   * @param value cell value
   */
  public void changeCell(int row, int col, Cell value) {
    this.board[row][col] = value;
  }

  /**
   * Returns the board in a string.
   *
   * @return the board in a string
   */
  public String toString() {
    StringBuilder str = new StringBuilder();
    for (int row = 0; row < this.length; row++) {
      for (int col = 0; col < this.length; col++) {
        if (col < this.length - this.arm || this.board[row][col] != Cell.NULL) {
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
   * This is a helper function to check whether or not there are
   * still moves available in the game. It returns true if at
   * least one move exists, otherwise returns false.
   *
   * @return true if at least one move exists, otherwise returns false
   */
  protected boolean checkNeighbors(int row, int col) {
    // check neighbors of current cell
    try {
      // check bottom neighbors
      if (this.board[row + 1][col] == Cell.PEG && this.board[row + 2][col] == Cell.EMPTY) {
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
      // check top neighbors
      if (this.board[row - 1][col] == Cell.PEG && this.board[row - 2][col] == Cell.EMPTY) {
        return true;
      }
    }
    catch (IndexOutOfBoundsException e) {
      // do nothing
    }
    return false;
  }
}
