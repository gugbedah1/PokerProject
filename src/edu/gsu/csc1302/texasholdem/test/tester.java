package edu.gsu.csc1302.texasholdem.test;

import java.util.ArrayList;
import java.util.List;

import edu.gsu.csc1302.texasholdem.*;

public class tester {

	public static void main(String[] args){
		
		
		
		Table gameTable = new Table();
		Player player1 = new Player(1000, "John");
		Player player2 = new Player(1000, "Tim");
		Player player3 = new Player(1000, "Larry");
		Player player4 = new Player(1000, "Bob");
		
		gameTable.addPlayerToTable(player1);
		gameTable.addPlayerToTable(player2);
		gameTable.addPlayerToTable(player3);
		gameTable.addPlayerToTable(player4);

		
		
		
		gameTable.getGamePlayers().get(0).dealToPlayer(gameTable.getGameDeck().dealFromTop());
		gameTable.getGamePlayers().get(0).dealToPlayer(gameTable.getGameDeck().dealFromTop());
		gameTable.getGamePlayers().get(1).dealToPlayer(gameTable.getGameDeck().dealFromTop());
		gameTable.getGamePlayers().get(1).dealToPlayer(gameTable.getGameDeck().dealFromTop());
		gameTable.getGamePlayers().get(2).dealToPlayer(gameTable.getGameDeck().dealFromTop());
		gameTable.getGamePlayers().get(2).dealToPlayer(gameTable.getGameDeck().dealFromTop());
		gameTable.getGamePlayers().get(3).dealToPlayer(gameTable.getGameDeck().dealFromTop());
		gameTable.getGamePlayers().get(3).dealToPlayer(gameTable.getGameDeck().dealFromTop());
		gameTable.getCommunityCards().addAll(gameTable.getGameDeck().dealFlop());
		gameTable.getCommunityCards().add(gameTable.getGameDeck().dealFromTop());
		gameTable.getCommunityCards().add(gameTable.getGameDeck().dealFromTop());
		
		gameTable.roundWinner();
	
		
	
		
		
		
		System.out.println("Player1 Cards: " + gameTable.getGamePlayers().get(0).getCards());
		System.out.println("Player2 Cards: " + gameTable.getGamePlayers().get(1).getCards());
		System.out.println("Player3 Cards: " + gameTable.getGamePlayers().get(2).getCards());
		System.out.println("Player4 Cards: " + gameTable.getGamePlayers().get(3).getCards());
		System.out.println("Community Cards: " + gameTable.getCommunityCards());
		System.out.println("Player " + gameTable.getGamePlayers().get(0).getName() + " has " + gameTable.getGamePlayers().get(0).getHandRank());
		System.out.println("Player " + gameTable.getGamePlayers().get(1).getName() + " has " + gameTable.getGamePlayers().get(1).getHandRank());
		System.out.println("Player " + gameTable.getGamePlayers().get(2).getName() + " has " + gameTable.getGamePlayers().get(2).getHandRank());
		System.out.println("Player " + gameTable.getGamePlayers().get(3).getName() + " has " + gameTable.getGamePlayers().get(3).getHandRank());
		System.out.println("Winner " + gameTable.getWinner().getName() );
		
		
	
	
		
		
		
		
		
		
	}
}