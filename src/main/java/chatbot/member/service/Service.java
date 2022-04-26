package chatbot.member.service;

import chatbot.member.dto.MemberDTO;

import java.util.Map;

public interface Service {

    boolean join(Map<String, Object> model);

    boolean login(Map<String, Object> model);

}
