package chatbot.member.dao;

import chatbot.member.dto.MemberDTO;

import java.sql.*;

public class MemberDao implements Dao {

    // 1. Oracle에 접속하기 위한 클래스 객체를 메모리에 로딩
    static {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void save(MemberDTO member) {
        // 2. 오라클 서버 접속 주소, 계정
        String url = "jdbc:oracle:thin:@211.204.195.197:11521:direadb";
        String ORACLE_ID = "chatbot";
        String ORALCE_PASSWORD = "chatbot";


        try {
            // 3. 오라클 서버 접속 객체 생성
            Connection con = DriverManager.getConnection(url, ORACLE_ID, ORALCE_PASSWORD);

            /**
             * 1) 동일 구조의 sql문 반복 사용 시 속도가 빠르다.
             * 동일한 구조의 sql문을 사용할 때 PreparedStatement는 사전에 최적화 작업을 하고
             * 전송시에는 변화되는 값만 넣어서 전송하므로 Statement에 비해서 훨씬 빠른 실행이 가능하다.
             *
             * 2) ?를 나중에 데이터 치환하므로 편리한 프로그래밍이 가능하다.
             */

            String strInsert = "INSERT INTO member VALUES(MEMBER_MNO_SEQ.NEXTVAL, ?, ?, ?, ?)";

            PreparedStatement pstmt = con.prepareStatement(strInsert);
            pstmt.setString(1, member.getId());
            pstmt.setString(2, member.getPassword());
            pstmt.setString(3, member.getName());
            pstmt.setString(4, member.getMobile());

            pstmt.executeUpdate();

            // 6. 객체 해제
            pstmt.close();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
