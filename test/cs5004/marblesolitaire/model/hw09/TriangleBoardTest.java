package cs5004.marblesolitaire.model.hw09;

import org.junit.Assert;
import org.junit.Test;

import cs5004.marblesolitaire.model.Cell;

/**
 * This is a JUnit test suite for the Triangle Board.
 */
public class TriangleBoardTest {
  private Board jenn = new TriangleBoard();

  /**
   * Test for the class constructor.
   */
  @Test
  public void testTriangleBoard() {
    Assert.assertEquals(""
            + "    _\n"
            + "   O O\n"
            + "  O O O\n"
            + " O O O O\n"
            + "O O O O O", jenn.toString());
    Assert.assertEquals(14, jenn.countPegs());
    Assert.assertFalse(jenn.isGameOver());
    Board alessia = new TriangleBoard(7);
    Assert.assertEquals(""
            + "      _\n"
            + "     O O\n"
            + "    O O O\n"
            + "   O O O O\n"
            + "  O O O O O\n"
            + " O O O O O O\n"
            + "O O O O O O O", alessia.toString());
  }

  /**
   * Test for the countPegs() method.
   */
  @Test
  public void testCountPegs() {
    Board alessia = new TriangleBoard(6);
    Assert.assertEquals(20, alessia.countPegs());
    alessia = new TriangleBoard(7);
    Assert.assertEquals(27, alessia.countPegs());
  }

  /**
   * Test for the isGameOver() method.
   */
  @Test
  public void testIsGameOver() {
    Assert.assertFalse(jenn.isGameOver());
    helperGame(jenn);
    Assert.assertTrue(jenn.isGameOver());
    jenn.changeCell(0,0, Cell.PEG);
    jenn.changeCell(1,0, Cell.PEG);
    jenn.changeCell(1,1, Cell.PEG);
    Assert.assertFalse(jenn.isGameOver());
    jenn.changeCell(4,2, Cell.PEG);
    jenn.changeCell(3,2, Cell.PEG);
    jenn.changeCell(3,1, Cell.PEG);
    Assert.assertFalse(jenn.isGameOver());
    helperGame(jenn);
    jenn.changeCell(0,0, Cell.PEG);
    jenn.changeCell(4,0, Cell.PEG);
    jenn.changeCell(4,4, Cell.PEG);
    jenn.changeCell(2,1, Cell.PEG);
    Assert.assertTrue(jenn.isGameOver());
    helperGame(jenn);
    jenn.changeCell(0,0, Cell.PEG);
    jenn.changeCell(2,1, Cell.PEG);
    jenn.changeCell(4,2, Cell.PEG);
    Assert.assertTrue(jenn.isGameOver());
    jenn.changeCell(3,2, Cell.PEG);
    Assert.assertFalse(jenn.isGameOver());
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