package edu.gsu.csc1302.texasholdem;

import java.util.ArrayList;
import java.util.List;

public class Player {
	
	private List<Card> cards = new ArrayList<Card>(2);
	private HandRank handRank = null;
	private Card highCard = null;
	private Integer bankroll = 0;
	private String name = null;
	
	
	public Player(Integer bankroll, String name) {
		this.bankroll = bankroll;
		this.setName(name);
	}
	
	public void dealToPlayer(Card cards){
		this.cards.add(cards);
	}
	
	

	public Integer getBankroll() {
		return bankroll;
	}

	public void setBankroll(Integer bankroll) {
		this.bankroll = bankroll;
	}

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

	public HandRank getHandRank() {
		return handRank;
	}

	public void setHandRank(HandRank handRank) {
		this.handRank = handRank;
	}

	public Card getHighCard() {
		return highCard;
	}

	public void setHighCard(Card highCard) {
		this.highCard = highCard;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
