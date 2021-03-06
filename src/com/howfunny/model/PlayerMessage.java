package com.howfunny.model;

import java.util.ArrayList;
import java.util.List;

import com.howfunny.javacardgame.BidMetrix;

public class PlayerMessage {
	private String gameName;
	private String playerName;
	private String messageType;
	private String connectionStatus;
	private List<String> players; 
	private String gameInstruction;
	private List<String> hand;
	
	public List<String> getHand() {
		return hand;
	}
	public void setHand(List<String> hand) {
		this.hand = hand;
	}
	public PlayerMessage(){
		gameName="";
		playerName="";
		messageType="";
		connectionStatus="";
		players = new ArrayList<String>();
		gameInstruction ="";
		hand = new ArrayList<String>();
		
	}
	public String getGameInstruction() {
		return gameInstruction;
	}
	public void setGameInstruction(String gameInstruction) {
		this.gameInstruction = gameInstruction;
	}
	public List<String> getPlayers() {
		return players;
	}
	public void setPlayers(List<String> players) {
		this.players = players;
	}
	public String getConnectionStatus() {
		return connectionStatus;
	}
	public void setConnectionStatus(String connectionStatus) {
		this.connectionStatus = connectionStatus;
	}
	public String getMessageType() {
		return messageType;
	}
	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}
	public String getGameName() {
		return gameName;
	}
	public void setGameName(String gameName) {
		this.gameName = gameName;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	@Override
	public String toString(){
		return "Game Name: "+ gameName + ", Player Name: "+ playerName;
	}
}
