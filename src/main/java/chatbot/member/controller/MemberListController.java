package chatbot.member.controller;

import chatbot.main.controller.Controller;

import java.util.Map;

public class MemberListController implements Controller {

    @Override
    public String process(Map<String, Object> model) {
        return "리스트로 가라";
    }

}
