package edu.gsu.csc1302.texasholdem;

import java.util.Scanner;

public class GameEngine {
	private Table gameTable;

	public void startGame() {
		setGameTable(new Table());
		createUser();
		
	}
	
	public void gameRound() {
		dealHand();
	}

	public void createUser(){
		String name;
		int bankroll;
		
		Scanner userScanner = new Scanner(System.in);
		System.out.println("Enter a username: ");
		name = userScanner.nextLine();
		System.out.println("Enter a bankroll amount: ");
		bankroll = userScanner.nextInt();
		
		Player user = new Player(bankroll, name);
		gameTable.addPlayerToTable(user);
		userScanner.close();
		
	}
	
	public void dealHand(){
		for(int i = 0; i < 2; i++){	
			for(Player player : gameTable.getGamePlayers()){
				player.dealToPlayer(gameTable.getGameDeck().dealFromTop());
			}
		}
	}
	
	
	
	
	//getters and setters
	public Table getGameTable() {
		return gameTable;
	}

	public void setGameTable(Table gameTable) {
		this.gameTable = gameTable;
	}
	
	
	
}
