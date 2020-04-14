package cs5004.marblesolitaire;

import cs5004.marblesolitaire.model.EnglishSolitaireModelImpl;
import cs5004.marblesolitaire.model.MarbleSolitaireModel;
import cs5004.marblesolitaire.model.hw09.EuropeanSolitaireModelImpl;
import cs5004.marblesolitaire.model.hw09.TriangleSolitaireModelImpl;

/**
 * This is the MarbleSolitaire class. It contains the main()
 * function to allow users to choose a board.
 */
public class MarbleSolitaire {

  /**
   * Main function.
   */
  public static void main(String[] args) {
    MarbleSolitaireModel game = null;
    String board = args[0];
    String size = "";
    String row = "";
    String col = "";
    String token;

    for (int i = 0; i < args.length - 1; i++) {
      token = args[i];

      // parse the command line input
      switch (token) {
        case "-size":
          size = args[i + 1];
          break;
        case "-hole":
          row = args[i + 1];
          col = args[i + 2];
          break;
        default:
          break;
      }
    }
    if (args.length == 1) {
      switch (board) {
        case "english":
          game = new EnglishSolitaireModelImpl();
          break;
        case "european":
          game = new EuropeanSolitaireModelImpl();
          break;
        case "triangular":
          game = new TriangleSolitaireModelImpl();
          break;
        default:
          throw new IllegalArgumentException(""
                  + "Invalid terminal input. Board must be: english, european or triangular");
      }
    }
    else {
      if (!size.equals("") && row.equals("")) {
        switch (board) {
          case "english":
            game = new EnglishSolitaireModelImpl(Integer.parseInt(size));
            break;
          case "european":
            game = new EuropeanSolitaireModelImpl(Integer.parseInt(size));
            break;
          case "triangular":
            game = new TriangleSolitaireModelImpl(Integer.parseInt(size));
            break;
          default:
        }
      }
      else if (size.equals("") && !row.equals("")) {
        switch (board) {
          case "english":
            game = new EnglishSolitaireModelImpl(Integer.parseInt(row), Integer.parseInt(col));
            break;
          case "european":
            game = new EuropeanSolitaireModelImpl(Integer.parseInt(row), Integer.parseInt(col));
            break;
          case "triangular":
            game = new TriangleSolitaireModelImpl(Integer.parseInt(row), Integer.parseInt(col));
            break;
          default:
            break;
        }
      }
      else {
        switch (board) {
          case "english":
            game = new EnglishSolitaireModelImpl(Integer.parseInt(size),
                    Integer.parseInt(row), Integer.parseInt(col));
            break;
          case "european":
            game = new EuropeanSolitaireModelImpl(Integer.parseInt(size),
                    Integer.parseInt(row), Integer.parseInt(col));
            break;
          case "triangular":
            game = new TriangleSolitaireModelImpl(Integer.parseInt(size),
                    Integer.parseInt(row), Integer.parseInt(col));
            break;
          default:
            break;
        }
      }
    }
  }
}
