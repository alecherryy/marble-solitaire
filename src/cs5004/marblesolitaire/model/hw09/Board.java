package cs5004.marblesolitaire.model.hw09;

import cs5004.marblesolitaire.model.Cell;

/**
 * This is Board Interface. It represents a generic Marble
 * Solitaire board and includes the protocol for the AbstractBoard class.
 */
public interface Board {

  /**
   * Returns the size of the board, i.e. the length of a single row
   * or single column.
   *
   * @return the size of the board
   */
  int getLength();

  /**
   * Returns the total number of pegs on the board.
   *
   * @return the size of the board
   */
  int countPegs();

  /**
   * Given a row and a col, returns the value of that cell.
   *
   * @param row the row on the board
   * @param col the row on the board
   * @return the value of a specified cell within the board
   */
  Cell getCell(int row, int col);

  /**
   * Given a row and a col, updates the value of that cell with
   * a new given value.
   *
   * @param row the row on the board
   * @param col the row on the board
   * @param value cell value
   */
  void changeCell(int row, int col, Cell value);

  /**
   * Iterates through the board and checks whether or not each cell has a peg,
   * if it does, checks if the peg has any valid moves left.
   * If it does, it returns true, otherwise it returns false.
   *
   * @return true if there are moves left, otherwise returns false
   */
  boolean isGameOver();

  /**
   * Returns the board in a string.
   *
   * @return the board in a string
   */
  String toString();
}
