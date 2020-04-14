package cs5004.marblesolitaire.model.hw09;

import cs5004.marblesolitaire.model.Cell;
import cs5004.marblesolitaire.model.EnglishBoard;
import cs5004.marblesolitaire.model.MarbleSolitaireModel;

/**
 * This class represents a single game of Marble Solitaire. It implements
 * all the methods listed in the Marble Solitaire interface. Marble Solitaire has
 * a board and a score.
 * */
public abstract class AbstractMarbleSolitaireModel implements MarbleSolitaireModel {
  protected Board board;
  protected int score;

  /**
   * This is the first class constructor. It takes no arguments and
   * starts a new game with a board of arm thickness equals to 3.
   * */
  public AbstractMarbleSolitaireModel() {
    this.board = new EnglishBoard();
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
  public AbstractMarbleSolitaireModel(int sRow, int sCol) {
    try {
      this.board = new EnglishBoard();

      if (isNotValidCenter(sRow, sCol)) {
        throw new IllegalArgumentException("Invalid empty cell position (r,c)");
      }
      this.board.changeCell(3,3, Cell.PEG);
      this.board.changeCell(sRow, sCol, Cell.EMPTY);
      this.score = this.board.countPegs();
    }
    catch (ArrayIndexOutOfBoundsException i) {
      throw new IllegalArgumentException("This cell does not exist on the board.");
    }
  }

  /**
   * This is the third class constructor. It takes the arm thickness as
   * its only parameter and initializes a board with the empty
   * cell in the center.
   *
   * @param arm the row of the empty cell
   * @throws IllegalArgumentException if the row or column are not valid
   * */
  public AbstractMarbleSolitaireModel(int arm) {
    // check arm is a valid value
    if (isInvalidArm(arm)) {
      throw new IllegalArgumentException("Invalid arm thickness.");
    }
    this.board = new EnglishBoard(arm);
    this.score = this.board.countPegs();
  }

  /**
   * This is the fourth class constructor. It takes row, col and arm thickness as
   * its parameters and initializes a board with the empty slot in the given cell.
   *
   * @param sRow the row of the empty cell
   * @param sCol the row of the empty cell
   * @param arm the thickness of the arm
   * @throws IllegalArgumentException if the row or column are not valid
   * */
  public AbstractMarbleSolitaireModel(int arm, int sRow, int sCol) {
    try {
      // check arm is a valid value
      if (isInvalidArm(arm)) {
        throw new IllegalArgumentException("Invalid arm thickness.");
      }
      this.board = new EnglishBoard(arm);
      // check row and col are valid
      if (isNotValidCenter(sRow, sCol)) {
        throw new IllegalArgumentException("Invalid empty cell position (r,c)");
      }
      // set the center
      int center = (int) Math.floor(this.board.getLength() / 2);
      // eliminate default empty cell
      this.board.changeCell(center, center, Cell.PEG);
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
   * Helper function to check if given arm is valid, i.e. odd positive integer
   * greater than 3.
   *
   * @param arm the arm thickness
   * @return true if arm is positive and odd, otherwise returns false
   * */
  boolean isInvalidArm(int arm) {
    return arm % 2 == 0 || arm < 3;
  }

  /**
   * Helper function to check if given row is valid, i.e. on the board
   * and within valid cells range.
   *
   * @param row the given row
   * @param col the given row
   * @return true if cell is not null, otherwise returns false
   * */
  protected boolean isNotValidCenter(int row, int col) {
    return this.board.getCell(row, col) == Cell.NULL;
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
    if (validMoveInput(fromRow, fromCol, toRow, toCol)) {
      try {
        // check horizontal and vertical moves
        if (moveHorizontal(fromRow, fromCol, toRow, toCol)
        || moveVertical(fromRow, fromCol, toRow, toCol)) {
          // change the state of the old cell
          this.board.changeCell(fromRow, fromCol, Cell.EMPTY);
          // change the state of the new cell
          this.board.changeCell(toRow, toCol, Cell.PEG);
          // change the score
          this.score--;
          return;
        }
      }
      // if index is out of bounds, throw new IllegalArgumentException
      catch (ArrayIndexOutOfBoundsException i) {
        throw new IllegalArgumentException("This cell does not exist on the board.");
      }
    }
    throw new IllegalArgumentException("Invalid cell position (r,c)");
  }

  /**
   * Helper function to check if the initial cell and the
   * destination cell are valid.
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
  protected boolean validMoveInput(int fromRow, int fromCol, int toRow, int toCol) {
    return this.board.getCell(fromRow, fromCol) == Cell.PEG
            && this.board.getCell(toRow, toCol) == Cell.EMPTY;
  }
  /**
   * Helper function to check if move is horizontal. It takes 4 parameters: the
   * start row, the start col, the destination row and the destination col.
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
  protected boolean moveHorizontal(int fromRow, int fromCol, int toRow, int toCol) {
    if (fromRow == toRow && Math.abs(fromCol - toCol) == 2) {
      this.board.changeCell(toRow, (fromCol + toCol) / 2, Cell.EMPTY);
      return true;
    }
    // if rows don't match, it's not a horizontal move so return false
    return false;
  }

  /**
   * Helper function to check if move is vertically. It takes 4 parameters: the
   * start row, the start col, the destination row and the destination col.
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
  private boolean moveVertical(int fromRow, int fromCol, int toRow, int toCol) {
    if (fromCol == toCol && Math.abs(fromRow - toRow) == 2) {
      this.board.changeCell((fromRow + toRow) / 2, toCol, Cell.EMPTY);
      return true;
    }
    // if cols don't match, it's not a horizontal move so return
    return false;
  }

  /**
   * Checks if the game is over or not; a game is over if no
   * more moves can be made. If no moves are available, return true.
   *
   * @return true if the game is over, false otherwise
   */
  public boolean isGameOver() {
    return this.board.isGameOver();
  }

  /**
   * Return a string that represents the current state of the board. The
   * string has one line per row of the game board. Each slot on the
   * game board is a single character (O, X or space for a marble, empty and
   * invalid position respectively). Slots in a row are separated by a
   * space. Each row has no space before the first slot and after the last slot.
   *
   * @return the game state as a string
   */
  public String getGameState() {
    return this.board.toString();
  }

  /**
   * Return the number of pegs currently on the board.
   *
   * @return the number of pegs on the board
   */
  public int getScore() {
    return this.score;
  }
}
