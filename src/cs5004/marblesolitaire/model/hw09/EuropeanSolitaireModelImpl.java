package cs5004.marblesolitaire.model.hw09;

import cs5004.marblesolitaire.model.Cell;

/**
 * This class represents a single game of Marble Solitaire. It
 * implements all the methods listed in the Marble Solitaire
 * interface. Marble Solitaire has a board and a score.
 * */
public class EuropeanSolitaireModelImpl extends AbstractMarbleSolitaireModel {

  /**
   * This is the first class constructor. It takes no arguments and
   * starts a new game with a board of arm thickness equals to 3.
   * */
  public EuropeanSolitaireModelImpl() {
    super();

    this.board = new EuropeanBoard();
    this.score = 36;
  }

  /**
   * This is the second class constructor. It takes a row and col, so
   * the player can choose where the empty cell is.
   *
   * @param sRow the row of the empty cell
   * @param sCol the row of the empty cell
   * @throws IllegalArgumentException if the row or column are not valid
   * */
  public EuropeanSolitaireModelImpl(int sRow, int sCol) {
    try {
      this.board = new EuropeanBoard();

      if (isNotValidCenter(sRow, sCol)) {
        throw new IllegalArgumentException("Invalid empty cell position (r,c)");
      }
      this.board.changeCell(3,3, Cell.PEG);
      this.board.changeCell(sRow, sCol, Cell.EMPTY);
      this.score = 36;
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
  public EuropeanSolitaireModelImpl(int arm) {
    // check arm is a valid value
    if (isInvalidArm(arm)) {
      throw new IllegalArgumentException("Invalid arm thickness.");
    }
    this.board = new EuropeanBoard(arm);
    this.score = this.board.countPegs();
  }

  /**
   * This is the fourth class constructor. It takes row, col and
   * arm thickness as its parameters and initializes a board with
   * the empty slot in the given cell.
   *
   * @param sRow the row of the empty cell
   * @param sCol the row of the empty cell
   * @param arm the thickness of the arm
   * @throws IllegalArgumentException if the row or column are not valid
   * */
  public EuropeanSolitaireModelImpl(int arm, int sRow, int sCol) {
    try {
      // check arm is a valid value
      if (isInvalidArm(arm)) {
        throw new IllegalArgumentException("Invalid arm thickness.");
      }
      this.board = new EuropeanBoard(arm);
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
}
