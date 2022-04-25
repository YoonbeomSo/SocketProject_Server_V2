package chatbot.member.service;

import chatbot.member.dto.MemberDTO;
import chatbot.member.repository.MemberRepository;

import java.util.Map;

public class MemberService implements Service {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Map<String, Object> model) {

        // 여기 파싱 확인해봐야 할듯..? 왠지 파싱 이렇게하면 안나올거같음
        MemberDTO member = (MemberDTO) model.get("member");;
        memberRepository.save(member);
    }

}
