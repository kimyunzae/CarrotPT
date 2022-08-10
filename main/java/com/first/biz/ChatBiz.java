//package com.first.biz;
//
//import java.io.IOException;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.web.socket.TextMessage;
//import org.springframework.web.socket.WebSocketSession;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.first.mapper.CslMapper;
//import com.first.vo.CslVO;
//
//import lombok.extern.slf4j.Slf4j;
//
//@Slf4j
//@Service("chatbiz")
//public class ChatBiz {
//	
//	@Autowired
//	CslMapper dao;
//	
//	private final ObjectMapper objectMapper = new ObjectMapper();
//	
//
//	public void modifyroomid(CslVO v) throws Exception{
//		dao.updateroomid(v);
//	}
//	
//	public int getroomid(int id) throws Exception{
//		return dao.selectroomid(id);
//	}
//	
//	public List<CslVO> getallroomid() throws Exception{
//		return dao.selectallroomid();
//	}
//	
//    public <T> void sendMessage(WebSocketSession session, T message) {
//        try {
//            session.sendMessage(new TextMessage(objectMapper.writeValueAsString(message)));
//        } catch (IOException e) {
//            log.error(e.getMessage(), e);
//        }
//	}
//    
//    public CslVO getroombyroomid(int id) throws Exception{
//    	return dao.selectroombyroomid(id);
//    }
//
//}
