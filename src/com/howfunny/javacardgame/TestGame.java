package com.howfunny.javacardgame;

import com.howfunny.javacards.*;

import java.util.Collection;
import java.util.Collections;

public class TestGame {

	public static void main(String[] args) {
	
		Deck d = new Deck();
		d.shuffle();
		Card c;
		
		Hand h1=new Hand();
		Hand h2=new Hand();
		Hand h3=new Hand();
		Hand h4=new Hand();
		
		
		
		Hand h=new Hand();
		
		h1.clear();
		
		for(int i=0; i<13; i++){
			h1.addCard(d.dealCard());
			h2.addCard(d.dealCard());
			h3.addCard(d.dealCard());
			h4.addCard(d.dealCard());
		}

		System.out.println("Cards for Player 1:  \n");
		for(int i=0; i<13; i++){
			System.out.println(h1.getCard(i).toString());
		}
		
		
		Collections.sort(h1.getHand(), Card.Comparators.CARDSUITRANK);

		System.out.println("Cards for Player 1:  \n");
		for(int i=0; i<13; i++){
			System.out.println(h1.getCard(i).toString());
		}
		
		h1.distributeBySuite();
		Collections.sort(h1.getSpades(),Card.Comparators.CARDRANK);
		System.out.println("**************************************************************");
		System.out.println("All spades for Player 1:  \n");
		for(int i=0; i<h1.getSpades().size(); i++){
			System.out.println(h1.getSpades().get(i).toString());
		}
		
		System.out.println("**************************************************************");
		
		System.out.println("Cards for Player 2:  \n");
		for(int i=0; i<13; i++){
			System.out.println(h2.getCard(i).toString());
		}
		
//		c=d.dealCard();
//		System.out.println(c.toString());
		

	}

}
