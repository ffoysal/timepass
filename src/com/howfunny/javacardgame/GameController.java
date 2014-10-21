package com.howfunny.javacardgame;

public class GameController {
	
	private AuctionBridgeGame game;
	
	public static void main(String args[]){
		GameController gc = new GameController();
		gc.startABridgeGame();
		
	}
	
	public void startABridgeGame(){
		Player player1=new Player("Ripon");
		Player player2=new Player("Foysal");
		Player player3=new Player("Sayeed");
		Player player4=new Player("Namandeep");
		AuctionBridgeGame bridgeGame= new AuctionBridgeGame(player1);
		bridgeGame.addPlayerToPair1(player2);
		bridgeGame.addPlayerToPair2(player3);
		bridgeGame.addPlayerToPair2(player4);
		
		bridgeGame.dealCards();
		bridgeGame.sortCardOfAllPlayers();
		bridgeGame.sortCardOfAllPlayers();
		bridgeGame.displayPairs();
	}

}
