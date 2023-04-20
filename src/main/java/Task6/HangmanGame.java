package Task6;

import java.util.Random;
import java.util.Scanner;
//Task6
public class HangmanGame {
    public static void main(String[] args) {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

        Random random = new Random();
        String targetWord = words[random.nextInt(words.length)];
        String guessedWord = "";

        for (int i = 0; i < targetWord.length(); i++) {
            guessedWord += "#";
        }

        Scanner scanner = new Scanner(System.in);
        boolean isGuessed = false;

        while (!isGuessed) {
            System.out.println("Guess the word: " + guessedWord);
            String guess = scanner.nextLine();

            if (guess.equals(targetWord)) {
                System.out.println("You guessed the word! Congratulations!");
                isGuessed = true;
            } else {
                for (int i = 0; i < targetWord.length() && i < guess.length(); i++) {
                    if (guess.charAt(i) == targetWord.charAt(i)) {
                        guessedWord = guessedWord.substring(0, i) + guess.charAt(i) + guessedWord.substring(i + 1);
                    }
                }
            }
        }
    }
}
