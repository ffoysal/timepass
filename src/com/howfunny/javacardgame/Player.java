package com.howfunny.javacardgame;

import com.howfunny.javacards.*;

public class Player {
	
	private String PlayerName;
	private int PlayerId;
	private String PlayerNumber;
	
	private Hand hand;
	private boolean isVirtualDealer;
	private String partnerName;
	private int partnerId;
	private int groupeId;
	private int opponentGroupeId;
	
	private boolean isLeader;

	public boolean isLeader() {
		return isLeader;
	}

	public void setLeader(boolean isLeader) {
		this.isLeader = isLeader;
	}

	//Constructor
	public Player(String PlayerName){
		this.PlayerName = PlayerName;
		this.hand= new Hand();
		isVirtualDealer = false;
	}
	
	//Constructor
	public Player(int PlayerId){
		this.PlayerId = PlayerId;
	}

	
	public void play(){
		//TODO
	}

	public int getOpponentGroupeId() {
		return opponentGroupeId;
	}

	public void setOpponentGroupeId(int opponentGroupeId) {
		this.opponentGroupeId = opponentGroupeId;
	}

	public int getGroupeId() {
		return groupeId;
	}

	public void setGroupeId(int groupeId) {
		this.groupeId = groupeId;
	}
	
	public String getPartnerName() {
		return partnerName;
	}

	public void setPartnerName(String partnerName) {
		this.partnerName = partnerName;
	}

	public int getPartnerId() {
		return partnerId;
	}

	public void setPartnerId(int partnerId) {
		this.partnerId = partnerId;
	}
	
	public int getPlayerId() {
		return PlayerId;
	}
	
	public void setPlayerId(int playerId) {
		PlayerId = playerId;
	}
	
	public boolean isVirtualDealer() {
		return isVirtualDealer;
	}
	
	public void setVirtualDealer(boolean isVirtualDealer) {
		this.isVirtualDealer = isVirtualDealer;
	}
	
	public String getPlayerName() {
		return PlayerName;
	}

	public void setPlayerName(String playerName) {
		PlayerName = playerName;
	}
	

}
