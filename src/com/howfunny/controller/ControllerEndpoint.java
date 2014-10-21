package com.howfunny.controller;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonValue;
import javax.websocket.DecodeException;
import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import com.howfunny.javacardgame.*;
import com.howfunny.model.PlayerMessage;
import com.howfunny.model.PlayerMessageDecoder;
import com.howfunny.model.PlayerMessageEncoder;
import com.howfunny.model.User;

@ServerEndpoint (value="/fungame/{userName}/{pass}",  encoders = {PlayerMessageEncoder.class}, decoders = {PlayerMessageDecoder.class})
public class ControllerEndpoint {
	
	private static User user = new User();
	
	@OnOpen
	public void  open(@PathParam("userName") String userName,
			@PathParam("pass") String password,
			Session session){
		
		PlayerMessage message = new PlayerMessage();
		if(user.validUser(userName, password)){
			session.getUserProperties().put("userName", userName);
			message.setMessageType("AUTHENTICATION");
			message.setConnectionStatus("Connected");			
			System.out.println("Connection Successful");
			message.setPlayers(logedInUserNames(session));
			//Create a player with his name
			Player player =new Player(userName);
			sendMessage(session,message);
			
			message.setMessageType("NEWUSER");
			//sendMessage(session,message);
			broadCastMessage(session, message);
		}else{
			message.setMessageType("AUTHENTICATION");
			message.setConnectionStatus("User Name or Password is wrong");
			System.out.println("Not Successful");
			sendMessage(session,message);
			try {
				session.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	private List<String> logedInUserNames(Session session){
		List<String> players = new ArrayList<String>();
		players.add((String)session.getUserProperties().get("userName"));
		for(Session s: session.getOpenSessions()){
			if(!s.equals(session)){
				players.add((String)s.getUserProperties().get("userName"));
			}
		}
		
		return players;
	}
	private void broadCastMessage(Session originSession, PlayerMessage message){
		for(Session s: originSession.getOpenSessions()){
			if(!s.equals(originSession)){
				sendMessage(s, message);
			}
		}
	}
	
//	@OnMessage
//	public void onMessage(final Session session, final PlayerMessage playerMessage) {
//		System.out.println(playerMessage.getGameInstruction());
//	}
	@OnMessage
	public void onMessage(final Session session, final String msg) {
		try {
			PlayerMessage pm = decode(msg);
			System.out.println(pm.getGameInstruction());
			if(pm.getGameInstruction().equalsIgnoreCase("CREATE")){
				AuctionBridgeGame bridgeGame = new AuctionBridgeGame();
				sendMessage(session,pm);
			}
			if(pm.getGameInstruction().equalsIgnoreCase("DEAL")){
				pm.setHand(Arrays.asList("10C","10H","4C","AC"));
				pm.setMessageType("DEAL_RESULT");
				sendMessage(session,pm);
			}
			
		} catch (DecodeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@OnClose
	public void close(Session session){
		System.out.println("Connection Close");
	}
	private void sendMessage(Session session, PlayerMessage message){
		
			try {
				session.getBasicRemote().sendObject(message);
			} catch (EncodeException | IOException ex) {
				ex.printStackTrace();
			} 
		
		
	}
	
	// For now decode method here, as of now the automatic decoder class not working
	private PlayerMessage decode(String textMessage) throws DecodeException {
		PlayerMessage playerMessage = new PlayerMessage();
		JsonObject obj = Json.createReader(new StringReader(textMessage)).readObject();
		
		playerMessage.setGameName(obj.getString("gameName"));
		playerMessage.setMessageType(obj.getString("messageType"));
		playerMessage.setConnectionStatus(obj.getString("connectionStatus"));
		playerMessage.setPlayerName(obj.getString("playerName"));
		
		JsonArray jsonArray = obj.getJsonArray("players");
		List<String> players = new ArrayList<String>();
		for(JsonValue v: jsonArray){
			players.add(v.toString());
		}
		playerMessage.setPlayers(players);
		playerMessage.setGameInstruction(obj.getString("gameInstruction"));
		return playerMessage;
	}
}
