package edu.gsu.csc1302.texasholdem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

//this is where the magic happens. This class should be everything you'd
//expect from a game of poker. The community cards are dealt to the table
//object, the deck is built and stored here, the players are listed here, 
//the pot for the game is stored here, etc. 

public class Table {

	private Integer pot = 0;
	private Deck gameDeck = new Deck();
	private List<Player> gamePlayers = new ArrayList<Player>();
	private List<Card> communityCards = new ArrayList<Card>(5);
	private List<Player> playersByHandRank = new ArrayList<Player>();

	public Player getWinner() {
		return playersByHandRank.get(playersByHandRank.size() -1);
	}
	//adds player to gamePlayers
	public void addPlayerToTable(Player player){
		gamePlayers.add(player);
	}
	//removes player from gamePlayers
	public void removePlayerFromTable(Player player){
		gamePlayers.remove(player);
	}
	
	//determines the round winner
	public Player roundWinner() {
		for(Player player : gamePlayers){
			Evaluator eval = new Evaluator(player, communityCards);
			
			player.setHandRank(eval.evaluate());
			playersByHandRank.add(player);
		}
		
		//lambdas are magic. Sorts players from lowest to highest rank starting with the lowest at the first
		//index, and the highest at the last.
		Collections.sort(playersByHandRank, (p1, p2) -> p1.getHandRank().compareTo(p2.getHandRank()));
		
		//TODO: Needs to evaluate high card in case of two or more players have the same high hand rank.
		//the evaluate method in Evaluator sets high card == to the highest card in a pairSet, flush, or straight,
		//but needs to be able to add it in the event HIGH_CARD is the highest hand a player has.

		return playersByHandRank.get(playersByHandRank.size() -1);
	}
	
	public void resetDeck(){
		gameDeck = new Deck();
	}
	
	
	
	//getters and setters
	public Deck getGameDeck() {
		return gameDeck;
	}

	public List<Player> getGamePlayers() {
		return gamePlayers;
	}

	public void setGamePlayers(List<Player> gamePlayers) {
		this.gamePlayers = gamePlayers;
	}

	public Integer getPot() {
		return pot;
	}

	public void setPot(Integer pot) {
		this.pot = pot;
	}

	public List<Card> getCommunityCards() {
		return communityCards;
	}

	public void setCommunityCards(List<Card> community) {
		for(Card card : community){
			communityCards.add(card);
		}
	}
	public void setCommunityCards(Card card) {
		communityCards.add(card);
	}
}
