package cs5004.marblesolitaire.model.hw09;

import cs5004.marblesolitaire.model.MarbleSolitaireModel;

import org.junit.Assert;
import org.junit.Test;

/**
 * These are test cases for the Triangle Marble Solitaire class.
 */
public class TriangleSolitaireModelImplTest {
  private MarbleSolitaireModel josiah;
  private MarbleSolitaireModel alessia;
  private MarbleSolitaireModel kevin;
  private MarbleSolitaireModel jenn;
  private MarbleSolitaireModel chandler;
  private MarbleSolitaireModel chris;

  /**
   * Test for the first class constructor.
   */
  @Test
  public void testFirstConstructor() {
    josiah = new TriangleSolitaireModelImpl();
    Assert.assertEquals(14, josiah.getScore());
    Assert.assertEquals(""
            + "    _\n"
            + "   O O\n"
            + "  O O O\n"
            + " O O O O\n"
            + "O O O O O", josiah.getGameState());
  }

  /**
   * Test for the second class constructor.
   */
  @Test
  public void testSecondConstructor() {
    alessia = new TriangleSolitaireModelImpl(1,1);
    Assert.assertEquals(""
            + "    O\n"
            + "   O _\n"
            + "  O O O\n"
            + " O O O O\n"
            + "O O O O O", alessia.getGameState());
    kevin = new TriangleSolitaireModelImpl(4,4);
    Assert.assertEquals(""
            + "    O\n"
            + "   O O\n"
            + "  O O O\n"
            + " O O O O\n"
            + "O O O O _", kevin.getGameState());
  }

  /**
   * Test for the third class constructor.
   */
  @Test
  public void testThirdConstructor() {
    chris = new TriangleSolitaireModelImpl(5);
    Assert.assertEquals(14, chris.getScore());
    Assert.assertEquals(""
            + "    _\n"
            + "   O O\n"
            + "  O O O\n"
            + " O O O O\n"
            + "O O O O O", chris.getGameState());
    chandler = new TriangleSolitaireModelImpl(7);
    Assert.assertEquals(""
            + "      _\n"
            + "     O O\n"
            + "    O O O\n"
            + "   O O O O\n"
            + "  O O O O O\n"
            + " O O O O O O\n"
            + "O O O O O O O", chandler.getGameState());
  }

  /**
   * Test for the fourth class constructor.
   */
  @Test
  public void testFourthConstructor() {
    josiah = new TriangleSolitaireModelImpl(5,2,2);
    Assert.assertEquals(""
            + "    O\n"
            + "   O O\n"
            + "  O O _\n"
            + " O O O O\n"
            + "O O O O O", josiah.getGameState());
    kevin = new TriangleSolitaireModelImpl(7,6,3);
    Assert.assertEquals(""
            + "      O\n"
            + "     O O\n"
            + "    O O O\n"
            + "   O O O O\n"
            + "  O O O O O\n"
            + " O O O O O O\n"
            + "O O O _ O O O", kevin.getGameState());
    alessia = new TriangleSolitaireModelImpl(6, 4,4);
    Assert.assertEquals(""
            + "     O\n"
            + "    O O\n"
            + "   O O O\n"
            + "  O O O O\n"
            + " O O O O _\n"
            + "O O O O O O", alessia.getGameState());
  }

  /**
   * Test for class constructors exceptions.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testInvalidClassConstructor() {
    josiah = new TriangleSolitaireModelImpl(4);
    jenn = new TriangleSolitaireModelImpl(-3);
    chandler = new EuropeanSolitaireModelImpl(6,2);
    kevin = new TriangleSolitaireModelImpl(8, 8,8);
    chris = new TriangleSolitaireModelImpl(0,-2);
  }

  /**
   * Test for move() method.
   */
  @Test
  public void testMove() {
    chandler = new TriangleSolitaireModelImpl(5, 2, 2);
    Assert.assertEquals(""
            + "    O\n"
            + "   O O\n"
            + "  O O _\n"
            + " O O O O\n"
            + "O O O O O", chandler.getGameState());
    chandler.move(4,2, 2, 2);
    chandler.move(4,4, 4, 2);
    chandler.move(2,2, 4, 4);
    chandler.move(2,0, 2, 2);
    chandler.move(0,0, 2, 0);
    chandler.move(3,0, 1, 0);
    chandler.move(1,1, 3, 3);
    chandler.move(4,2, 2, 0);
    chandler.move(1,0, 3, 0);
    chandler.move(4,0, 2, 0);
    chandler.move(4,4, 2, 2);
    Assert.assertEquals(""
            + "    _\n"
            + "   _ _\n"
            + "  O _ O\n"
            + " _ _ _ _\n"
            + "_ O _ _ _", chandler.getGameState());
    Assert.assertEquals(3, chandler.getScore());
    Assert.assertTrue(chandler.isGameOver());
  }

  /**
   * Test for class move() exceptions.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testInvalidMove() {
    jenn = new TriangleSolitaireModelImpl(7);
    // jumps 3 rows diagonal
    jenn.move(-2,3, 0, 0);
    // vertical move
    jenn.move(2,1, 0,0);
    // from empty cell
    jenn.move(0,0, 2,2);
    // occupied cell, invalid dest
    jenn.move(2,0, 1,0);
    // occupied cell, jumps 4
    jenn.move(6,6, 8,8);
  }
}