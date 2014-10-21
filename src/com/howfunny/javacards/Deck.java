package com.howfunny.javacards;

import java.util.ArrayList;
import java.util.Collections;


public class Deck {
	
	//Deck of 52 Cards.
	private ArrayList<Card> deck;
		
	//The number of Cards already dealt.
	private int cardDealt;
	
	private int size;
	
	private boolean shuffled=false;
	
	//Unshuffled deck of 52 cards.
	public Deck(){
		size = 52;
		deck=new ArrayList<Card>(size);
		//How many cards already created.
		for( int suit = 0; suit <=3; suit++ ){
			for( int rank = 2; rank <=14; rank++ ){
				deck.add(new Card(suit,rank));
			}
		}
		this.cardDealt = 0;
	}
	
	//Shuffle the cards
	public void shuffle(){
		Collections.shuffle(deck);
		shuffled = true;
	}
	//Number of Cards in deck
	public int cardsInDeck(){
		return deck.size() - cardDealt;
	}
	
	/* Deal the next Card from the deck
	 * Send exception if there is no more card in the deck.
	 */
	public Card dealCard(){
		if(shuffled ==false)
			this.shuffle();
		if(cardDealt == size)
			throw new IllegalStateException("No cards in the deck.");
		cardDealt++;
		return deck.get(cardDealt -1);
	}

}
