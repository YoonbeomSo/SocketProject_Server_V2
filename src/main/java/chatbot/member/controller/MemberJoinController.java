package chatbot.member.controller;

import chatbot.main.controller.Controller;
import chatbot.member.dao.MemberDao;
import chatbot.member.service.MemberService;

import java.util.HashMap;
import java.util.Map;

// 회원가입 컨트롤러
public class MemberJoinController implements Controller {

    @Override
    public String process(Map<String, Object> model) {

        MemberService memberService = new MemberService(new MemberDao());
        memberService.join(model);

        model.put("successMessage", "회원가입이 완료되었습니다.");

        // 회원가입 이후 맨 처음 화면으로 돌려보냄
        Map<String, String> render = new HashMap<>();
        render.put("1", "로그인");
        render.put("2", "회원가입");

        model.replace("render", render);

        return "memberForm";
    }
}
