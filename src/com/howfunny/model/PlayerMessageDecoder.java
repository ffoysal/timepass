package com.howfunny.model;

import java.io.StringReader;
import java.util.Date;

import javax.json.Json;
import javax.json.JsonObject;
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
		
	}

	@Override
	public PlayerMessage decode(String textMessage) throws DecodeException {
		PlayerMessage playerMessage = new PlayerMessage();
		JsonObject obj = Json.createReader(new StringReader(textMessage))
				.readObject();
		playerMessage.setGameName(obj.getString("gameName"));
		playerMessage.setMessageType(obj.getString("messageType"));
		playerMessage.setConnectionStatus(obj.getString("connectionStatus"));
		playerMessage.setPlayerName(obj.getString("playerName"));
		return playerMessage;
	}

	@Override
	public boolean willDecode(String arg0) {
		// TODO Auto-generated method stub
		return false;
	}

}
