package cs5004.marblesolitaire.model;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * This is a test unit for the Board class.
 */
public class BoardTest {

  private Board josiah = new Board();

  /**
   * Test for the class constructor.
   */
  @Test
  public void newBoard() {
    Board alessia = new Board();
    Assert.assertEquals(""
            + "    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O", alessia.toString());
    Board clara = new Board(5);
    Assert.assertEquals(""
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O _ O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O", clara.toString());
  }

  /**
   * Test for the getLength() method.
   */
  @Test
  public void testGetLength() {
    assertEquals(7, josiah.getLength());
    Board clara = new Board(5);
    assertEquals(13, clara.getLength());
    Board alessia = new Board(7);
    assertEquals(19, alessia.getLength());
  }

  /**
   * Test for the getLength() method.
   */
  @Test
  public void testCountPegs() {
    assertEquals(32, josiah.countPegs());
    Board clara = new Board(5);
    assertEquals(104, clara.countPegs());
  }

  /**
   * Test for the getCell() method.
   */
  @Test
  public void testGetCell() {
    assertEquals(Cell.NULL, josiah.getCell(0,0));
    assertEquals(Cell.PEG, josiah.getCell(0,2));
    assertEquals(Cell.EMPTY, josiah.getCell(3,3));
    assertEquals(Cell.PEG, josiah.getCell(3,4));
  }

  /**
   * Test for the changeCell() method.
   */
  @Test
  public void testChangeCell() {
    assertEquals(Cell.PEG, josiah.getCell(0,2));
    josiah.changeCell(0,2, Cell.EMPTY);
    assertEquals(Cell.EMPTY, josiah.getCell(0, 2));
    josiah.changeCell(0,2, Cell.NULL);
    assertEquals(Cell.NULL, josiah.getCell(0, 2));
    josiah.changeCell(3,3, Cell.PEG);
    assertEquals(Cell.PEG, josiah.getCell(3,3));
  }

  /**
   * Test for the toString() method.
   */
  @Test
  public void testToString() {
    Assert.assertEquals(""
            + "    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O", josiah.toString());
    josiah.changeCell(3,3, Cell.PEG);
    assertEquals(Cell.PEG, josiah.getCell(3,3));
    Assert.assertEquals(""
            + "    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O O O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O", josiah.toString());
    josiah.changeCell(0,3, Cell.EMPTY);
    josiah.changeCell(2,2, Cell.EMPTY);
    josiah.changeCell(4,3, Cell.EMPTY);
    Assert.assertEquals(""
            + "    O _ O\n"
            + "    O O O\n"
            + "O O _ O O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "    O O O\n"
            + "    O O O", josiah.toString());
    josiah.changeCell(0,2, Cell.EMPTY);
    josiah.changeCell(0,4, Cell.EMPTY);
    josiah.changeCell(1,2, Cell.EMPTY);
    josiah.changeCell(1,3, Cell.EMPTY);
    josiah.changeCell(1,4, Cell.EMPTY);
    josiah.changeCell(2,0, Cell.EMPTY);
    josiah.changeCell(2,1, Cell.EMPTY);
    josiah.changeCell(2,3, Cell.EMPTY);
    josiah.changeCell(2,4, Cell.EMPTY);
    josiah.changeCell(2,5, Cell.EMPTY);
    josiah.changeCell(2,6, Cell.EMPTY);
    Assert.assertEquals(""
            + "    _ _ _\n"
            + "    _ _ _\n"
            + "_ _ _ _ _ _ _\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "    O O O\n"
            + "    O O O", josiah.toString());
    helperGame(josiah);
    Assert.assertEquals(""
            + "    _ _ _\n"
            + "    _ _ _\n"
            + "_ _ _ _ _ _ _\n"
            + "_ _ _ _ _ _ _\n"
            + "_ _ _ _ _ _ _\n"
            + "    _ _ _\n"
            + "    _ _ _", josiah.toString());
  }

  /**
   * Test for the hasMove() method.
   */
  @Test
  public void testIsGameOver() {
    helperGame(josiah);
    Assert.assertTrue(josiah.isGameOver());
    josiah.changeCell(0,3, Cell.PEG);
    josiah.changeCell(1,3, Cell.PEG);
    Assert.assertFalse(josiah.isGameOver());
    josiah.changeCell(1,3, Cell.EMPTY);
    josiah.changeCell(2,3, Cell.PEG);
    Assert.assertTrue(josiah.isGameOver());
    josiah.changeCell(0,2, Cell.PEG);
    josiah.changeCell(0,4, Cell.PEG);
    Assert.assertTrue(josiah.isGameOver());
    josiah.changeCell(0,2, Cell.EMPTY);
    josiah.changeCell(0,4, Cell.EMPTY);
    josiah.changeCell(0,3, Cell.EMPTY);
    josiah.changeCell(2,3, Cell.EMPTY);
    josiah.changeCell(4,0, Cell.PEG);
    Assert.assertTrue(josiah.isGameOver());
    josiah.changeCell(6,4, Cell.PEG);
    Assert.assertTrue(josiah.isGameOver());
    josiah.changeCell(3,3, Cell.PEG);
    josiah.changeCell(2,6, Cell.PEG);
    josiah.changeCell(3,6, Cell.PEG);
    Assert.assertFalse(josiah.isGameOver());
    Board alessia = new Board(5);
    helperGame(alessia);
    Assert.assertTrue(alessia.isGameOver());
    alessia.changeCell(5,12, Cell.PEG);
    alessia.changeCell(5,11, Cell.PEG);
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