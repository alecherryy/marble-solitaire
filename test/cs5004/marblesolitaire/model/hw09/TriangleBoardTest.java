package cs5004.marblesolitaire.model.hw09;

import org.junit.Assert;
import org.junit.Test;

import cs5004.marblesolitaire.model.hw09.Board;

import static org.junit.Assert.assertEquals;

public class TriangleBoardTest {
  private Board jenn = new TriangleBoard();

  /**
   * Test for the class constructor.
   */
  @Test
  public void newEuropeanBoard() {
    Assert.assertEquals(""
            + "      O\n"
            + "     O O\n"
            + "    O O O\n"
            + "   O O O O\n"
            + "  O O O O O\n"
            + " O O O O O O\n"
            + "O O O O O O O\n", jenn.toString());
    Assert.assertEquals(28, jenn.countPegs());
  }
}