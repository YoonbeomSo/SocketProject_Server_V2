package chatbot.common;

import java.sql.Date;

public class StoreDTO {
    private String stno;
    private String stName;

    public StoreDTO(String stno, String stName) {
        this.stno = stno;
        this.stName = stName;
    }

    public StoreDTO() {

    }

    public String getStno() {
        return stno;
    }

    public void setStno(String stno) {
        this.stno = stno;
    }

    public String getStName() {
        return stName;
    }

    public void setStName(String stName) {
        this.stName = stName;
    }

}
