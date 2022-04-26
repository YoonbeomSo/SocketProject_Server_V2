package chatbot.reservation.dto;

public class AbleInfoDTO {
    private String stno;
    private int abTime;
    private int abPeople;

    public AbleInfoDTO(String stno, int abTime, int abPeople) {
        this.stno = stno;
        this.abTime = abTime;
        this.abPeople = abPeople;
    }

    public AbleInfoDTO() {

    }

    public String getStno() {
        return stno;
    }

    public void setStno(String stno) {
        this.stno = stno;
    }

    public int getAbTime() {
        return abTime;
    }

    public void setAbTime(int abTime) {
        this.abTime = abTime;
    }

    public int getAbPeople() {
        return abPeople;
    }

    public void setAbPeople(int abPeople) {
        this.abPeople = abPeople;
    }
}



