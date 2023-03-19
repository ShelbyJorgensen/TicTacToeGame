package ticTacoToe;

public class Board {
	int[][] playingBoard = {{-1, -1, -1},
		 				    {-1, -1, -1},
		 				    {-1, -1, -1}};
	
	// Default constructor
	public Board() {
		
	}
	
	// 
	public void resetBoard() {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				this.playingBoard[i][j] = -1;
			}
		}
	}
	
	public boolean placeSymbol(Player player, int x, int y) {
		if(x > 2 || y > 2) {
			System.out.println("Invalid move, please try again.");
			return false;
		} else if(playingBoard[x][y] != -1) {
			System.out.println("That space has already been used.");
			return false;
		} else {
			playingBoard[x][y] = player.getPlayerSymbol();
			return true;
		}
	}
	
	protected boolean hasPlayerWon(int symbol) {
		int symCount = 0;
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(playingBoard[i][j] == symbol) {
					symCount++;
				}
			}
			if(symCount == 3) {
				return true;
			} else {
				symCount = 0;
			}
		}
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(playingBoard[j][i] == symbol) {
					symCount++;
				}
			}
			if(symCount == 3) {
				return true;
			} else {
				symCount = 0;
			}
		}
		
		if(playingBoard[0][0] == symbol && playingBoard[1][1] == symbol && playingBoard[2][2] == symbol) {
			return true;
		}
		if(playingBoard[2][0] == symbol && playingBoard[1][1] == symbol && playingBoard[0][2] == symbol) {
			return true;
		}
		
		return false;
	}
	
	public void showBoard() {
		// Line 1 of the board
		printAtSpace(0,0);
		System.out.print(" | ");
		printAtSpace(0,1);
		System.out.print(" | ");
		printAtSpace(0,2);
		System.out.println();
		
		//Spacing line
		System.out.println("----------");
		
		// Line 2 of the board
		printAtSpace(1,0);
		System.out.print(" | ");
		printAtSpace(1,1);
		System.out.print(" | ");
		printAtSpace(1,2);
		System.out.println();
		
		//Spacing line
		System.out.println("----------");

		// Line 3 of the board
		printAtSpace(2,0);
		System.out.print(" | ");
		printAtSpace(2,1);
		System.out.print(" | ");
		printAtSpace(2,2);
		System.out.println();
	}
	
	public void printAtSpace(int x, int y) {
		if(playingBoard[x][y] == -1) {
			System.out.print(" ");
		}
		if(playingBoard[x][y] == 0) {
			System.out.print("O");
		}
		if(playingBoard[x][y] == 1) {
			System.out.print("X");
		}
	}
}
