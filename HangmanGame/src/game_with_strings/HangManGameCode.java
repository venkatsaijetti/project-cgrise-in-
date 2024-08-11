package game_with_strings;

import java.util.Random;
import java.util.Scanner;

public class HangManGameCode {
	private static final String[] words = {"hangman", "java", "cognorise", "infotech", "eclipse"};
	private static final int max_attempts = 10;
	private static final int max_rounds = 3;
	private static int totalScore = 0;
	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		Random random = new Random();
		System.out.println("WELCOME TO THE HANGMAN GAME");
		System.out.println("You have "+max_rounds + " rounds to play this game.");
		for(int round = 1; round <= max_rounds; round++) {
			System.out.println("\nRound "+ round + " of "+ max_rounds);
			String wordToGuess = words[random.nextInt(words.length)];
			playGame(wordToGuess);
		}
		endGame();
	}
	private static void playGame(String word) {
		char[] letter = new char[word.length()];
		for(int i=0; i<word.length(); i++) {
			letter[i] = '_';
		}
		int attempts = 0;
		boolean wordGuessed = false;
		boolean[] guessedLetters = new boolean[26];
		
		while(attempts < max_attempts && !wordGuessed) {
			System.out.println("\nWord: ");
			for(char c : letter) {
				System.out.print(c + " ");
			}
			System.out.println("Guess a Letter: ");
			String input = scanner.next().toLowerCase();
			char guess = input.length() == 1 ? input.charAt(0) : '?';
		//har guess = scanner.next().toLowerCase().charAt(0);
			if(!Character.isLetter(guess) || guessedLetters[guess - 'a']) {
				System.out.println("Invalid Guess. or Already Guessed that letter.");
				continue;
			}
			guessedLetters[guess - 'a'] = true;
			attempts++;
		
			boolean correctGuess = false;
			for(int i=0; i<word.length(); i++) {
				if(word.charAt(i) == guess) {
				letter[i] = guess;
				correctGuess = true;
			}
		}
		if(!correctGuess) {
			System.out.println("Incorrect Guess! You have " +(max_attempts - attempts)+ " left");
		}
		wordGuessed = true;
		for(char c : letter) {
			if(c == '_') {
				wordGuessed = false;
				break;
			}
		}
	}
	if(wordGuessed) {
		int score = max_attempts - attempts;
		totalScore += score;
		System.out.println("Heyy Congrats. You have guessed the word correctly: "+word);
		System.out.println("You took " +attempts + " attempts. and You scored: "+score);
	}else {
		System.out.println("Game Over!!! The Word is: "+word);
	}
}
private static void endGame() {
	System.out.println("Thank you for playing!");
	System.out.println("Your final score is: "+totalScore);
}
}