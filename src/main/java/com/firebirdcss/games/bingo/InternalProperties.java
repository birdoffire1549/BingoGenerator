package com.firebirdcss.games.bingo;

public class InternalProperties {

	private InternalProperties() {
		// TODO Auto-generated constructor stub
	}
	
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
}
