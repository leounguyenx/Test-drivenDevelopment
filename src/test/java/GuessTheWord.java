import org.junit.jupiter.api.Test;
import tdd.Hangman;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GuessTheWord {
    /*
    Given: A word "pizza"
    And: 10 times to guess
    Then: Return -----

    When: User enters correct guess: a
    Then: Returns ----a

    When: User enters wrong guess: o
    Then: Returns ----- (Old clue without any changes)
    And: -1 guess time
    */

    @Test
    void test_fetchClueBeforeAnyGuess() {
        Hangman hangman = new Hangman();
        String clue = hangman.generateClue("pizza");
        assertEquals("-----", clue);
    }

    @Test
    void  test_fetchClueAfterCorrectGuess() {
        Hangman hangman = new Hangman();
        String clue = hangman.generateClue("pizza");

        String newClue = hangman.generateClue("pizza", clue, 'a');


        assertEquals("----a", newClue);
    }

    @Test
    void  test_fetchClueAfterWrongGuess() {
        Hangman hangman = new Hangman();
        String clue = hangman.generateClue("pizza");

        String newClue = hangman.generateClue("pizza", clue, 'b');


        assertEquals("-----", newClue);
    }
}
