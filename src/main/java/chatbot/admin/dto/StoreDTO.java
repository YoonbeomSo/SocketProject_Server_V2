package chatbot.admin.dto;

public class StoreDTO {
    private String stNo;
    private String stName;

    public StoreDTO(String stNo, String stName) {
        this.stNo = stNo;
        this.stName = stName;
    }

    public StoreDTO(String stName) {
        this.stName = stName;
    }
//    public static StoreDTO joinMember(String id, String password, String name, String mobile) {
//        StoreDAO.getInstance().insert(new MemberDTO(id, password, name, mobile));
//        return StoreDAO.getInstance().getMember(id);
//
//
//    }
//
//    public static StoreDTO addStore(int mno, String id, String password, String name, String mobile) {
//        return new StoreDTO(mno, id, password, name, mobile);
//    }

    public String getStName() {
        return stName;
    }

    public String getStNo() {
        return stNo;
    }

    public void setStName(String stName) {
        this.stName = stName;
    }

    public void setStNo(String stNo) {
        this.stNo = stNo;
    }
}
