package chatbot.reservation.dto;



public class ReservationInfoDTO {
    private String resdate;
    private String respeople;
    private String mno;
    private String resno;
    private String stno;
    private String stname;
    private String restime;

    public ReservationInfoDTO() {
    }

    public ReservationInfoDTO(String resdate, String respeople, String mno, String resno, String stno, String stname, String restime) {
        this.resdate = resdate;
        this.respeople = respeople;
        this.mno = mno;
        this.resno = resno;
        this.stno = stno;
        this.stname = stname;
        this.restime = restime;
    }

    public String getResdate() {
        return resdate;
    }

    public void setResdate(String resdate) {
        this.resdate = resdate;
    }

    public String getRespeople() {
        return respeople;
    }

    public void setRespeople(String respeople) {
        this.respeople = respeople;
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
                "resdate='" + resdate + '\'' +
                ", respeople='" + respeople + '\'' +
                ", mno='" + mno + '\'' +
                ", resno='" + resno + '\'' +
                ", stno='" + stno + '\'' +
                ", stname='" + stname + '\'' +
                ", restime='" + restime + '\'' +
                '}';
    }
}