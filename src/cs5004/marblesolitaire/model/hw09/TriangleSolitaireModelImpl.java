package cs5004.marblesolitaire.model.hw09;

import cs5004.marblesolitaire.model.Cell;
import cs5004.marblesolitaire.model.EnglishSolitaireModelImpl;

/**
 * This class represents a single game of Marble Solitaire using
 * a Triangle board. This class extends the English Solitaire Model
 * without extending the abstract class, given the class constructors
 * are significantly different.
 * */
public class TriangleSolitaireModelImpl extends EnglishSolitaireModelImpl {

  /**
   * This is the first class constructor. It takes no arguments and
   * starts a new game with a board length equals to 5.
   * */
  public TriangleSolitaireModelImpl() {
    this.board = new TriangleBoard();
    this.score = this.board.countPegs();
  }

  /**
   * This is the second class constructor. It takes a row and col, so
   * the player can choose where the empty cell is.
   *
   * @param sRow the row of the empty cell
   * @param sCol the row of the empty cell
   * @throws IllegalArgumentException if the row or column are not valid
   * */
  public TriangleSolitaireModelImpl(int sRow, int sCol) {
    try {
      this.board = new TriangleBoard();

      if (isNotValidCenter(sRow, sCol)) {
        throw new IllegalArgumentException("Invalid empty cell position (r,c)");
      }
      this.board.changeCell(0,0, Cell.PEG);
      this.board.changeCell(sRow, sCol, Cell.EMPTY);
      this.score = this.board.countPegs();
    }
    catch (ArrayIndexOutOfBoundsException i) {
      throw new IllegalArgumentException("This cell does not exist on the board.");
    }
  }

  /**
   * This is the third class constructor. It takes the board length thickness as
   * its only parameter and initializes a board with the empty
   * cell in the center.
   *
   * @param length the length of the board
   * @throws IllegalArgumentException if the row or column are not valid
   * */
  public TriangleSolitaireModelImpl(int length) {

    // check arm is a valid value
    if (length < 5) {
      throw new IllegalArgumentException("Invalid arm thickness.");
    }
    this.board = new TriangleBoard(length);
    this.score = this.board.countPegs();
  }

  /**
   * This is the fourth class constructor. It takes row, col and length as
   * its parameters and initializes a board with the empty slot in the given cell.
   *
   * @param length the length of the board
   * @param sRow the row of the empty cell
   * @param sCol the row of the empty cell
   * @throws IllegalArgumentException if the row or column are not valid
   * */
  public TriangleSolitaireModelImpl(int length, int sRow, int sCol) {

    try {
      this.board = new TriangleBoard(length);
      // check row and col are valid
      if (isNotValidCenter(sRow, sCol)) {
        throw new IllegalArgumentException("Invalid empty cell position (r,c)");
      }
      this.board.changeCell(0, 0, Cell.PEG);
      //  set new empty cell
      this.board.changeCell(sRow, sCol, Cell.EMPTY);
      this.score = this.board.countPegs();
    }
    // if out of bound exception, throw IllegalArgumentException
    catch (ArrayIndexOutOfBoundsException i) {
      throw new IllegalArgumentException("This cell does not exist on the board.");
    }
  }

  /**
   * Move a single marble from a given position to another given position.
   * A move is valid only if the from and to positions are valid. Specific
   * implementations may place additional constraints on the validity of a move.
   *
   * @param fromRow the row number of the position to be moved from
   *                (starts at 0)
   * @param fromCol the column number of the position to be moved from
   *                (starts at 0)
   * @param toRow the row number of the position to be moved to
   *              (starts at 0)
   * @param toCol the column number of the position to be moved to
   *              (starts at 0)
   * @throws IllegalArgumentException if the move is not possible
   */
  public void move(int fromRow, int fromCol, int toRow, int toCol) {

    // if given start cell is not a peg, throw exception
    try {
      if (validMoveInput(fromRow, fromCol, toRow, toCol)) {
        // check horizontal and diagonal moves
        if (moveHorizontal(fromRow, fromCol, toRow, toCol)
                || moveDiagonal(fromRow, fromCol, toRow, toCol)) {
          // change the state of the old cell
          this.board.changeCell(fromRow, fromCol, Cell.EMPTY);
          // change the state of the new cell
          this.board.changeCell(toRow, toCol, Cell.PEG);
          // change the score
          this.score--;
          return;
        }
      }
      throw new IllegalArgumentException("Invalid cell position (r,c)");
    }
    // if index is out of bounds, throw new IllegalArgumentException
    catch (ArrayIndexOutOfBoundsException i) {
      throw new IllegalArgumentException("Invalid cell position (r,c)");
    }
  }

  /**
   * Helper function to check if move is diagonal.
   *
   * @param fromRow the row number of the position to be moved from
   *                (starts at 0)
   * @param fromCol the column number of the position to be moved from
   *                (starts at 0)
   * @param toRow the row number of the position to be moved to
   *              (starts at 0)
   * @param toCol the column number of the position to be moved to
   *              (starts at 0)
   * @return true if it's a valid horizontal move, otherwise returns false
   * */
  private boolean moveDiagonal(int fromRow, int fromCol, int toRow, int toCol) {
    if (fromCol == toCol && Math.abs(fromRow - toRow) == 2) {
      // change the state of the middle cell
      this.board.changeCell((fromRow + toRow) / 2, toCol, Cell.EMPTY);
      return true;
    }
    else if (Math.abs(fromCol - toCol) == 2 && Math.abs(fromRow - toRow) == 2) {
      // change the state of the middle cell
      this.board.changeCell((fromRow + toRow) / 2, (fromCol + toCol) / 2, Cell.EMPTY);
      return true;
    }
    return false;
  }
}
