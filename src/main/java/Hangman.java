public class Hangman {
    public int countAlphabetInAWord(String word, char alphabet) {
        int result = 0;

        for (char c : word.toCharArray()){
            if (c == alphabet) {
                result++;
            }
        }

        return result;
    }

    public String fetchedWord() {
        return "pizza";
    }

    public String randomFetchedWord(int expectedLength) {
        switch (expectedLength) {
            case 5: return "pizza";
            case 6: return "cheese";
            case 7: return "chicken";
            case 8: return "tomatoes";
            case 9: return "pineapple";
            case 10: return "mozzarella";
            default: return null;
        }
    }
}
