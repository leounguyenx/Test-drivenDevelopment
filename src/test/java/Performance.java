import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tdd.Hangman;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Performance {
    public static Hangman hangman;
    public static Random random;
    int requestedLength;

    @BeforeAll
    static void setupClass() {
        random = new Random();
        //hangman = new Hangman();
        hangman.loadWords();
    }

    @BeforeEach
    public void setupTest() {
        requestedLength = random.nextInt(6) + 5;
        hangman.score = 0;
    }

    @Test
    void test_remainingTrialsBeforeAnyGuess() {
        hangman.randomFetchedWord(requestedLength);

        assertEquals(hangman.MAX_TRIALS,hangman.remainingTrials);
    }

    @Test
    void test_remainingTrialsAfterOneGuess() {
        hangman.randomFetchedWord(requestedLength);
        hangman.generateClue("pizza", "-----", 'a');
        assertEquals(Hangman.MAX_TRIALS - 1, hangman.remainingTrials);
    }

    @Test
    void test_scoreBeforeAnyGuess() {
        hangman.randomFetchedWord(requestedLength);
        assertEquals(0, hangman.score);
    }

    @Test
    void test_scoreAfterCorrectGuess() {
        String word = "pizza";
        String clue = "-----";
        char guess = 'a';
        hangman.generateClue(word, clue, guess);
        assertEquals((double) Hangman.MAX_TRIALS/word.length(), hangman.score);
    }

    @Test
    void test_scoreAfterIncorrectGuess() {
        String word = "pizza";
        String clue = "-----";
        char guess = 'x';
        hangman.generateClue(word, clue, guess);
        assertEquals(0, hangman.score);
    }
}
