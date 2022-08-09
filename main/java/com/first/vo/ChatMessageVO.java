package com.first.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ChatMessageVO {
	
	public enum MessageType{
		ENTER, TALK
	}
	
	private MessageType messagetype;
	private int roomId;
	private String sender;
	private String message;
	
	public ChatMessageVO(int roomId, String sender, String message) {
		super();
		this.roomId = roomId;
		this.sender = sender;
		this.message = message;
	}
	
	
}
