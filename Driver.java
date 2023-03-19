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
			}
			int x,y;
			while(!gameBoard.hasPlayerWon(0) && !gameBoard.hasPlayerWon(1)) {
				System.out.println("Player 1, make your move:");
				while(!gameBoard.placeSymbol(player1, x, y)) {
					x = input.nextInt();
					y = input.nextInt();
				}
				if(gameBoard.hasPlayerWon(player1.getPlayerSymbol())) {
					System.out.println("Player 1 wins!");
					gameBoard.showBoard();
					break;
				}
				System.out.println("Player 2, make your move:");
				x = input.nextInt();
				y = input.nextInt();
				gameBoard.placeSymbol(player2, x, y);
				if(gameBoard.hasPlayerWon(player2.getPlayerSymbol())) {
					System.out.println("Player 2 wins!");
					gameBoard.showBoard();
					break;
				}
				gameBoard.showBoard();
			}
		}
	}
}
