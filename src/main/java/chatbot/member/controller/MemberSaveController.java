package chatbot.member.controller;

import chatbot.main.controller.Controller;

import java.util.Map;

public class MemberSaveController implements Controller {

    @Override
    public String process(Map<String, Object> model) {
        return "세이브로 가라";
    }
}
