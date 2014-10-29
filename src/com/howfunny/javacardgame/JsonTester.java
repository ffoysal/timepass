package com.howfunny.javacardgame;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class JsonTester {

	public static String getBidMetrix(BidMetrix bm){
		ObjectMapper mapper = new ObjectMapper();
			try {
				return mapper.writeValueAsString(bm);
				
			} catch (JsonGenerationException e) {
				e.printStackTrace();
			} catch (JsonMappingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
	}
	public static void main(String[] args) {
		BidMetrix bm = new BidMetrix();
		ObjectMapper mapper = new ObjectMapper();
			try {
				System.out.println(mapper.writeValueAsString(bm));
				
			} catch (JsonGenerationException e) {
				e.printStackTrace();
			} catch (JsonMappingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
}
