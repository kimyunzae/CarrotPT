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
public class ChatRoomVO {
	private int roomId;
	private int participants;
	public ChatRoomVO(int participants) {
		super();
		this.participants = participants;
	}
	
	
}
