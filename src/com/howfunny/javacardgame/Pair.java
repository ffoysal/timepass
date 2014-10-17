package com.howfunny.javacardgame;

import java.util.ArrayList;

public class Pair {
	
	private String pairName;
	private ArrayList<Player> players = new ArrayList<Player>(2);
	//private Player[] players =new Player[2];;
	
	Pair(String pairName){
		pairName=pairName;
	}

	Pair(String pairName,Player player1){
		//players[0]=player1;
		players.add(player1);
		pairName=pairName;
	}
	Pair(String pairName,Player player1,Player player2){
		players.add(player1);
		players.add(player2);
//		players[0]=player1;
//		players[1]=player2;
		pairName=pairName;
	}
	
	public boolean isReadyToPlay(){
		if(players.size()==2)
			return true;
		else
			return false;
	}
	
	//We will return an exception later
	public boolean addPlayer(Player player){
		if(players.size()<2){
			players.add(player);
			return true;
		}
		else
			return false;
	}
	
	public int getNoOfPlayer(){
		return players.size();
	}
	
	public String getPariName() {
		return pairName;
	}
	public void setPairName(String pairName) {
		pairName = pairName;
	}
	public Player getPlayer1() {
		return players.get(0);
	}
	public void setPlayer1(Player player1) {
		this.players.set(0, player1);
	}
	public Player getPlayer2() {
		return players.get(1);
	}
	public void setPlayer2(Player player2) {
		this.players.set(1, player2);
	}
	
}
