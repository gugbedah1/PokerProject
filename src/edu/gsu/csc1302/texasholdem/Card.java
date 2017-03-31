package edu.gsu.csc1302.texasholdem;


public class Card implements Comparable<Card> {

	private CardSuits suit;
	private CardRanks rank;
	
	//Default constructor
	public Card() {
	}
	
	//Constructs a card with a suit, rank, and an int value of the suit/rank enum.
	
	public Card(CardRanks rank, CardSuits suit){
		this.suit = suit;
		this.rank = rank;
	}
		
	public CardSuits getSuit(){
		return suit;
	}
	public CardRanks getRanks(){
		return rank;
	}

	public Integer getRankInt(){
		return rank.ordinal();
	}
	
	public Integer getSuitInt(){
		return suit.ordinal();
	}
		
	public String toString(){
		return "Rank: " + rank + " Suit: " + suit;
	}

	@Override
	public int compareTo(Card c) {
		int compare = (c.getRankInt());
		
		return this.getRankInt() - compare;
	}		
	
}

