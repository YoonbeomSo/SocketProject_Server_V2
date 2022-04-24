package chatbot.member.controller;

import chatbot.main.controller.Controller;

import java.util.Map;

public class MemberListController implements Controller {

    @Override
    public String process(Map<String, Object> model) {
        System.out.println("1번 선택했구나~");
        return "memberList";
    }

}
