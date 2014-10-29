package com.howfunny.javacards;

import org.codehaus.jackson.annotate.JsonValue;

public enum Suit {
	SPADES(0,"S"), HEARTS(1,"H"), DIAMONDS(2,"D"), CLUBS(3,"C"), JOCKER(4,"J"), NT(5,"N");
	
	public int getValue() {
		return value;
	}
	@JsonValue
	public String getSymbol() {
		return symbol;
	}
	private int value;
	
	private String symbol;
	
	Suit(int v, String n){
		this.value = v;
		this.symbol = n;
	}
}
