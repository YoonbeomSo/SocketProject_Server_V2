package chatbot.reservation.dto;

public class AbleInfoDTO {
    private String stno;
    private String abTime;
    private String abPeople;

    public AbleInfoDTO(String stno, String abTime, String abPeople) {
        this.stno = stno;
        this.abTime = abTime;
        this.abPeople = abPeople;
    }

    public String getStno() {
        return stno;
    }

    public void setStno(String stno) {
        this.stno = stno;
    }

    public String getAbTime() {
        return abTime;
    }

    public void setAbTime(String abTime) {
        this.abTime = abTime;
    }

    public String getAbPeople() {
        return abPeople;
    }

    public void setAbPeople(String abPeople) {
        this.abPeople = abPeople;
    }
}
