package ticTacoToe;

import java.util.Scanner;

public class Driver {
	public static void main(String[] args) {
		Board gameBoard = new Board();
		try (Scanner input = new Scanner(System.in)) {
			System.out.println("How many players are there?");
			Player player1 = new Player(1,0,true);
			Player player2 = new Player(2,0,true);
			
			int players = input.nextInt();
			if(players > 2 && players < 0) {
				System.out.println("I'm sorry, there can only be up to 2 players.");
				players = 0;
			} else if(players == 1) {
				System.out.println("What symbol do you want to be?");
				System.out.println("(Enter 1 for X and 0 for O)");
				int sym = input.nextInt();
				player1 = new Player(1, sym, false);
				if(sym == 1) {
					player2 = new Player(2, 0, true);
				} else {
					player2 = new Player(2, 1, true);
				}
			} else if(players == 2) {
				System.out.println("What symbol does player 1 want to use?");
				System.out.println("(Enter 1 for X and 0 for O)");
				int sym = input.nextInt();
				player1 = new Player(1, sym, false);
				if(sym == 1) {
					player2 = new Player(2, 0, false);
				} else {
					player2 = new Player(2, 1, false);
				}
			} else if(players == 0) {
				player1 = new Player(1, 1, true);
				player2 = new Player(2, 0, true);
			}
			
			boolean show = false;
			int moveCount = 0;
			// How to handle moves if both players are not bots
			if(!player1.getBot() && !player2.getBot()) {
				while(!gameBoard.hasPlayerWon(player1.getPlayerSymbol()) && !gameBoard.hasPlayerWon(player2.getPlayerSymbol()) && moveCount != 9) {
					printPotentialMoves(player1, true);
					int move = input.nextInt();
					if(move == 0) {
						show = true;
						showPotentialMoves(show);
						printPotentialMoves(player1, false);
					}
					
					while(!gameBoard.placeSymbol(player1, move)) {
						move = input.nextInt();
					}
					
					gameBoard.showBoard();
					moveCount++;
					if(gameBoard.hasPlayerWon(player1.getPlayerSymbol()) || moveCount == 9) {
						break;
					}
					
					printPotentialMoves(player2, true);
					move = input.nextInt();
					if(move == 0) {
						show = true;
						showPotentialMoves(show);
						printPotentialMoves(player2, false);
					}
					
					while(!gameBoard.placeSymbol(player2, move)) {
						move = input.nextInt();
					}
					
					gameBoard.showBoard();
					moveCount++;
				}
			}
			// How to handle moves if both players are bots
			if(player1.getBot() && player2.getBot()) {
				while(!gameBoard.hasPlayerWon(player1.getPlayerSymbol()) && !gameBoard.hasPlayerWon(player2.getPlayerSymbol()) && moveCount != 9) {
					while(!gameBoard.botMove(player1, player1.getBot()));
					gameBoard.showBoard();
					System.out.println();
					moveCount++;
					
					if(gameBoard.hasPlayerWon(player1.getPlayerSymbol()) || moveCount == 9) {
						break;
					}
					while(!gameBoard.botMove(player2, player2.getBot()));
					gameBoard.showBoard();
					System.out.println();
					moveCount++;
				}
			}
			
			if(gameBoard.hasPlayerWon(player1.getPlayerSymbol())) {
				System.out.println("Player 1 has won!");
			} else if(gameBoard.hasPlayerWon(player2.getPlayerSymbol())) {
				System.out.println("Player 2 has won!");
			}
			if(moveCount == 9) {
				System.out.println("Tie game! No winner!");
			}
		}
	}
	public static void printPotentialMoves(Player player, boolean show) {
		System.out.println("Player " + player.getPlayerNum() + " , make your move:");
		if(show) {
			System.out.println("(Enter 0 to show potential moves)");
		}
	} 
	public static void showPotentialMoves(boolean show) {
		if(show) {
			System.out.println("1|2|3 \n"
					+  "4|5|6 \n"
					+  "7|8|9");
		}
	}
}
