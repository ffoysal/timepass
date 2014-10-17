package com.howfunny.model;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;


public class PlayerMessageEncoder implements Encoder.Text<PlayerMessage>{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(EndpointConfig arg0) {
		// TODO Auto-generated method stub
		System.out.println("Encoder init");
	}

	@Override
	public String encode(PlayerMessage playerMessage) throws EncodeException {
		
		JsonArrayBuilder players = Json.createArrayBuilder();
		for(String p: playerMessage.getPlayers()){
			players.add(p);
		}

		JsonArrayBuilder hand = Json.createArrayBuilder();
		for(String h: playerMessage.getHand()){
			hand.add(h);
		}
		
		
		return Json.createObjectBuilder()
		.add("gameName",playerMessage.getGameName())
		.add("playerName", playerMessage.getPlayerName())
		.add("messageType", playerMessage.getMessageType())
		.add("connectionStatus", playerMessage.getConnectionStatus())
		.add("players",players)
		.add("hand",hand)
		.add("gameInstruction", playerMessage.getGameInstruction()).build().toString();
	}

}
