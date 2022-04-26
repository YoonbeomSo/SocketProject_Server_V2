package chatbot.member.controller;

import chatbot.main.controller.Controller;
import chatbot.member.dao.MemberDao;
import chatbot.member.service.MemberService;

import java.util.HashMap;
import java.util.Map;

public class MemberLoginController implements Controller {

    @Override
    public String process(Map<String, Object> model) {

        MemberService memberService = new MemberService(new MemberDao());
        boolean isLogined = memberService.login(model);

        Map<String, String> render = new HashMap<>();

        Map<String, String> requestParamMap = (Map<String, String>) model.get("requestParam");
        String requestId = requestParamMap.get("id");

        if (requestId.equals("admin") && isLogined) {
            model.put("successMessage", "Admin 로그인 되었습니다");
            model.put("forward", "adminForm");

        } else if (isLogined) {
            model.put("successMessage", "로그인 되었습니다");
            model.remove("errorMessage");
            model.put("forward", "reservationForm");
        } else {
            model.put("errorMessage", "접속 정보가 틀렸습니다");
            render.put("1", "아이디와 비번을 입력하세요");
            model.put("render", render);
            return "memberLoginForm";
        }

        return null;
    }

}
