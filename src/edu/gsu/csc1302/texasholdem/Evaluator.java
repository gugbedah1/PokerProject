package edu.gsu.csc1302.texasholdem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;


public class Evaluator {
	
	private List<Card> playerHand = new ArrayList<Card>();
	private TreeMap<CardRanks, Integer> mappedCards = new TreeMap<CardRanks, Integer>();
	private List<CardRanks> pairList = new ArrayList<>();
	private ArrayList<CardRanks> straightHand = new ArrayList<>();
	private Card highCard = new Card();
	private Boolean flushInHand = false;
	private Boolean straightInHand = false;
	private Boolean straightFlushInHand = false;


	//main evaluator constructor. takes a player, get's their cards,
	//gets the table cards, and merges them into a combined hand.
	
	public Evaluator(Player player, List<Card> cards){
		List<Card> mergedHand = new ArrayList<Card>();
		
		mergedHand.clear();
		
		for(Card card : player.getCards()){
			mergedHand.add(card);
		}
		for(Card card : cards){
			mergedHand.add(card);
		}
		playerHand = mergedHand;
		
	}
	
	//evaluates the merged player hand and returns the highest hand rank available.
	
	public HandRank evaluate(){
		straightFlusherator(playerHand);
		cardRankCounter(playerHand);
		
		HandRank bestHand = HandRank.HIGH_CARD;

		
		if (mappedCards.containsValue(2)){
			bestHand = HandRank.ONE_PAIR;
			
			if(mappedCards.size() < 6){
				bestHand = HandRank.TWO_PAIR;
			}
		}
		if (mappedCards.containsValue(3)){
			bestHand = HandRank.THREE_OF_KIND;
		}	
		if (straightInHand){
			bestHand = HandRank.STRAIGHT;
		}
		if (flushInHand){
			bestHand = HandRank.FLUSH;
		}
		if (mappedCards.containsValue(3) && mappedCards.size() < 5){
			bestHand = HandRank.FULL_HOUSE;
		}
		if (mappedCards.containsValue(4)){
			bestHand = HandRank.FOUR_OF_KIND;
		}
		if(straightFlushInHand){
			bestHand = HandRank.STRAIGHT_FLUSH;
		}
		if (straightFlushInHand && highCard.getRanks() == CardRanks.ACE)
			bestHand = HandRank.ROYAL_FLUSH;
		
		return bestHand;
	}
	
	//counts the number of duplicate cards contained in player hand and
	//stores them in pairList.
	
	public void cardRankCounter(List<Card> cardList){
		ArrayList<Card> counterList = new ArrayList<>();
		
		for (Card card : cardList){
			counterList.add(card);
		}
		
		Collections.sort(counterList, (c1, c2) -> c1.getRanks().compareTo(c2.getRanks()));
		
		Integer count = 1;
		for (Card card : counterList){

			if(!mappedCards.containsKey(card.getRanks())){
				count = 1;
				mappedCards.put(card.getRanks(), count);
				count++;
			}
			else if (mappedCards.containsKey(card.getRanks())){	
				mappedCards.put(card.getRanks(), count);
				count++;
			}
		}
	}
	
	//this method takes the merged hand, sorts it first by rank,
	//and then by suit. It then iterates over the sorted hand
	//looking for a flush, followed by a straight. If both are found, 
	//the hand with a flush is compared to the hand with the straight,
	//and if they're equal, it sets straightFlushInHand true.
	//else, it sets either straightInHand or flushInHand true.
	
	public void straightFlusherator(List<Card> cardList){
		ArrayList<Card> flushHand = new ArrayList<>();
		ArrayList<Card> straightHand = new ArrayList<>();
		ArrayList<Card> flush = new ArrayList<Card>();
		ArrayList<Card> straight = new ArrayList<Card>();
		
		for (Card card : playerHand){
			flushHand.add(card);
		}
		
		for (Card card : playerHand){
			straightHand.add(card);
		}
		
		//this is where I found out java can do lambdas
		Collections.sort(straightHand, (c1, c2) -> c1.getRanks().compareTo(c2.getRanks()));
		highCard = straightHand.get(straightHand.size() - 1);
		
		Collections.sort(flushHand, (c1, c2) -> c1.getRanks().compareTo(c2.getRanks()));
		Collections.sort(flushHand, (c1, c2) -> c1.getSuit().compareTo(c2.getSuit()));
		
		
		//land of a million if statements
		
		for(Card card : flushHand){
			
			if(!flush.isEmpty() && !(flush.size() == 5)){
				if (card.getSuit() == flush.get(0).getSuit()){
					flush.add(card);
				}
				else {
					flush.clear();
					flush.add(card);
				}
			}
			if(flush.isEmpty()){
				flush.add(card);
			}
		}
		
		
		for(Card card : straightHand){

			if (!straight.isEmpty() && !(straight.size() == 5)){
				if (card.getRankInt() == straight.get(straight.size() - 1).getRankInt() + 1){
					straight.add(card);
				}
				else {
					straight.clear();
				}
			}
			if (straight.isEmpty()){
				straight.add(card);
			}
			
		}
		if (straight.size() ==5){
			straightInHand = true;
			highCard = straight.get(straight.size() - 1);
		}
		if (flush.size() == 5){
			flushInHand = true;
		}
		
		if(straight.size() == 5 && flush.size() == 5){	
			for(Card straightCount : straight){
				for(Card flushCount : flush){
					if(straightCount.equals(flushCount)){
						straightFlushInHand = true;
					}
					else {
						straightFlushInHand = false;
					}
				}
			}
		}
		
	}
	
	//getters for class
	
	public List<Card> getPlayerHand() {
		return playerHand;
	}
	public List<CardRanks> getPairList() {
		return pairList;
	}
	public TreeMap<CardRanks, Integer> getMappedCards() {
		return mappedCards;
	}
}
