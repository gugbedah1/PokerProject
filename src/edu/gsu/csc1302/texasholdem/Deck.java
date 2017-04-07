package src.edu.gsu.csc1302.texasholdem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Deck {
	private List<Card> cards;
	private List<Card> flop;


	public List<Card> getCards() {
		return cards;
	}
	
	
	//Default constructor for a deck of cards.
	//When instantiated this creates a standard 
	//52 card deck of cards AND shuffles the cards
	//in the best way Collections.shuffle() can.
	
	public Deck() {
		createDeck();
		Collections.shuffle(cards);
	}

	
	
	private void createDeck() {
		cards = new ArrayList<Card>();
		
		for(CardSuits suit : CardSuits.values()) {
			for (CardRanks rank : CardRanks.values()) {
				cards.add(new Card(rank, suit));
			}
		}
	}
	
	//TODO: Fisher-Yates style shuffle
	

	// Deals the card at the first index of the deck
	//and removes that card from the deck.
	
	public Card dealFromTop() {
		Card card = cards.get(0);
		cards.remove(card);
		return card;
	}
	
	//Deals the flop and removes the flop cards from
	//the deck.
	
	public  List<Card> dealFlop(){
		flop = new ArrayList<Card>(3);
		
		for (int i = 3; i > 0; i--){
			Card card = cards.get(0);
			flop.add(card);
			cards.remove(card);
			
		}
		return flop;
	}	
	
	//getters
	
	public List<Card> getFlop() {
		return flop;
	}

	
	public String toString() {
		return cards.toString();
	}
}
