package cs5004.marblesolitaire.model.hw09;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import cs5004.marblesolitaire.model.MarbleSolitaireModel;

/**
 * These are test cases for the European Marble Solitaire class.
 */
public class EuropeanSolitaireModelImplTest {
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
    josiah = new EuropeanSolitaireModelImpl();
    Assert.assertEquals(36, josiah.getScore());
    Assert.assertEquals(""
            + "    O O O\n"
            + "  O O O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "  O O O O O\n"
            + "    O O O", josiah.getGameState());
  }

  /**
   * Test for the second class constructor.
   */
  @Test
  public void testSecondConstructor() {
    alessia = new EuropeanSolitaireModelImpl(0,2);
    Assert.assertEquals(""
            + "    _ O O\n"
            + "  O O O O O\n"
            + "O O O O O O O\n"
            + "O O O O O O O\n"
            + "O O O O O O O\n"
            + "  O O O O O\n"
            + "    O O O", alessia.getGameState());
    kevin = new EuropeanSolitaireModelImpl(4,3);
    Assert.assertEquals(""
            + "    O O O\n"
            + "  O O O O O\n"
            + "O O O O O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "  O O O O O\n"
            + "    O O O", kevin.getGameState());
  }

  /**
   * Test for the third class constructor.
   */
  @Test
  public void testThirdConstructor() {
    chris = new EuropeanSolitaireModelImpl(3);
    Assert.assertEquals(36, chris.getScore());
    Assert.assertEquals(""
            + "    O O O\n"
            + "  O O O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "  O O O O O\n"
            + "    O O O", chris.getGameState());
    chandler = new EuropeanSolitaireModelImpl(5);
    Assert.assertEquals(128, chandler.getScore());
    Assert.assertFalse(chandler.isGameOver());
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
            + "        O O O O O", chandler.getGameState());
  }

  /**
   * Test for the fourth class constructor.
   */
  @Test
  public void testFourthConstructor() {
    josiah = new EuropeanSolitaireModelImpl(3,3,6);
    Assert.assertEquals(""
            + "    O O O\n"
            + "  O O O O O\n"
            + "O O O O O O O\n"
            + "O O O O O O _\n"
            + "O O O O O O O\n"
            + "  O O O O O\n"
            + "    O O O", josiah.getGameState());
    kevin = new EuropeanSolitaireModelImpl(3,1,5);
    Assert.assertEquals(""
            + "    O O O\n"
            + "  O O O O _\n"
            + "O O O O O O O\n"
            + "O O O O O O O\n"
            + "O O O O O O O\n"
            + "  O O O O O\n"
            + "    O O O", kevin.getGameState());
    alessia = new EuropeanSolitaireModelImpl(3, 5,1);
    Assert.assertEquals(""
            + "    O O O\n"
            + "  O O O O O\n"
            + "O O O O O O O\n"
            + "O O O O O O O\n"
            + "O O O O O O O\n"
            + "  _ O O O O\n"
            + "    O O O", alessia.getGameState());
    jenn = new EuropeanSolitaireModelImpl(5, 3,7);
    Assert.assertEquals(""
            + "        O O O O O\n"
            + "      O O O O O O O\n"
            + "    O O O O O O O O O\n"
            + "  O O O O O O _ O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "  O O O O O O O O O O O\n"
            + "    O O O O O O O O O\n"
            + "      O O O O O O O\n"
            + "        O O O O O", jenn.getGameState());
    chandler = new EuropeanSolitaireModelImpl(3, 6,3);
    Assert.assertEquals(""
            + "    O O O\n"
            + "  O O O O O\n"
            + "O O O O O O O\n"
            + "O O O O O O O\n"
            + "O O O O O O O\n"
            + "  O O O O O\n"
            + "    O _ O", chandler.getGameState());
  }

  /**
   * Test for class constructors exceptions.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testInvalidClassConstructor() {
    josiah = new EuropeanSolitaireModelImpl(0);
    jenn = new EuropeanSolitaireModelImpl(2);
    kevin = new EuropeanSolitaireModelImpl(6);
    chandler = new EuropeanSolitaireModelImpl(0,0);
    kevin = new EuropeanSolitaireModelImpl(4, 3,3);
    chris = new EuropeanSolitaireModelImpl(5, 0,0);
    josiah = new EuropeanSolitaireModelImpl(10);
    jenn = new EuropeanSolitaireModelImpl(-5);
    chandler = new EuropeanSolitaireModelImpl(-4,5);
    kevin = new EuropeanSolitaireModelImpl(0, 0,0);
    chris = new EuropeanSolitaireModelImpl(6,6);
  }

  /**
   * Test for isGameOver() method.
   */
  @Test
  public void testIsGameOver() {
    chris = new EuropeanSolitaireModelImpl();
    Assert.assertFalse(chris.isGameOver());
    kevin = new EuropeanSolitaireModelImpl();
    Assert.assertFalse(kevin.isGameOver());
  }

  /**
   * Test for move() method.
   */
  @Test
  public void testMove() {
    josiah = new EuropeanSolitaireModelImpl();
    josiah.move(3,5, 3,3);
    Assert.assertEquals(35, josiah.getScore());
    josiah.move(5,4, 3,4);
    Assert.assertEquals(34, josiah.getScore());
    josiah.move(3,3, 3,5);
    Assert.assertEquals(33, josiah.getScore());
  }

  /**
   * Test for getGameState() method.
   */
  @Test
  public void testGetGameState() {
    kevin = new EuropeanSolitaireModelImpl();
    Assert.assertEquals(""
            + "    O O O\n"
            + "  O O O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "  O O O O O\n"
            + "    O O O", kevin.getGameState());
    kevin.move(1,3, 3,3);
    Assert.assertEquals(""
            + "    O O O\n"
            + "  O O _ O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "O O O O O O O\n"
            + "  O O O O O\n"
            + "    O O O", kevin.getGameState());
    kevin.move(4,3, 2,3);
    Assert.assertEquals(""
            + "    O O O\n"
            + "  O O _ O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O _ O O O\n"
            + "  O O O O O\n"
            + "    O O O", kevin.getGameState());
    kevin.move(4,1, 4,3);
    Assert.assertEquals(""
            + "    O O O\n"
            + "  O O _ O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O _ _ O O O O\n"
            + "  O O O O O\n"
            + "    O O O", kevin.getGameState());
    kevin.move(2,1, 4,1);
    Assert.assertEquals(""
            + "    O O O\n"
            + "  O O _ O O\n"
            + "O _ O O O O O\n"
            + "O _ O _ O O O\n"
            + "O O _ O O O O\n"
            + "  O O O O O\n"
            + "    O O O", kevin.getGameState());
    chandler = new EuropeanSolitaireModelImpl(3, 0, 4);
    Assert.assertEquals(""
            + "    O O _\n"
            + "  O O O O O\n"
            + "O O O O O O O\n"
            + "O O O O O O O\n"
            + "O O O O O O O\n"
            + "  O O O O O\n"
            + "    O O O", chandler.getGameState());
  }

  /**
   * Set up class to test invalid move.
   */
  @Before
  public void setUp() {
    chris = new EuropeanSolitaireModelImpl();
    chris.move(3,5, 3,3);
    chris.move(3,2, 3,4);
    chris.move(3,0, 3,2);
    chris.move(5,3, 3,3);
    chris.move(3,3, 5,3);
  }

  /**
   * Test for class constructors exceptions.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testInvalidMove() {
    // jumps 3 col
    chris.move(0,3, 3,3);
    // diagonal move
    chris.move(4,6, 3,5);
    // from empty cell
    chris.move(3,1, 3,3);
    // occupied cell, invalid dest
    chris.move(5,4, 4,6);
    // occupied cell, jumps 4
    chris.move(0,3, 4,3);
    // different col and row
    chris.move(5,4, 4,3);
    // negative row
    chris.move(-2,2, 1,0);
    // negative col
    chris.move(2,0, 2,-2);
    // empty cell
    chris.move(3,3, 5,3);
  }
}