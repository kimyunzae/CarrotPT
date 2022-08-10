package com.first.vo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.web.socket.WebSocketSession;

import com.first.biz.ChatBiz;

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
public class CslVO{
	private int id;
	private String uid;
	private String tid;
	private String csl_workoutday;
	private Date csl_date;
	private String csl_time;
	private String csl_read;
	private String csl_progress;
	private Date csl_regdate;
	private String age;
	private String gender;
	private String purpose;
	private String frequency;
	
	private String uname;
	private String tname;
	
	private int roomid;
	
	// for INSERT
	public CslVO(String uid, String tid, String csl_workoutday, Date csl_date, String csl_time, String age,
			String gender, String purpose, String frequency) {
		super();
		this.uid = uid;
		this.tid = tid;
		this.csl_workoutday = csl_workoutday;
		this.csl_date = csl_date;
		this.csl_time = csl_time;
		this.age = age;
		this.gender = gender;
		this.purpose = purpose;
		this.frequency = frequency;
	}
	
	// for UPDATE: 상담 희망 날짜, 시간 수정
	public CslVO(int id, Date csl_date, String csl_time) {
		super();
		this.id = id;
		this.csl_date = csl_date;
		this.csl_time = csl_time;
	}
	
	// for UPDATE: 수락 여부 / 상담 여부 수정
	public CslVO(int id, String csl_read) {
		super();
		this.id = id;
		this.csl_read = csl_read;
	}

	public CslVO(int id, int roomid) {
		super();
		this.id = id;
		this.roomid = roomid;
	}
	
//	private Set<WebSocketSession> sessions = new HashSet<>();
//	
//
//    public void handleActions(WebSocketSession session, ChatMessageVO chatMessage, ChatBiz chatService) {
//        if (chatMessage.getMessagetype().equals(ChatMessageVO.MessageType.ENTER)) {
//            sessions.add(session);
//            chatMessage.setMessage(chatMessage.getSender() + "님이 입장했습니다.");
//        }
//        sendMessage(chatMessage, chatService);
//    }
//
//    public <T> void sendMessage(T message, ChatBiz chatService) {
//        sessions.parallelStream().forEach(session -> chatService.sendMessage(session, message));
//    }
//
//
//


	

}