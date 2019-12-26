package com.firebirdcss.games.bingo.data;

public class Settings {
	/**
	 * PRIVATE CONSTRUCTOR: Prevents class instantiation.
	 * 
	 */
	private Settings() {}
	
	public static final int B = 0;
	public static final int I = 1;
	public static final int N = 2;
	public static final int G = 3;
	public static final int O = 4;
	
	public static final int MIN = 0;
	public static final int MAX = 1;
	
	public static final int[][] LETTER_RANGES = {
			        /*MIN*/  /*MAX*/
			/* B */{   1,      15},
			/* I */{  16,      30},
			/* N */{  31,      45},
			/* G */{  46,      60},
			/* O */{  61,      75},
	};
	
	public static final String BINGO_TEXT_ART = 
			"********************************************************************************************\n" + 
			"*  _______         ______        __    __           ______            ______               *\n" + 
			"* |       \\       |      \\      |  \\  |  \\         /      \\          /      \\              *\n" + 
			"* | $$$$$$$\\       \\$$$$$$      | $$\\ | $$        |  $$$$$$\\        |  $$$$$$\\             *\n" + 
			"* | $$__/ $$ ______ | $$ ______ | $$$\\| $$ ______ | $$ __\\$$ ______ | $$  | $$             *\n" + 
			"* | $$    $$|      \\| $$|      \\| $$$$\\ $$|      \\| $$|    \\|      \\| $$  | $$             *\n" + 
			"* | $$$$$$$\\ \\$$$$$$| $$ \\$$$$$$| $$\\$$ $$ \\$$$$$$| $$ \\$$$$ \\$$$$$$| $$  | $$             *\n" + 
			"* | $$__/ $$       _| $$_       | $$ \\$$$$        | $$__| $$        | $$__/ $$             *\n" + 
			"* | $$    $$      |   $$ \\      | $$  \\$$$         \\$$    $$         \\$$    $$             *\n" + 
			"*  \\$$$$$$$        \\$$$$$$       \\$$   \\$$          \\$$$$$$           \\$$$$$$              *\n" + 
			"*                                                                                          *\n" + 
			"*  ______                                                     __                           *\n" + 
			"*  /      \\                                                   |  \\                         *\n" + 
			"* |  $$$$$$\\  ______   _______    ______    ______   ______  _| $$_     ______    ______   *\n" + 
			"* | $$ __\\$$ /      \\ |       \\  /      \\  /      \\ |      \\|   $$ \\   /      \\  /      \\  *\n" + 
			"* | $$|    \\|  $$$$$$\\| $$$$$$$\\|  $$$$$$\\|  $$$$$$\\ \\$$$$$$\\\\$$$$$$  |  $$$$$$\\|  $$$$$$\\ *\n" + 
			"* | $$ \\$$$$| $$    $$| $$  | $$| $$    $$| $$   \\$$/      $$ | $$ __ | $$  | $$| $$   \\$$ *\n" + 
			"* | $$__| $$| $$$$$$$$| $$  | $$| $$$$$$$$| $$     |  $$$$$$$ | $$|  \\| $$__/ $$| $$       *\n" + 
			"*  \\$$    $$ \\$$     \\| $$  | $$ \\$$     \\| $$      \\$$    $$  \\$$  $$ \\$$    $$| $$       *\n" + 
			"*   \\$$$$$$   \\$$$$$$$ \\$$   \\$$  \\$$$$$$$ \\$$       \\$$$$$$$   \\$$$$   \\$$$$$$  \\$$       *\n" + 
			"********************************************************************************************\n" + 
			"* By: Scott Griffis                                                                        *\n" +
			"********************************************************************************************\n";
}