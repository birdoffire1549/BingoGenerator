package com.firebirdcss.games.bingo;

import static com.firebirdcss.games.bingo.InternalProperties.B;
import static com.firebirdcss.games.bingo.InternalProperties.G;
import static com.firebirdcss.games.bingo.InternalProperties.I;
import static com.firebirdcss.games.bingo.InternalProperties.LETTER_RANGES;
import static com.firebirdcss.games.bingo.InternalProperties.MAX;
import static com.firebirdcss.games.bingo.InternalProperties.MIN;
import static com.firebirdcss.games.bingo.InternalProperties.N;
import static com.firebirdcss.games.bingo.InternalProperties.O;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public final class Utilities {

	private Utilities() {}
	
	/**
	 * MaxNumber will be the size of drawnNumbers array.
	 * @param drawnNumbers
	 * @param minNum
	 * @return
	 */
	public static Integer drawNewNumber(List<Integer> drawnNumbers, int min, int max) {
		if (min < max && drawnNumbers.size() < (max - min + 1)) {
			Random rnd = new Random();
			while (true) {
				Integer chosen = Integer.valueOf(rnd.nextInt((max - min) + 1) + min);
				
				if (!drawnNumbers.contains(chosen)) {
					drawnNumbers.add(chosen);
					
					return chosen;
				}
			} 
		}
		
		return null;
	}
	
	public static String numberToBingo(int number) {
		if (number >= LETTER_RANGES[B][MIN]
				&& number <= LETTER_RANGES[B][MAX]
		) {
			
			return "B-" + number;
		} else if (number >= LETTER_RANGES[I][MIN]
				&& number <= LETTER_RANGES[I][MAX]
		) {
			
			return "I-" + number;
		} else if (number >= LETTER_RANGES[N][MIN]
				&& number <= LETTER_RANGES[N][MAX]
		) {
			
			return "N-" + number;
		} else if (number >= LETTER_RANGES[G][MIN]
				&& number <= LETTER_RANGES[G][MAX]
		) {
			
			return "G-" + number;
		} else if (number >= LETTER_RANGES[O][MIN]
				&& number <= LETTER_RANGES[O][MAX]
		) {
			
			return "O-" + number;
		}
		
		return null;
	}
	
	@SuppressWarnings("resource")
	public static void waitForEnterKey() throws Exception {
		Scanner sc = new Scanner(System.in);
		sc.nextLine();
	}
}
