import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tdd.Hangman;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class GuessTheWord {
    public static Hangman hangman;
    public static Random random;
    int requestedLength;

    @BeforeAll
    static void setupClass() {
        random = new Random();
        hangman = new Hangman();
        hangman.loadWords();
    }

    @BeforeEach
    public void setupTest() {
        requestedLength = random.nextInt(6) + 5;
    }
    @Test
    void test_fetchClueBeforeAnyGuess() {
        String clue = hangman.generateClue("pizza");
        assertEquals("-----", clue);
    }

    @Test
    void  test_fetchClueAfterCorrectGuess() {
        String clue = hangman.generateClue("pizza");
        String newClue = hangman.generateClue("pizza", clue, 'a');

        assertEquals("----a", newClue);
    }

    @Test
    void  test_fetchClueAfterWrongGuess() {
        String clue = hangman.generateClue("pizza");

        String newClue = hangman.generateClue("pizza", clue, 'b');

        assertEquals("-----", newClue);
    }

    @Test
    void test_whenInvalidGuessThenThrowsException() {
        assertThrows(IllegalArgumentException.class,
                () -> hangman.generateClue("pizza", "-----", '1'));
    }

    @Test
    void test_whenInvalidGuessThenThrowsExceptionWithMessage() {
        Exception e = assertThrows(IllegalArgumentException.class,
                () -> hangman.generateClue("pizza", "-----", '1'));
        assertEquals("Invalid Character", e.getMessage());
    }
}
