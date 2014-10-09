package com.howfunny.controller;

import java.io.IOException;

import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import com.howfunny.model.PlayerMessage;
import com.howfunny.model.PlayerMessageDecoder;
import com.howfunny.model.PlayerMessageEncoder;
import com.howfunny.model.User;

@ServerEndpoint (value="/fungame/{userName}/{pass}",  encoders = PlayerMessageEncoder.class, decoders = PlayerMessageDecoder.class)
public class ControllerEndpoint {
	
	private static User user = new User();
	
	@OnOpen
	public void  open(@PathParam("userName") String userName,
			@PathParam("pass") String password,
			Session session){
		
		PlayerMessage message = new PlayerMessage();
		if(user.validUser(userName, password)){
			message.setMessageType("AUTHENTICATION");
			message.setConnectionStatus("Connected");
			System.out.println("Connection Successful");
			sendMessage(session,message);
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

	@OnClose
	public void close(Session session){
		System.out.println("Connection Close");
	}
	private void sendMessage(Session session, Object message){
		
			try {
				session.getBasicRemote().sendObject(message);
			} catch (EncodeException | IOException ex) {
				ex.printStackTrace();
			} 
		
		
	}
	
}
