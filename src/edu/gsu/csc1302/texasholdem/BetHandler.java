package src.edu.gsu.csc1302.texasholdem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BetHandler {

	int currentBet = 0;
	Scanner s = new Scanner(System.in);
	List<Player> list = new ArrayList<Player>();
	int pot;
	Table gameTable;
	
	public BetHandler(List<Player> list , int pot, Table gameTable){
				this.list = list;
				this.pot = pot;
				this.gameTable = gameTable;
	}

	public void roundBetting() {
		String betType = null;
		
		for (Player player : list){
			if (list.indexOf(player) == 0){
				System.out.println("Raise, call, check, or fold? ");
				betType = s.nextLine();
			}
			else {
				//pass betType from bots
			}
		
				if (betType.equalsIgnoreCase("raise")){
					raise(player);
				
					}
				else if (betType.equalsIgnoreCase("call")){
					call(player);
				}
				else if (betType.equalsIgnoreCase("check")){
					check(player);
				}
				else if (betType.equalsIgnoreCase("fold")){
			
				}
			}
	}
	
	public void raise(Player player) {
		int raise = 0;
		int bet = 0;

		
		while (raise <= 0){
			System.out.println("Enter amount to raise: ");
			raise = s.nextInt();
		}
		
		bet = raise + currentBet;
		player.bet(bet);
		System.out.println("Player " + player.getName() + " raises " + raise
				+ " for a total of " + bet);
			
		
		
		
		
	}
	public void call(Player player){
		if(currentBet != 0){
			player.bet(currentBet);
			System.out.println("Player " + player.getName() + " calls "
					+ currentBet);
		}
	}

	public void check(Player player){
		//add proper check to see if check is valid.
		
		System.out.println("Player " + player.getName() + " checks.");
	}


}
