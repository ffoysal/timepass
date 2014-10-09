package com.howfunny.model;

public class PlayerMessage {
	private String gameName="";
	private String playerName="";
	private String messageType="";
	private String connectionStatus="";
	
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
