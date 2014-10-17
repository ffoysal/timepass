package com.howfunny.javacardgame;

public class Team {
	
	private String TeamName;
	
	
	private Player player1;
	private Player player2;
	
	Team(String teamName){
		TeamName=teamName;
	}

	Team(String teamName,Player player){
		TeamName=teamName;
		player1=player;
	}
	Team(String teamName,Player player1,Player player2){
		TeamName=teamName;
		player1=player1;
		player2=player2;
	}
		
	public String getTeamName() {
		return TeamName;
	}
	public void setTeamName(String teamName) {
		TeamName = teamName;
	}
	public Player getPlayer1() {
		return player1;
	}
	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}
	public Player getPlayer2() {
		return player2;
	}
	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}
	
}
