package com.howfunny.javacardgame;
import com.howfunny.javacards.*;
import java.util.ArrayList;

public class AuctionBridgeGame implements Game {

	private static int NO_OF_PLAYER_FOR_BRIDGE=4;
	//private Team team;
	private Pair pair1;
	private Pair pair2;
	//private Pair[] pairs;
	
	private ArrayList<Pair> pairs=new ArrayList<Pair>(2);
	
	private Deck deck=null;
	private int playerCount=0;
	private ArrayList<Player> players =new ArrayList<Player>(4);;
	
	private Player leader;

	public AuctionBridgeGame(){
	}
	
	public AuctionBridgeGame(Player leader){
		this.leader=leader;
		playerCount++;
		//Set the originator as leader
		leader.setLeader(true);
		setUpPairs();
	}

	public void initiateGame(){
		deck= new Deck();
	}
	
	public void sortCardOfAllPlayers(){
		this.getAllPlayers();
		for(int i=0; i<players.size();i++){
			players.get(i).getHand().sortCards();
		}
	}

	public ArrayList<Player> getAllPlayers(){
		if(players ==null)
			players = new ArrayList<Player>(4);
		
		players.add(this.getFirstPair().getPlayer1());
		players.add(this.getFirstPair().getPlayer2());
		players.add(this.getSecondPair().getPlayer1());
		players.add(this.getSecondPair().getPlayer2());
		
		return players;
	}

	public void dealCards(){
		System.out.println("dealCards() called...");
		if(this.isReadyForGame()){
			if(deck==null)
				deck=new Deck();
			for(int i=0; i<13; i++){
				this.getFirstPair().getPlayer1().addCard(deck.dealCard());
				this.getFirstPair().getPlayer2().addCard(deck.dealCard());
				this.getSecondPair().getPlayer1().addCard(deck.dealCard());
				this.getSecondPair().getPlayer2().addCard(deck.dealCard());
			}
		}
	}
	
	public boolean addPlayerToPair1(Player player){
		Pair pair= this.getFirstPair();
		if(pair.getNoOfPlayer()>=2){
			return false;
		}
		else{
			pair.addPlayer(player);
			return true;
		}
	}

	public boolean addPlayerToPair2(Player player){
		Pair pair= this.getSecondPair();
		if(pair.getNoOfPlayer()>=2){
			return false;
		}
		else{
			pair.addPlayer(player);
			return true;
		}
	}
	
	public boolean isReadyForGame(){
		if(this.getFirstPair().isReadyToPlay() && this.getSecondPair().isReadyToPlay())
			return true;
		else
			return false;
	}
	
	public void displayPairs(){
		Pair pair;
		for(int i=0;i<2;i++){
			pair=pairs.get(i);
			System.out.println("Pair "+ pair.getPariName()+" cards.." );
			System.out.println("Displaying cards of "+ pair.getPlayer1().getPlayerName()+" ..." );
			pair.getPlayer1().getHand().displayHand();
			System.out.println("Displaying cards of "+ pair.getPlayer2().getPlayerName()+" ..." );
			pair.getPlayer2().getHand().displayHand();
			System.out.println("******************************************************************" );
		}
	}
	
	public void setUpPairs(){
		//pairs=new Pair[2];
		System.out.println("Two pairs are created...");
		pair1=new Pair("A",leader);
		pair2=new Pair("B");//Create the pair without any player
		pairs.add(0, pair1);
		pairs.add(1, pair2);
	}
	
	private Pair getFirstPair(){
		return pairs.get(0);
	}
	private Pair getSecondPair(){
		return pairs.get(1);
	}

	private ArrayList<Pair> getPairs(){
		return pairs;
	}
	
	//We need our customize exception...for now using generalize Exception
/*	public void addPlayer(Player newPlayer) throws Exception{
		if(playerCount <NO_OF_PLAYER_FOR_BRIDGE){
			players.add(newPlayer);
			playerCount++;
		}
		else{
			throw new Exception("Maximum no of player reached..");
		}
	}
*/	
	@Override
	public void start() {
		// TODO Auto-generated method stub
	}
	
	Player player1;
	public static void main(String args[]){
		//player1=new Player("sinha");
//		
//		AuctionBridgeGame game = new AuctionBridgeGame(new Player("Sinha");)
		
		
	}

}
