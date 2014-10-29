package com.howfunny.javacardgame;

import com.howfunny.javacards.Suit;

public class Bid{
	public enum BidConstant{
		PASS
	}
	private boolean enable = true;
	private int weight;
	private Suit suit;
	private BidConstant other;
	
	public Bid(int r, Suit s){
		weight = r;
		suit = s;		
	}
	
	public Bid(BidConstant bc){
		other = bc;
	}

	public boolean isEnable() {
		return enable;
	}
	public void setEnable(boolean enable) {
		this.enable = enable;
	}
	public int getWeight() {
		return weight;
	}
	public Suit getSuit() {
		return suit;
	}
	public BidConstant getOther() {
		return other;
	}
	
	@Override
	public String toString(){
		if(this.weight > 0)
		return ""+weight+suit.getSymbol();
		else
			return other.name();
	}
	
		
}
