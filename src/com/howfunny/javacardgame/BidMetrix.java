package com.howfunny.javacardgame;

import java.util.ArrayList;
import java.util.List;

import com.howfunny.javacardgame.Bid.BidConstant;
import com.howfunny.javacards.Suit;

public class BidMetrix {
	private List<ArrayList<Bid>> metrix = new ArrayList<ArrayList<Bid>>();

	private void createMetrix(){
		ArrayList<Bid> s = new ArrayList<Bid>();
		ArrayList<Bid> h = new ArrayList<Bid>();
		ArrayList<Bid> d = new ArrayList<Bid>();
		ArrayList<Bid> c = new ArrayList<Bid>();
		ArrayList<Bid> n = new ArrayList<Bid>();
		for(int i = 1; i < 7; i++){
			s.add(new Bid(i, Suit.SPADES));
			h.add(new Bid(i, Suit.HEARTS));
			d.add(new Bid(i, Suit.DIAMONDS));
			c.add(new Bid(i, Suit.CLUBS));
			n.add(new Bid(i, Suit.NT));
		}
		
		metrix.add(n);
		metrix.add(s);
		metrix.add(h);
		metrix.add(d);
		metrix.add(c);
		ArrayList<Bid> a = new ArrayList<Bid>();
				a.add(new Bid(BidConstant.PASS));
		metrix.add(a);
		
	}
	public BidMetrix(){
		createMetrix();
	}
	public List<ArrayList<Bid>> getMetrix() {
		return metrix;
	}
	
	
	public static void main(String[] args) {
		BidMetrix bm = new BidMetrix();
		for(ArrayList<Bid> a: bm.getMetrix()){
			for(Bid b: a){
				System.out.print(b.toString() +" ");
			}
			System.out.println();
		}
	}
}
