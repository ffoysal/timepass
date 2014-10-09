package com.howfunny.model;

import javax.json.Json;
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
		
	}

	@Override
	public String encode(PlayerMessage playerMessage) throws EncodeException {
		return Json.createObjectBuilder()
		.add("gameName",playerMessage.getGameName())
		.add("playerName", playerMessage.getPlayerName())
		.add("messageType", playerMessage.getMessageType())
		.add("connectionStatus", playerMessage.getConnectionStatus()).build().toString();
	}

}
