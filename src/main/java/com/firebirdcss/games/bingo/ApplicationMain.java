/**
 * 
 */
package com.firebirdcss.games.bingo;

import static com.firebirdcss.games.bingo.InternalProperties.B;
import static com.firebirdcss.games.bingo.InternalProperties.LETTER_RANGES;
import static com.firebirdcss.games.bingo.InternalProperties.MAX;
import static com.firebirdcss.games.bingo.InternalProperties.MIN;
import static com.firebirdcss.games.bingo.InternalProperties.O;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 * The main class of the application which happens to contain the main method which 
 * is the main entry point.
 * 
 * @author Scott Griffis
 *
 */
public final class ApplicationMain {
	/**
	 * PRIVATE CONSTRUCTOR: Used to ensure the class is not instantiated.
	 * 
	 */
	private ApplicationMain() {
		// Do nothing...
	}

	/**
	 * This is the main method and entry-point for the application.
	 * 
	 * @param args - Not used.
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		List<Integer> numbersDrawn = new ArrayList<>();
		
		System.out.println(InternalProperties.BINGO_TEXT_ART);
		System.out.println("Ready to play B-I-N-G-O!!!");
		System.out.println("Simply press ENTER to get a Bingo number...");
		System.out.println("I will tell you when I have handed out all of the numbers.");
		System.out.println("Press ENTER when ready:");
		
		boolean gameOver = false;
		int c = 0;
		while (!gameOver) {
			try {
				Utilities.waitForEnterKey();
			} catch (Exception e) {}
			
			Integer number = Utilities.drawNewNumber(numbersDrawn, LETTER_RANGES[B][MIN], LETTER_RANGES[O][MAX]);
			if (number != null) {
				System.out.print("" + (++c) + ": " + Utilities.numberToBingo(number.intValue()));
			} else {
				gameOver = true;
			}
		}
		
		System.out.println("~ Game Over ~");
	}
}
