package tdd;

import mocking.MockScoreDB;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Hangman {

    public static final int MAX_TRIALS = 10;
    public int remainingTrials;
    public int score = 0;
    Set<String> usedWordsSet = new HashSet<>();
    List<String> wordsList = new ArrayList<>();

    MockScoreDB mockScoreDB;

    public Hangman(MockScoreDB mockScoreDB) {
        this.mockScoreDB = mockScoreDB;
    }


    public int countAlphabetInAWord(String word, char alphabet) {
        int result = 0;

        for (char c : word.toCharArray()) {
            if (c == alphabet) {
                result++;
            }
        }

        return result;
    }

    public void loadWords() {
        String word = null;
        try (BufferedReader br = new BufferedReader(new FileReader("WordSource.txt"))) {
            while ((word = br.readLine()) != null) {
                wordsList.add(word);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String randomFetchedWord(int expectedLength) {
        String result = null;
        remainingTrials = MAX_TRIALS;
        for (String word : wordsList) {
            if (word.length() != expectedLength) {
                continue;
            } else if (usedWordsSet.add(word)) {
                result = word;
                break;
            }
        }
        return result;
    }

    public String generateClue(String word) {
        StringBuilder clue = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            clue.append("-");
        }
        return clue.toString();
    }

    public String generateClue(String word, String clue, char guess) {
        remainingTrials--;
        if (guess >= 'A' && guess <= 'Z') guess += 32;
        if (guess < 'a' || guess > 'z') throw new IllegalArgumentException("Invalid Character");

        StringBuilder newClue = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            if (guess == word.charAt(i) && guess != clue.charAt(i)) {
                newClue.append(guess);
                score += (double) MAX_TRIALS / word.length();
            } else newClue.append(clue.charAt(i));
        }
        return newClue.toString();
    }

    public boolean saveWordScore(String word, int score) {
        return mockScoreDB.writeScoreDB(word, score);
    }
}
