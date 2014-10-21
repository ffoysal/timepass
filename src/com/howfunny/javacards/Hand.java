package com.howfunny.javacards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;


public class Hand {


	public enum Suite{
		SPADES, HEARTS,DIAMONDS,CLUBS
	}

	public final static int SPADES = 0;   // Codes for the 4 suits, plus Joker.
	public final static int HEARTS = 1;
	public final static int DIAMONDS = 2;
	public final static int CLUBS = 3;
	public final static int JOKER = 4;

	//Cards will be stored here
	private ArrayList<Card> hand;

	private ArrayList<Card> spades =null;
	private ArrayList<Card> hearts=null;
	private ArrayList<Card> diamonds=null;
	private ArrayList<Card> clubs=null;

	private boolean sortedHand=false;

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

	public ArrayList<Card> getCardBySuite(Suite suite) {
		switch(suite) {
		case SPADES:
			return spades;
		case HEARTS:
			return hearts;
		case DIAMONDS:
			return diamonds;
		case CLUBS:
			return clubs;
		default:
			return spades;
		}

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
		spades.clear();
		hearts.clear();
		diamonds.clear();
		clubs.clear();
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
			switch(c.getSuit()){
			case 0: spades.add(c);
			case 1: hearts.add(c);
			case 2: diamonds.add(c);
			case 3: clubs.add(c);
			default: ;
			}
		}
	}

	//Get the card using string representation
	public Card getCard(String rankSuite){
		Card c=this.getCardFromRankSuite(rankSuite);
		if(c == null){
			throw new NullPointerException("No such card...");
		}
		else{
			return c;
		}
	}

	//Remove the card from the hand
	public boolean removeCard(Card c){
		if(hand.contains(c)){
			hand.remove(c);
			switch(c.getSuit()){
			case 0: spades.remove(c);
			case 1: hearts.remove(c);
			case 2: diamonds.remove(c);
			case 3: clubs.remove(c);
			default: ;
			}
		return true;
		}
		else
			return false;
	}

	private Card getCardFromRankSuite(String rankSuite){
		Iterator<Card> itr =hand.iterator();
		Card card=null;
		while(itr.hasNext()){
			card = itr.next();
			if(card.toString().equalsIgnoreCase(rankSuite))
				return card;
		}
		return null;
	}
	
	//Remove the card from the hand
	public boolean removeCard(String rankSuite){
		//First check if the the card is in the hand or not.
		Card c= getCardFromRankSuite(rankSuite);
		if(c==null){
			return false;
		}
		else {
			return removeCard(c);
		}
	}
	
	private ArrayList<String> cardsAsString=new ArrayList<String>(13);
	
	public ArrayList<String> getCardsAsStringList(){
		if(hand.size()<1)
			return null;
		cardsAsString.clear();
		Iterator<Card> itr =hand.iterator();
		Card card=null;
		while(itr.hasNext()){
			card = itr.next();
			if(card.toString()!=null)
				cardsAsString.add(card.toString());
		}
		return cardsAsString;
	}

	/*	//Remove the card from a specific position
	public void removeCard(int position){
		if(position < 0 || position >= hand.size()){
			throw new IllegalArgumentException("Position does not exist");
		}
		else
			hand.remove(position);
	}
	 */

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
	//Get the number of spades in hand.
	public int getSpadeCount(){
		return spades.size();
	}
	public int getHeartsCount(){
		return hearts.size();
	}
	public int getdiamondCount(){
		return diamonds.size();
	}
	public int getClubCount(){
		return clubs.size();
	}

	public int getCardCountBySuite(Suite suite) {
		switch(suite) {
		case SPADES:
			return spades.size();
		case HEARTS:
			return hearts.size();
		case DIAMONDS:
			return diamonds.size();
		case CLUBS:
			return clubs.size();
		default:
			return spades.size();
		}

	}
	//Sort the cards by suit
	//This algorithm can be optimized........
	public void sortBySuit(){
		Collections.sort(hand,Card.Comparators.CARDSUIT);
	}
	//Sort the cards by rank
	public void sortCards(){
		Collections.sort(hand,Card.Comparators.CARDSUITRANK);


		Collections.sort(spades,Card.Comparators.CARDRANK);
		Collections.sort(hearts,Card.Comparators.CARDRANK);
		Collections.sort(diamonds,Card.Comparators.CARDRANK);
		Collections.sort(clubs,Card.Comparators.CARDRANK);
		sortedHand = true;
	}

	public void displayHand(){
		for(int i=0; i<hand.size(); i++){
			System.out.println(hand.get(i).toString());
		}
	}
	public void displaySortedHand(){
		if(!sortedHand)
			sortCards();
		for(int i=0; i<3; i++){

			System.out.println(hand.get(i).toString());
		}
	}
}
