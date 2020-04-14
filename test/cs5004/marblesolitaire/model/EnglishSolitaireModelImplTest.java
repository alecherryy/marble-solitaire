package cs5004.marblesolitaire.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * These are test cases for the Marble Solitaire class.
 */
public class EnglishSolitaireModelImplTest {
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
    MarbleSolitaireModel josiah = new EnglishSolitaireModelImpl();
    Assert.assertEquals(32, josiah.getScore());
    Assert.assertEquals(""
            + "    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O", josiah.getGameState());
  }

  /**
   * Test for the second class constructor.
   */
  @Test
  public void testSecondConstructor() {
    alessia = new EnglishSolitaireModelImpl(0,2);
    Assert.assertEquals(""
            + "    _ O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O O O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O", alessia.getGameState());
    kevin = new EnglishSolitaireModelImpl(4,3);
    Assert.assertEquals(""
            + "    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "    O O O\n"
            + "    O O O", kevin.getGameState());
  }

  /**
   * Test for the third class constructor.
   */
  @Test
  public void testThirdConstructor() {
    MarbleSolitaireModel josiah = new EnglishSolitaireModelImpl(3);
    Assert.assertEquals(32, josiah.getScore());
    Assert.assertEquals(""
            + "    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O", josiah.getGameState());
    MarbleSolitaireModel clara = new EnglishSolitaireModelImpl(5);
    Assert.assertEquals(104, clara.getScore());
    Assert.assertFalse(clara.isGameOver());
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
            + "        O O O O O", clara.getGameState());
  }

  /**
   * Test for the fourth class constructor.
   */
  @Test
  public void testFourthConstructor() {
    josiah = new EnglishSolitaireModelImpl(3,3,6);
    Assert.assertEquals(""
            + "    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O O O O _\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O", josiah.getGameState());
    kevin = new EnglishSolitaireModelImpl(3,2,6);
    Assert.assertEquals(""
            + "    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O O O O _\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O", josiah.getGameState());
    alessia = new EnglishSolitaireModelImpl(3, 0,2);
    Assert.assertEquals(""
            + "    _ O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O O O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O", alessia.getGameState());
    jenn = new EnglishSolitaireModelImpl(5, 2,5);
    Assert.assertEquals(""
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "        O _ O O O\n"
            + "        O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O", jenn.getGameState());
    chandler = new EnglishSolitaireModelImpl(3, 3,6);
    Assert.assertEquals(""
            + "    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O O O O _\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O", chandler.getGameState());
  }

  /**
   * Test for class constructors exceptions.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testInvalidClassConstructor() {
    josiah = new EnglishSolitaireModelImpl(4);
    jenn = new EnglishSolitaireModelImpl(-3);
    chandler = new EnglishSolitaireModelImpl(0,0);
    kevin = new EnglishSolitaireModelImpl(4, 3,3);
    chris = new EnglishSolitaireModelImpl(5, 0,0);
    josiah = new EnglishSolitaireModelImpl(-2);
    jenn = new EnglishSolitaireModelImpl(0);
    chandler = new EnglishSolitaireModelImpl(6,5);
    kevin = new EnglishSolitaireModelImpl(0, 0,0);
    chris = new EnglishSolitaireModelImpl(4,2);
    josiah = new EnglishSolitaireModelImpl(4,0);
  }

  /**
   * Test for isGameOver() method.
   */
  @Test
  public void testIsGameOver() {
    chris = new EnglishSolitaireModelImpl();
    Assert.assertFalse(chris.isGameOver());
    alessia = new EnglishSolitaireModelImpl(5);
    Assert.assertFalse(alessia.isGameOver());
    jenn = new EnglishSolitaireModelImpl(3,6);
    Assert.assertFalse(jenn.isGameOver());
    chandler = new EnglishSolitaireModelImpl(5,4, 4);
    Assert.assertFalse(chandler.isGameOver());
    kevin = new EnglishSolitaireModelImpl();
    Assert.assertFalse(kevin.isGameOver());
  }

  /**
   * Test for move() method.
   */
  @Test
  public void testMove() {
    josiah = new EnglishSolitaireModelImpl();
    josiah.move(3,5, 3,3);
    Assert.assertEquals(31, josiah.getScore());
    josiah.move(3,2, 3,4);
    Assert.assertEquals(30, josiah.getScore());
    josiah.move(3,0, 3,2);
    Assert.assertEquals(29, josiah.getScore());
    josiah.move(5,3, 3,3);
    Assert.assertEquals(28, josiah.getScore());
    josiah.move(3,3, 5,3);
    Assert.assertEquals(27, josiah.getScore());
    chandler = new EnglishSolitaireModelImpl(5, 0, 6);
    chandler.move(0, 4, 0, 6);
    Assert.assertEquals(103, chandler.getScore());
  }

  /**
   * Test for getGameState() method.
   */
  @Test
  public void testGetGameState() {
    kevin = new EnglishSolitaireModelImpl();
    Assert.assertEquals(""
            + "    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O", kevin.getGameState());
    kevin.move(1,3, 3,3);
    Assert.assertEquals(""
            + "    O O O\n"
            + "    O _ O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O", kevin.getGameState());
    kevin.move(4,3, 2,3);
    Assert.assertEquals(""
            + "    O O O\n"
            + "    O _ O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O _ O O O\n"
            + "    O O O\n"
            + "    O O O", kevin.getGameState());
    kevin.move(4,1, 4,3);
    Assert.assertEquals(""
            + "    O O O\n"
            + "    O _ O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O _ _ O O O O\n"
            + "    O O O\n"
            + "    O O O", kevin.getGameState());
    kevin.move(2,1, 4,1);
    Assert.assertEquals(""
            + "    O O O\n"
            + "    O _ O\n"
            + "O _ O O O O O\n"
            + "O _ O _ O O O\n"
            + "O O _ O O O O\n"
            + "    O O O\n"
            + "    O O O", kevin.getGameState());
    chandler = new EnglishSolitaireModelImpl(3, 0, 4);
    Assert.assertEquals(""
            + "    O O _\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O O O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O", chandler.getGameState());
    alessia = new EnglishSolitaireModelImpl(5, 0, 6);
    alessia.move(0, 4, 0, 6);
    Assert.assertEquals(""
            + "        _ _ O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O", alessia.getGameState());
  }

  /**
   * Set up class to test invalid move.
   */
  @Before
  public void setUp() {
    chris = new EnglishSolitaireModelImpl();
    chris.move(3,5, 3,3);
    chris.move(3,2, 3,4);
    chris.move(3,0, 3,2);
    chris.move(5,3, 3,3);
    chris.move(3,3, 5,3);
  }

  /**
   * Test for class move() exceptions.
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