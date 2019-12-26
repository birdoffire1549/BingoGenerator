package com.firebirdcss.games.bingo;

import static com.firebirdcss.games.bingo.data.Settings.B;
import static com.firebirdcss.games.bingo.data.Settings.LETTER_RANGES;
import static com.firebirdcss.games.bingo.data.Settings.MAX;
import static com.firebirdcss.games.bingo.data.Settings.MIN;
import static com.firebirdcss.games.bingo.data.Settings.O;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.firebirdcss.games.bingo.data.Settings;
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
    
    private static List<Integer> numbersDrawn = null;
    private static String message = Settings.BINGO_TEXT_ART + "\n"
            + "Ready to play B-I-N-G-O!!!\n"
            + "Simply press ENTER to get a Bingo number...\n"
            + "I will tell you when I have handed out all of the numbers.\n"
            + "\nMenu: [s]how picked, [v]alidate a card, [q]uit game, [enter] next pick\n";
    private static boolean gameOver = false;
    private static int counter = 0;
    private static Scanner scanner = null;
    
    /**
     * This is the main method and entry-point for the application.
     * 
     * @param args - Not used.
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        scanner = new Scanner(System.in);
        numbersDrawn = new ArrayList<>();
        numbersDrawn.add(-1); // <--- This will be used to represent Free Space.
        clearScreen();
        System.out.println(message);
        System.out.print("\nPress ENTER when ready: ");
        
        while (!gameOver) { // Game isn't over...
            String entry = null;
            try {
                entry = Utilities.waitForEntry(scanner);
            } catch (Exception e) {}
            
            if (entry != null && !entry.trim().isEmpty()) { // Something was entered...
                if ("q".equalsIgnoreCase(entry)) { // ......................[Q for Quit]
                    gameOver = true;
                } else if ("v".equalsIgnoreCase(entry)) { // ...............[V for Verify Card]
                    clearScreen();
                    System.out.println(message);
                    try {
                        if (verifyCard()) { // Numbers were picked...
                            clearScreen();
                            System.out.println(message);
                            System.out.println("~ WINNER ~");
                            System.out.print("\nPress ENTER when ready: ");
                        } else { // One or more number wasn't picked...
                            clearScreen();
                            System.out.println(message);
                            System.out.println("~ NOT A WINNER ~");
                            System.out.print("\nPress ENTER when ready: ");
                        }
                    } catch (Exception e) {}
                } else if ("s".equalsIgnoreCase(entry)) { // ...............[S for Show Picks]
                    showDrawn();
                }
            } else { // ....................................................[Enter for Pick New]
                clearScreen();
                gameOver = draw();
                if (gameOver) showDrawn();
            }
        }
        
        System.out.println("\n~ Game Over ~\n");
        scanner.close();
    }
    /**
     * Prints a listing of all of the numbers which have been drawn so far
     * to the screen for the user to see.
     */
    private static void showDrawn() {
        clearScreen();
        System.out.println(message);
        int c = 0;
        for (Integer n : numbersDrawn) {
            if (++c > 1) System.out.print(", ");
            System.out.print(String.valueOf(Utilities.numberToBingo(n)));
        }
        System.out.println("");
        System.out.print("\nPress ENTER when ready: ");
    }
    
    /**
     * This method handles drawing a new BINGO number that hasn't yet
     * been drawn.
     * 
     * @return Returns true if all numbers handed out, otherwise returns false.
     */
    private static boolean draw() {
        Integer number = Utilities.drawNewNumber(numbersDrawn, LETTER_RANGES[B][MIN], LETTER_RANGES[O][MAX]);
        System.out.println(message);
        if (number != null) { // A number was chosen; Not out of numbers...
            System.out.print("" + (++counter) + ": " + Utilities.numberToBingo(number.intValue()));
            System.out.print("\n\nPress ENTER when ready: ");
        } else { // All numbers handed out...
            
            return true;
        }
        
        return false;
    }
    
    /**
     * This method is used to verify that the numbers given for a potential 
     * BINGO were in-fact called.
     * 
     * @return Returns true if numbers are valid, otherwise returns false.
     * @throws Exception
     */
    private static boolean verifyCard() throws Exception {
        System.out.println("Please enter the card numbers only, separated by commas, and 'F' for Free Space (example: 13,1,F,4,3):");
        String input = Utilities.waitForEntry(scanner);
        String[] values = input.split(",");
        if (values.length == 5) {
            try {
                for (String v : values) {
                    if ("F".equalsIgnoreCase(v.trim())) { // Free Space value...
                        v = "-1";
                    }
                    
                    if (!numbersDrawn.contains(Integer.valueOf(v.trim()))) { // Number wasn't picked...
                        
                        return false;
                    }
                }
                
                return true;
            } catch (Exception e) {}
        }
        
        return false;
    }
    
    /**
     * This method clears the console.
     * 
     */
    private static void clearScreen() {
        System.out.print("\033[H\033[2J");  
        System.out.flush();
    }
}
