package cs5004.marblesolitaire.model.hw09;

import org.junit.Assert;
import org.junit.Test;

import cs5004.marblesolitaire.model.Cell;
import cs5004.marblesolitaire.model.EnglishBoard;

/**
 * This is a test unit for the Board class.
 */
public class EuropeanBoardTest {
  private Board alessia = new EuropeanBoard();

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
    Assert.assertEquals(7, alessia.getLength());
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
    Assert.assertEquals(36, alessia.countPegs());
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
    Assert.assertEquals(Cell.PEG, alessia.getCell(5,5));
    Assert.assertEquals(Cell.PEG, alessia.getCell(0,3));
    Assert.assertEquals(Cell.EMPTY, alessia.getCell(3,3));
    Assert.assertEquals(Cell.NULL, alessia.getCell(0,5));
    Assert.assertEquals(Cell.NULL, alessia.getCell(1,6));
  }

  /**
   * Test for the toString() method.
   */
  @Test
  public void testToString() {
    Assert.assertEquals(""
            + "    O O O\n"
            + "  O O O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "  O O O O O\n"
            + "    O O O", alessia.toString());
    alessia.changeCell(3,6, Cell.EMPTY);
    alessia.changeCell(4,3, Cell.EMPTY);
    Assert.assertEquals(""
            + "    O O O\n"
            + "  O O O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O _\n"
            + "O O O _ O O O\n"
            + "  O O O O O\n"
            + "    O O O", alessia.toString());
    alessia.changeCell(1,1, Cell.EMPTY);
    alessia.changeCell(6,2, Cell.EMPTY);
    Assert.assertEquals(""
            + "    O O O\n"
            + "  _ O O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O _\n"
            + "O O O _ O O O\n"
            + "  O O O O O\n"
            + "    _ O O", alessia.toString());
    alessia.changeCell(0,4, Cell.EMPTY);
    alessia.changeCell(1,5, Cell.EMPTY);
    alessia.changeCell(2,6, Cell.EMPTY);
    Assert.assertEquals(""
            + "    O O _\n"
            + "  _ O O O _\n"
            + "O O O O O O _\n"
            + "O O O _ O O _\n"
            + "O O O _ O O O\n"
            + "  O O O O O\n"
            + "    _ O O", alessia.toString());
    alessia.changeCell(3,0, Cell.EMPTY);
    alessia.changeCell(3,1, Cell.EMPTY);
    alessia.changeCell(3,2, Cell.EMPTY);
    alessia.changeCell(3,4, Cell.EMPTY);
    alessia.changeCell(3,5, Cell.EMPTY);
    Assert.assertEquals(""
            + "    O O _\n"
            + "  _ O O O _\n"
            + "O O O O O O _\n"
            + "_ _ _ _ _ _ _\n"
            + "O O O _ O O O\n"
            + "  O O O O O\n"
            + "    _ O O", alessia.toString());
  }

  /**
   * Test for the isGameOver() method.
   */
  @Test
  public void testIsGameOver() {
    helperGame(alessia);
    Assert.assertTrue(alessia.isGameOver());
    alessia.changeCell(3,0, Cell.PEG);
    alessia.changeCell(3,1, Cell.PEG);
    alessia.changeCell(3,2, Cell.PEG);
    alessia.changeCell(3,3, Cell.PEG);
    alessia.changeCell(3,4, Cell.PEG);
    alessia.changeCell(3,5, Cell.PEG);
    alessia.changeCell(3,6, Cell.PEG);
    Assert.assertTrue(alessia.isGameOver());
    alessia.changeCell(2,0, Cell.PEG);
    Assert.assertFalse(alessia.isGameOver());
    alessia.changeCell(2,0, Cell.EMPTY);
    alessia.changeCell(1,5, Cell.PEG);
    Assert.assertTrue(alessia.isGameOver());
    alessia.changeCell(2,5, Cell.PEG);
    Assert.assertFalse(alessia.isGameOver());
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