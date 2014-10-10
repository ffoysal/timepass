package com.howfunny.model;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonValue;
import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

public class PlayerMessageDecoder implements Decoder.Text<PlayerMessage>{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(EndpointConfig arg0) {
		// TODO Auto-generated method stub
		System.out.println("Decoder init");
		
	}

	@Override
	public PlayerMessage decode(String textMessage) throws DecodeException {
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

	@Override
	public boolean willDecode(String arg0) {
		// TODO Auto-generated method stub
		return false;
	}

}
