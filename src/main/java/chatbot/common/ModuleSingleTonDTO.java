package chatbot.common;

import chatbot.member.dto.MemberDTO;
import chatbot.reservation.dto.ReservationDTO;

public class ModuleSingleTonDTO {
    private MemberDTO memberDto = new MemberDTO();
    private ReservationDTO reservationDto = new ReservationDTO();


    public void setMemberDto(MemberDTO memberDto) {
        this.memberDto = memberDto;
    }

    public void setReservationDto(ReservationDTO reservationDto) {
        this.reservationDto = reservationDto;
    }

    public MemberDTO getMemberDto() {
        return memberDto;
    }

    public ReservationDTO getReservationDto() {
        return reservationDto;
    }
}
