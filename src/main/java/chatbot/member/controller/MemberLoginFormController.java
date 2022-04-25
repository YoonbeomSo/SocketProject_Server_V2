package chatbot.member.controller;

import chatbot.main.controller.Controller;

import java.util.HashMap;
import java.util.Map;

public class MemberLoginFormController implements Controller {

    @Override
    public String process(Map<String, Object> model) {

        Map<String, String> render = new HashMap<>();
        render.put("1", "아이디와 비번을 입력하세요");
        model.put("render", render);

        return "memberLoginForm";
    }
}
