package edu.gsu.csc1302.texasholdem.test;



import edu.gsu.csc1302.texasholdem.*;

//The testbed for all classes. Feel free to manipulate this as you see
//fit to poke around the game engine to get a feel for how everything works.
//Don't be afraid to press 'Run' and see what happens. If it fails spectacularly,
//let me know.

public class tester {

	public static void main(String[] args){
		
		
		
//		Table gameTable = new Table();
//		Player player1 = new Player(1000, "Deckard");
//		Player player2 = new Player(1000, "Roy");
//		Player player3 = new Player(1000, "Pris");
//		Player player4 = new Player(1000, "Leon");
//		
//		gameTable.addPlayerToTable(player1);
//		gameTable.addPlayerToTable(player2);
//		gameTable.addPlayerToTable(player3);
//		gameTable.addPlayerToTable(player4);
//
//		
//		
//		
//		gameTable.getGamePlayers().get(0).dealToPlayer(gameTable.getGameDeck().dealFromTop());
//		gameTable.getGamePlayers().get(0).dealToPlayer(gameTable.getGameDeck().dealFromTop());
//		gameTable.getGamePlayers().get(1).dealToPlayer(gameTable.getGameDeck().dealFromTop());
//		gameTable.getGamePlayers().get(1).dealToPlayer(gameTable.getGameDeck().dealFromTop());
//		gameTable.getGamePlayers().get(2).dealToPlayer(gameTable.getGameDeck().dealFromTop());
//		gameTable.getGamePlayers().get(2).dealToPlayer(gameTable.getGameDeck().dealFromTop());
//		gameTable.getGamePlayers().get(3).dealToPlayer(gameTable.getGameDeck().dealFromTop());
//		gameTable.getGamePlayers().get(3).dealToPlayer(gameTable.getGameDeck().dealFromTop());
//		gameTable.getCommunityCards().addAll(gameTable.getGameDeck().dealFlop());
//		gameTable.getCommunityCards().add(gameTable.getGameDeck().dealFromTop());
//		gameTable.getCommunityCards().add(gameTable.getGameDeck().dealFromTop());
//		
//		gameTable.roundWinner();
//	
//		
//	
//		
//		
//		
//		System.out.println("Player1 Cards: " + gameTable.getGamePlayers().get(0).getCards());
//		System.out.println("Player2 Cards: " + gameTable.getGamePlayers().get(1).getCards());
//		System.out.println("Player3 Cards: " + gameTable.getGamePlayers().get(2).getCards());
//		System.out.println("Player4 Cards: " + gameTable.getGamePlayers().get(3).getCards());
//		System.out.println("Community Cards: " + gameTable.getCommunityCards());
//		System.out.println("Player " + gameTable.getGamePlayers().get(0).getName() + " has " + gameTable.getGamePlayers().get(0).getHandRank());
//		System.out.println("Player " + gameTable.getGamePlayers().get(1).getName() + " has " + gameTable.getGamePlayers().get(1).getHandRank());
//		System.out.println("Player " + gameTable.getGamePlayers().get(2).getName() + " has " + gameTable.getGamePlayers().get(2).getHandRank());
//		System.out.println("Player " + gameTable.getGamePlayers().get(3).getName() + " has " + gameTable.getGamePlayers().get(3).getHandRank());
//		System.out.println("Winner " + gameTable.getWinner().getName() );
//		
		
	
	
		
//		Table gameTable2 = new Table();
//		Player playerStraight = new Player(1000, "John");
//		
//		Card two = new Card(CardRanks.TEN, CardSuits.CLUB);
//		Card three = new Card(CardRanks.JACK, CardSuits.CLUB);
//		Card four = new Card(CardRanks.KING, CardSuits.CLUB);
//		Card five = new Card(CardRanks.ACE, CardSuits.CLUB);
//		Card six = new Card(CardRanks.QUEEN, CardSuits.CLUB);
//		Card seven = new Card(CardRanks.ACE, CardSuits.DIAMOND);
//		Card eight = new Card(CardRanks.ACE, CardSuits.DIAMOND);
//		
//		
//		
//		
//		ArrayList<Card> straightPlayerHand = new ArrayList<Card>();
//		straightPlayerHand.add(two);
//		straightPlayerHand.add(three);
//
//		ArrayList<Card> tableCards = new ArrayList<Card>();
//		tableCards.add(four);
//		tableCards.add(five);
//		tableCards.add(six);
//		tableCards.add(seven);
//		tableCards.add(eight);
//
//
//		
//		playerStraight.setCards(straightPlayerHand);
//		
//		System.out.println(straightPlayerHand + " " + tableCards);
//		Evaluator eval2 = new Evaluator(playerStraight, tableCards);
//		
//		System.out.println(eval2.evaluate());
//		
		GameEngine game = new GameEngine();
		game.startGame();
		
		
	}
}
