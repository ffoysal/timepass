package com.howfunny.javacardgame;
import com.howfunny.javacards.*;
import java.util.ArrayList;

public class AuctionBridgeGame implements Game {

	private static int NO_OF_PLAYER_FOR_BRIDGE=4;
	private Deck deck;
	private int playerCount=0;
	private ArrayList<Player> players;
	
	private Player leader;
	
	public AuctionBridgeGame(Player leader){
		this.leader=leader;
		players.add(leader);
		playerCount++;
		//Set the originator as leader
		leader.setLeader(true);
	}
	
	public void initiateGame(){
		deck= new Deck();
	}
	
	
	//We need our customize exception...for now using generalize Exception
	public void addPlayer(Player newPlayer) throws Exception{
		if(playerCount <NO_OF_PLAYER_FOR_BRIDGE){
			players.add(newPlayer);
			playerCount++;
		}
		else{
			throw new Exception("Maximum no of player reached..");
		}
	}
	
	@Override
	public void start() {
		// TODO Auto-generated method stub
		
	}

}
