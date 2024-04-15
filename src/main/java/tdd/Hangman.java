package tdd;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Hangman {

    Set<String> usedWordsSet = new HashSet<>();
    List<String> wordsList = new ArrayList<>();


    public int countAlphabetInAWord(String word, char alphabet) {
        int result = 0;

        for (char c : word.toCharArray()){
            if (c == alphabet) {
                result++;
            }
        }

        return result;
    }

    public void loadWords(){
        String word = null;
        try (BufferedReader br = new BufferedReader(new FileReader("WordSource.txt"))){
            while ((word = br.readLine()) != null) {
                wordsList.add(word);
            }
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String randomFetchedWord(int expectedLength) {
        for (String result : wordsList) {
            if (result.length() != expectedLength){
                continue;
            } else if (usedWordsSet.add(result)) {
                return result;
            }
        }
        return null;
    }

    public String generateClue(String word) {
        StringBuilder clue = new StringBuilder();
        for (int i = 0; i < word.length(); i++){
            clue.append("-");
        }
        return clue.toString();
    }

    public String generateClue(String word, String clue, char guess) {
        StringBuilder newClue = new StringBuilder();
        for (int i = 0; i < word.length(); i++){
            if (guess == word.charAt(i) && guess != clue.charAt(i)){
                newClue.append(guess);
            }
            else newClue.append(clue.charAt(i));
        }
        return newClue.toString();
    }

}
