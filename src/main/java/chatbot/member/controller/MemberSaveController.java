package chatbot.member.controller;

import chatbot.main.controller.Controller;
import chatbot.member.repository.MemberRepository;
import chatbot.member.service.MemberService;

import java.util.Map;

// 회원가입 컨트롤러
public class MemberSaveController implements Controller {

    @Override
    public String process(Map<String, Object> model) {
        System.out.println("2번 선택했네~");


        MemberService memberService = new MemberService(new MemberRepository());
        memberService.join(model);


        return "storeList";
    }
}
