package com.firebirdcss.games.bingo;

import static com.firebirdcss.games.bingo.data.Settings.B;
import static com.firebirdcss.games.bingo.data.Settings.G;
import static com.firebirdcss.games.bingo.data.Settings.I;
import static com.firebirdcss.games.bingo.data.Settings.LETTER_RANGES;
import static com.firebirdcss.games.bingo.data.Settings.MAX;
import static com.firebirdcss.games.bingo.data.Settings.MIN;
import static com.firebirdcss.games.bingo.data.Settings.N;
import static com.firebirdcss.games.bingo.data.Settings.O;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * This class contains the utility methods of the application which 
 * may be used throughout the application.
 * 
 * @author Scott Griffis
 *
 */
public final class Utilities {
    /**
     * PRIVATE CONSTRUCTOR: Prevents instantiation.
     * 
     */
    private Utilities() {}
    
    /**
     * Randomly draw a new number that has not yet been chosen based on the given
     * parameters and adds the number to the given list of drawnNumbers and also 
     * passes back the chosen number.
     * 
     * @param drawnNumbers - A list of the numbers already drawn as a {@link List} of <code>int</code>
     * @param min - The minimum number to draw as <code>int</code>
     * @param max - The maximum number to draw as <code>int</code>
     * @return Returns the chosen number as {@link Integer}
     */
    public static Integer drawNewNumber(List<Integer> drawnNumbers, int min, int max) {
        if (min < max && (drawnNumbers.size() - 1 /*FreeSpace*/)  < (max - min + 1)) {
            Random rnd = new Random();
            while (true) {
                Integer chosen = Integer.valueOf(rnd.nextInt((max - min) + 1) + min);
                
                if (!drawnNumbers.contains(chosen)) { // Number hasn't yet been chosen...
                    drawnNumbers.add(chosen);
                    
                    return chosen;
                }
            } 
        }
        
        return null;
    }
    
    /**
     * Converts a number to its BINGO equivalent.
     * 
     * @param number - The number to convert as <code>int</code>
     * @return Returns the Bingo version of the number as {@link String}
     */
    public static String numberToBingo(int number) {
        if (number == -1) { // Number represents 'Free Space' value...
            
            return "Free Space";
        } else if (number >= LETTER_RANGES[B][MIN]
            && number <= LETTER_RANGES[B][MAX]
        ) { // Number is in the 'B' range...
            
            return "B-" + number;
        } else if (number >= LETTER_RANGES[I][MIN]
            && number <= LETTER_RANGES[I][MAX]
        ) { // Number is in the 'I' range...
            
            return "I-" + number;
        } else if (number >= LETTER_RANGES[N][MIN]
            && number <= LETTER_RANGES[N][MAX]
        ) { // Number is in the 'N' range...
            
            return "N-" + number;
        } else if (number >= LETTER_RANGES[G][MIN]
            && number <= LETTER_RANGES[G][MAX]
        ) { // Number is in the 'G' range...
            
            return "G-" + number;
        } else if (number >= LETTER_RANGES[O][MIN]
            && number <= LETTER_RANGES[O][MAX]
        ) { // Number is in the 'O' range...
            
            return "O-" + number;
        }
        
        return null;
    }
    
    /**
     * Simply waits for the enter key to be pressed.
     * 
     * @throws Exception Indicates a problem while reading input from STDIN.
     */
    public static String waitForEntry(Scanner sc) throws Exception {
        String result = sc.nextLine();
        
        return result;
    }
}
