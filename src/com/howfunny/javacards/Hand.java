package com.howfunny.javacards;

import java.util.ArrayList;


public class Hand {

	//Cards will be stored here
	private ArrayList<Card> hand;

	private ArrayList<Card> spades =null;
	private ArrayList<Card> hearts=null;
	private ArrayList<Card> diamonds=null;
	private ArrayList<Card> clubs=null;
	
	private boolean sortedBySuite=false;

	public ArrayList<Card> getHand() {
		return hand;
	}

	public ArrayList<Card> getSpades() {
		return spades;
	}

	public ArrayList<Card> getHearts() {
		return hearts;
	}

	public ArrayList<Card> getDiamonds() {
		return diamonds;
	}

	public ArrayList<Card> getClubs() {
		return clubs;
	}

	//Initially empty
	public Hand(){
		hand = new ArrayList<Card>(13);
		spades = new ArrayList<Card>(13);
		hearts = new ArrayList<Card>(13);
		diamonds = new ArrayList<Card>(13);
		clubs = new ArrayList<Card>(13);
	}

	//Clear the hand
	public void clear(){
		hand.clear();
	}

	public void distributeBySuite(){
		if(hand.size() <=0)
			return;
		Card c;
		for(int i=0; i<hand.size(); i++){
			c=hand.get(i);
			switch(c.getSuit()){
			case 0: spades.add(c);
			case 1: hearts.add(c);
			case 2: diamonds.add(c);
			case 3: clubs.add(c);
			default: ;
			}
		}
		sortedBySuite = true;
	}

	/*Add one card to the hand
	 * Throw NullPointerException if the the card is null
	 */
	public void addCard(Card c){
		if(c == null){
			throw new NullPointerException("Null Card cannot be added");
		}
		else{
			hand.add(c);
		}
	}

	//Remove the card from the hand
	public void removeCard(Card c){
		//First check if the the card is in the hand or not.
		hand.remove(c);
	}

	//Remove the card from a specific position
	public void removeCard(int position){
		if(position < 0 || position >= hand.size()){
			throw new IllegalArgumentException("Position does not exist");
		}
		else
			hand.remove(position);
	}

	//Get the card from a specific position
	public Card getCard(int position) {
		if (position < 0 || position >= hand.size())
			throw new IllegalArgumentException("Position does not exist in hand: "
					+ position);
		return hand.get(position);
	}

	//Get the number of the cards in hand.
	public int getCardCount(){
		return hand.size();
	}
	//Sort the cards by suit
	//This algorithm can be optimized........
	public void sortBySuit(){
		ArrayList<Card> newHand = new ArrayList<Card>(hand.size());
		int pos;
		Card card1;
		Card card2;
		while(hand.size() > 0){
			pos =0;
			card1 = hand.get(0);
			for(int i=1 ; i<hand.size() ; i++){
				card2 = hand.get(i);
				if(card1.getRank() < card2.getRank() || 
						(card1.getRank() == card2.getRank() && card1.getSuit() < card2.getSuit() )){
					pos = i;
					card1=card2;
				}
			}
			hand.remove(pos);
			newHand.add(card1);
		}
		hand = newHand;
	}
	//Sort the cards by rank
	public void sortByRank(){

	}
	
	public void displayHand(){
		for(int i=0; i<hand.size(); i++){
			System.out.println(hand.get(i).toString());
		}
	}




}
