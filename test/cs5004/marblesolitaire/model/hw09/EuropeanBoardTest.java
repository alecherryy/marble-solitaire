package cs5004.marblesolitaire.model.hw09;

import org.junit.Assert;
import org.junit.Test;

import cs5004.marblesolitaire.model.Cell;
import cs5004.marblesolitaire.model.EnglishBoard;

/**
 * This is a test unit for the Board class.
 */
public class EuropeanBoardTest {
  private Board josiah = new EuropeanBoard();

  /**
   * Test for the class constructor.
   */
  @Test
  public void newEuropeanBoard() {
    Board alessia = new EuropeanBoard();
    Assert.assertEquals(""
            + "    O O O\n"
            + "  O O O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "  O O O O O\n"
            + "    O O O", alessia.toString());
    Assert.assertEquals(36, alessia.countPegs());
    Board clara = new EuropeanBoard(5);
    Assert.assertEquals(""
            + "        O O O O O\n"
            + "      O O O O O O O\n"
            + "    O O O O O O O O O\n"
            + "  O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O _ O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "  O O O O O O O O O O O\n"
            + "    O O O O O O O O O\n"
            + "      O O O O O O O\n"
            + "        O O O O O", clara.toString());
    Assert.assertEquals(128, clara.countPegs());
  }

  /**
   * Test for the getLength() method.
   */
  @Test
  public void testGetLength() {
    Assert.assertEquals(7, josiah.getLength());
    Board kevin = new EnglishBoard(5);
    Assert.assertEquals(13, kevin.getLength());
    kevin = new EnglishBoard(7);
    Assert.assertEquals(19, kevin.getLength());
  }

  /**
   * Test for the countPegs() method.
   */
  @Test
  public void testCountPegs() {
    Assert.assertEquals(36, josiah.countPegs());
    Board alessia = new EuropeanBoard(5);
    Assert.assertEquals(128, alessia.countPegs());
    helperGame(alessia);
    Assert.assertEquals(0, alessia.countPegs());
  }

  /**
   * Test for the getCell() method.
   */
  @Test
  public void testGetCell() {
    Assert.assertEquals(Cell.PEG, josiah.getCell(5,5));
    Assert.assertEquals(Cell.PEG, josiah.getCell(0,3));
    Assert.assertEquals(Cell.EMPTY, josiah.getCell(3,3));
    Assert.assertEquals(Cell.NULL, josiah.getCell(0,5));
    Assert.assertEquals(Cell.NULL, josiah.getCell(1,6));

  }

  /**
   * Test for the isGameOver() method.
   */
  @Test
  public void testIsGameOver() {
    Assert.assertFalse(josiah.isGameOver());
    helperGame(josiah);
    Assert.assertTrue(josiah.isGameOver());
  }

  /**
   * Test for the toString() method.
   */
  @Test
  public void testToString() {
    Board jenn = new EuropeanBoard();
    Assert.assertEquals(""
            + "    O O O\n"
            + "  O O O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "  O O O O O\n"
            + "    O O O", jenn.toString());
    Board clara = new EuropeanBoard(3);
    helperGame(clara);
    Assert.assertEquals(""
            + "    _ _ _\n"
            + "  _ _ _ _ _\n"
            + "_ _ _ _ _ _ _\n"
            + "_ _ _ _ _ _ _\n"
            + "_ _ _ _ _ _ _\n"
            + "  _ _ _ _ _\n"
            + "    _ _ _", clara.toString());
  }

  /**
   * Helper function to create an empty board.
   */
  public void helperGame(Board board) {
    for (int row = 0; row < board.getLength(); row++) {
      for (int col = 0; col < board.getLength(); col++) {
        if (board.getCell(row, col) == Cell.PEG) {
          board.changeCell(row, col, Cell.EMPTY);
        }
      }
    }
  }
}