package com.howfunny.javacards;

import java.util.Comparator;

public class Card implements Comparable<Card>{

	public final static int SPADES = 0;   // Codes for the 4 suits, plus Joker.
	public final static int HEARTS = 1;
	public final static int DIAMONDS = 2;
	public final static int CLUBS = 3;
	public final static int JOKER = 4;

	public final static int ACE = 14;      // Codes for the non-numeric cards.
	public final static int JACK = 11;    //   Cards 2 through 10 have their 
	public final static int QUEEN = 12;   //   numerical values for their codes.
	public final static int KING = 13;

	//Cards suite
	private int suit;

	//Cards rank
	private int rank;

	//For ease of calculation Card are started from 2 and the Ace is virtually considered as
	//Card no 14.
	public Card(int suit, int rank)
	{
		if(suit != SPADES && suit != HEARTS &&suit != DIAMONDS &&suit != CLUBS)
			throw new IllegalArgumentException("Invalid card suit");
		if (suit != JOKER && (rank < 2 || rank > 14))
			throw new IllegalArgumentException("Invalid card rank");
		this.setSuit(suit);
		this.setRank(rank);
	}

	public String getSuitAsString(){
		switch ( suit ) {
		case SPADES:   return "S";
		case HEARTS:   return "H";
		case DIAMONDS: return "D";
		case CLUBS:    return "C";
		default:       return "J";
		}
	}

	public String getRankAsString(){
		if(suit == JOKER)
			return Integer.toString(rank);
		else{
			switch (rank) {
			case 2:   return "2";
			case 3:   return "3";
			case 4:   return "4";
			case 5:   return "5";
			case 6:   return "6";
			case 7:   return "7";
			case 8:   return "8";
			case 9:   return "9";
			case 10:  return "10";
			case 11:  return "J";
			case 12:  return "Q";
			case 13:  return "K";
			case 14:  return "A";
			default:  return null;
			}
		}
	}
	
	@Override
	public String toString(){
		if(suit == JOKER){
			if(rank == 1)
				return "Joker";
			else
				return "Joker #" + rank;
		}
		else return getRankAsString() +getSuitAsString();
	}

	public int getSuit() {
		return suit;
	}

	public void setSuit(int suit) {
		this.suit = suit;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	@Override
	public int compareTo(Card c) {
		return Comparators.CARDRANK.compare(this, c);
	}
	
	public static class Comparators {

	        public static Comparator<Card> CARDRANK = new Comparator<Card>() {
	            @Override
	            public int compare(Card c1, Card c2) {
	                return c1.rank-c2.rank;
	            }
	        };
	        public static Comparator<Card> CARDSUIT = new Comparator<Card>() {
	            @Override
	            public int compare(Card c1, Card c2) {
	                return c1.suit-c2.suit;
	            }
	        };
	        public static Comparator<Card> CARDSUITRANK = new Comparator<Card>() {
	            @Override
	            public int compare(Card c1, Card c2) {
	                if(c1.suit==c2.suit){
	                	return c1.rank-c2.rank;
	                }
	                else
	                  	return c1.suit-c2.suit;
	            }
	        };

	  }

}
