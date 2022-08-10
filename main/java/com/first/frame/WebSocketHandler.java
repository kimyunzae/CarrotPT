//package com.first.frame;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.web.socket.TextMessage;
//import org.springframework.web.socket.WebSocketSession;
//import org.springframework.web.socket.handler.TextWebSocketHandler;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.first.biz.ChatBiz;
//import com.first.vo.ChatMessageVO;
//import com.first.vo.CslVO;
//
//import lombok.extern.slf4j.Slf4j;
//
//@Slf4j
//@Component
//public class WebSocketHandler extends TextWebSocketHandler {
//		private final ObjectMapper objectMapper = new ObjectMapper();
//		
//		@Autowired
//		ChatBiz ChatBiz;
//
//	    @Override
//	    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
//	        String payload = message.getPayload();
//	        log.info("payload {}", payload);
//	        TextMessage textMessage = new TextMessage("Welcome!");
//	        session.sendMessage(textMessage);
//	        
//	        ChatMessageVO chatMessage = objectMapper.readValue(payload, ChatMessageVO.class);
//            CslVO room = ChatBiz.getroombyroomid(chatMessage.getRoomId());
//            room.handleActions(session, chatMessage, ChatBiz);
//	        
//	        
//	    }
//	
//}
