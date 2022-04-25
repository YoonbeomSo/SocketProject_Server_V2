package chatbot.common;

import chatbot.member.dto.MemberDTO;
import chatbot.reservation.dto.ReservationInfoDTO;

public class ModuleSingleTonDTO {
    private MemberDTO memberDto = new MemberDTO();
    private ReservationInfoDTO reservationDto = new ReservationInfoDTO();


    public void setMemberDto(MemberDTO memberDto) {
        this.memberDto = memberDto;
    }

    public void setReservationDto(ReservationInfoDTO reservationDto) {
        this.reservationDto = reservationDto;
    }

    public MemberDTO getMemberDto() {
        return memberDto;
    }

    public ReservationInfoDTO getReservationDto() {
        return reservationDto;
    }
}
