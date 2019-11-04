package inlämning;

import java.util.Objects;

public class Guesser {
	private int low;
	private int high;

	/*
	 * Task 1. Write code here for a constructor which takes two int arguments and
	 * saves them in the instance variables low and high.
	 *
	 * If you don't remember the syntax for how to write constructors, revisit the
	 * chapter "Classes" and review the section about constructors.
	 *
	 */

	// Write the constructor below this line.
	public Guesser(int low, int high) {
		this.low = 0;
		this.high = 1000;

	}

	/*
	 * Task 2. Complete the start() method, so that in the method body, you call
	 * first the rules() method, next the doGuesses() method.
	 */
	public void start() {
		rules();
		doGuesses();
	}

	private void rules() {
		System.out.println("Think of a number between " + low + " and " + high);
		System.out.println("I'm going to ask a few questions in order " + "to guess the number.");
		System.out.println("Please answer T for true, and F for false.\n");
	}

	
	private String getReply() {
		String reply;
		reply = System.console().readLine();

		while (Objects.equals(reply, "F") && Objects.equals(reply, "F")) {
			System.out.println("One of T and F");
			reply = System.console().readLine();
		}
		return reply;

	}

	private void doGuesses() {
		int i = 0; // number of guesses
		int middle = 0;
		while (low < high) {
			// Set next guess to the middle between
			// current low and current high
			middle = low + (high - low) / 2;

			System.out.println("Is the number less than or equal to " + middle + "?");
			String reply = getReply();
			if ("T".equals(reply)) {
				// The number is less than or equal to middle
				// so we move down high to middle
				high = middle;
			} else {
				// The number is greater than middle,
				// so we move up low to middle + 1
				low = middle + 1;
			}
			i++; // One more guess!
		}
		// When low has met high, we don't enter the loop
		// and we have found the number
		answer(low, i);
	}

	private void answer(int guess, int numberOfGuesses) {
		System.out.println("You were thinking about " + guess + " (took me " + numberOfGuesses + " guesses)");
	}

}
