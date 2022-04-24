package chatbot.member.controller;

import chatbot.main.controller.Controller;

import java.util.HashMap;
import java.util.Map;

public class MemberFormController implements Controller {

    @Override
    public String process(Map<String, Object> model) {

        Map<String, String> render = new HashMap<>();
        render.put("1", "로그인");
        render.put("2", "회원가입");

        model.put("render", render);

        return "loginForm";
    }

}
