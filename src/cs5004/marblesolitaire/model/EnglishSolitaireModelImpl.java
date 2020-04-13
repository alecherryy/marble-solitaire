package cs5004.marblesolitaire.model;

import cs5004.marblesolitaire.model.hw09.AbstractMarbleSolitaireModel;

/**
 * This class represents a single game of Marble Solitaire. It implements
 * all the methods listed in the Marble Solitaire interface. Marble Solitaire has
 * a board and a score.
 * */
public class EnglishSolitaireModelImpl extends AbstractMarbleSolitaireModel {

  /**
   * This is the first class constructor. It takes no arguments and
   * starts a new game with a board of arm thickness equals to 3.
   * */
  public EnglishSolitaireModelImpl() {
    super();
  }

  /**
   * This is the second class constructor. It takes a row and col, so
   * the player can choose where the empty cell is.
   *
   * @param sRow the row of the empty cell
   * @param sCol the row of the empty cell
   * @throws IllegalArgumentException if the row or column are not valid
   * */
  public EnglishSolitaireModelImpl(int sRow, int sCol) throws IllegalArgumentException {
    super(sRow, sCol);
  }

  /**
   * This is the third class constructor. It takes the arm thickness as
   * its only parameter and initializes a board with the empty
   * cell in the center.
   *
   * @param arm the row of the empty cell
   * @throws IllegalArgumentException if the row or column are not valid
   * */
  public EnglishSolitaireModelImpl(int arm) {
    super(arm);

    this.board = new EnglishBoard();
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
  public EnglishSolitaireModelImpl(int arm, int sRow, int sCol) {
    super(arm, sRow, sCol);

    this.board = new EnglishBoard();
    this.score = this.board.countPegs();
  }
}
