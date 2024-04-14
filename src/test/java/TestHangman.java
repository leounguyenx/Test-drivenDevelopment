import org.junit.jupiter.api.Test;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
public class TestHangman {
    @Test
    void test_AlphabetCountInAWord() {
        String word = "pizza";
        char alphabet = 'a';

        Hangman hangman = new Hangman();
        int count = hangman.countAlphabetInAWord(word, alphabet);

        assertEquals(1, count);
    }

    @Test
    void test_CountFetchedWord() {
        Hangman hangman = new Hangman();
        String word = hangman.fetchedWord();

        int count = word.length();
        assertEquals(5,count);
    }

    @Test
    void test_CountRandomFetchedWord() {
        //From 5-10
        Random random = new Random();
        int expectedLength = random.nextInt(6) + 5;

        Hangman hangman = new Hangman();
        String randomWord = hangman.randomFetchedWord(expectedLength);

        assertEquals(expectedLength, randomWord.length());
    }
}


/**
 *
 * Steps of TDD in Agile
 * Write a failing test: In TDD, developers start by writing a test case that fails. This test case should be based on the requirements provided by the customer.
 * Write code: The next step is to write the code to make the test pass. This code should be minimal and focused **only on passing the test**.
 * Refactor: Once the test has passed, developers can refactor the code to improve its design and remove duplication.
 * Repeat: Finally, developers should repeat the process by writing a new failing test and following the same steps until all requirements have been met.
 *
 *
 * */