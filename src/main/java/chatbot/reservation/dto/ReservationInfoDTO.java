package chatbot.reservation.dto;

import java.sql.Date;

public class ReservationInfoDTO {
    private Date resDate;
    private String resPeople;
    private String stno;
    private String mno;
    private String errorMSG;


    public ReservationInfoDTO() {
    }

    public ReservationInfoDTO(Date resDate, String resPeople, String stno, String mno) {
        this.resDate = resDate;
        this.resPeople = resPeople;
        this.stno = stno;
        this.mno = mno;
    }

    public Date getResDate() {
        return resDate;
    }

    public void setResDate(Date resDate) {
        this.resDate = resDate;
    }

    public String getResPeople() {
        return resPeople;
    }

    public void setResPeople(String resPeople) {
        this.resPeople = resPeople;
    }

    public String getStno() {
        return stno;
    }

    public void setStno(String stno) {
        this.stno = stno;
    }

    public String getMno() {
        return mno;
    }

    public void setMno(String mno) {
        this.mno = mno;
    }

    public void setErrorMSG(String errorMSG) {this.errorMSG = errorMSG;}

    public String getErrorMSG() {return errorMSG;}
}
