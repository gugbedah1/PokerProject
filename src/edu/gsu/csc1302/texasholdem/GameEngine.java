package edu.gsu.csc1302.texasholdem;

import java.util.Scanner;

public class GameEngine {
	private Table gameTable;

	public void startGame() {
		setGameTable(new Table());
		createUser();
		//fire up the AI and add them to the game.
		//start the first round
		
	}
	
	public void gameRound() {
		dealHand();
		//pre-flop betting
		gameTable.getGameDeck().dealFlop();
		//bet
		gameTable.getCommunityCards().add(gameTable.getGameDeck().dealFromTop());
		//bet
		gameTable.getCommunityCards().add(gameTable.getGameDeck().dealFromTop());
		//more betting... until all but one folds.. else
		gameTable.getWinner();
		//print out results..
		//divvy out the pot
		
		
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
