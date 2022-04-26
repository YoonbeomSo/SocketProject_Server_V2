package chatbot.reservation.dto;



public class ReservationInfoDTO {
    private String resDate;
    private String resPeople;
    private String mno;
    private String resno;
    private String stno;
    private String stname;
    private String restime;

    public ReservationInfoDTO() {
    }

    public ReservationInfoDTO(String resDate, String resPeople, String mno, String resno, String stno, String stname, String restime) {
        this.resDate = resDate;
        this.resPeople = resPeople;
        this.mno = mno;
        this.resno = resno;
        this.stno = stno;
        this.stname = stname;
        this.restime = restime;
    }

    public String getResDate() {
        return resDate;
    }

    public void setResDate(String resDate) {
        this.resDate = resDate;
    }

    public String getResPeople() {
        return resPeople;
    }

    public void setResPeople(String resPeople) {
        this.resPeople = resPeople;
    }

    public String getMno() {
        return mno;
    }

    public void setMno(String mno) {
        this.mno = mno;
    }

    public String getResno() {
        return resno;
    }

    public void setResno(String resno) {
        this.resno = resno;
    }

    public String getStno() {
        return stno;
    }

    public void setStno(String stno) {
        this.stno = stno;
    }

    public String getStname() {
        return stname;
    }

    public void setStname(String stname) {
        this.stname = stname;
    }

    public String getRestime() {
        return restime;
    }

    public void setRestime(String restime) {
        this.restime = restime;
    }

    @Override
    public String toString() {
        return "ReservationInfoDTO{" +
                "resdate='" + resDate + '\'' +
                ", respeople='" + resPeople + '\'' +
                ", mno='" + mno + '\'' +
                ", resno='" + resno + '\'' +
                ", stno='" + stno + '\'' +
                ", stname='" + stname + '\'' +
                ", restime='" + restime + '\'' +
                '}';
    }
}