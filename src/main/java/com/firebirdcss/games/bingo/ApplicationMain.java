/**
 * 
 */
package com.firebirdcss.games.bingo;

import java.util.ArrayList;
import java.util.List;

import static com.firebirdcss.games.bingo.InternalProperties.*;
/**
 * @author sgriffis
 *
 */
public class ApplicationMain {
	/**
	 * 
	 */
	public ApplicationMain() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Integer> numbersDrawn = new ArrayList<>();
		
		System.out.println("Ready to play B-I-N-G-O!!!");
		System.out.println("Simply press any-key to get a Bingo number and I will tell you when I have handed out all of the numbers...");
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
