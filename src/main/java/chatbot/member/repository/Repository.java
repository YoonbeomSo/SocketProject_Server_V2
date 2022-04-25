package chatbot.member.repository;

import chatbot.member.dto.MemberDTO;

public interface Repository {

    void save(MemberDTO member);

}
