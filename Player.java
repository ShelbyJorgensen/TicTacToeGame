package ticTacoToe;

public class Player {
	private int playerNum;
	private int playerSymbol;
	private boolean isBot;
	
	// Default constructor
	public Player() {
		
	}
	
	public Player(int playerNum, int playerSymbol, boolean isBot) {
		this.playerNum = playerNum;
		this.playerSymbol = playerSymbol;
		this.isBot = isBot;
	}
	
	public int getPlayerNum() {
		return this.playerNum;
	}
	
	public int getPlayerSymbol() {
		return this.playerSymbol;
	}
	
	public boolean getBot() {
		return this.isBot;
	}
}
