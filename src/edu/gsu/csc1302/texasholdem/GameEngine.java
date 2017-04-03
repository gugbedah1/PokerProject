package edu.gsu.csc1302.texasholdem;

import java.util.Scanner;

//spaghetti everywhere..

public class GameEngine {
	private Table gameTable;
	Scanner userScanner = new Scanner(System.in);

	public void startGame() {
		
		setGameTable(new Table());
		createUser();
		gameRound();
		
		//fire up the AI and add them to the game.
		
	}
	
	public void gameRound() {
		int currentBet = 0;
		
		System.out.println("Dealing hand.." );
		dealHand();
		
		System.out.println("Your Hand is: " + 
		gameTable.getGamePlayers().get(0).getCards());
		
		//gameTable.betHandler(); --uncomment and paste in all betting slots
		//when this actually works.
		
		
		System.out.println("Dealing flop...");
		gameTable.getCommunityCards().addAll(gameTable.getGameDeck().dealFlop());
		System.out.println("Community Cards: " +
		gameTable.getCommunityCards());
		
		//bet
		System.out.println("Dealing turn...");
		gameTable.getCommunityCards().add(gameTable.getGameDeck().dealFromTop());
		System.out.println("Community Cards: " +
				gameTable.getCommunityCards());
		
		//bet
		System.out.println("Dealing river...");
		gameTable.getCommunityCards().add(gameTable.getGameDeck().dealFromTop());
		System.out.println("Community Cards: " +
				gameTable.getCommunityCards());
		//more betting... until all but one folds.. else
		

		//gameTable.getWinner(); --add this when AI exists.
		//print out results..
		//divvy out the pot
		
		System.out.println("Preparing for next round...");
		gameTable.getCommunityCards().clear();
		
		for(Player player : gameTable.getGamePlayers()){
			player.getCards().clear();
		}
		
		gameTable.resetDeck();
		
		
	}

	public void createUser(){
		String name;
		int bankroll;
		
		
		System.out.println("Enter a username: ");
		name = userScanner.nextLine();
		System.out.println("Enter a bankroll amount: ");
		bankroll = userScanner.nextInt();
		
		Player user = new Player(bankroll, name);
		gameTable.addPlayerToTable(user);
		
		
		System.out.println("Your username is: " + 
				gameTable.getGamePlayers().get(0).getName() + 
				". Your bankroll is: $" + 
				gameTable.getGamePlayers().get(0).getBankroll());
		
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
