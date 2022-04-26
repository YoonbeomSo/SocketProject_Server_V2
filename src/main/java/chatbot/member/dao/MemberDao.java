package chatbot.member.dao;

import chatbot.common.DBConnect;
import chatbot.member.dto.MemberDTO;

import java.sql.*;

public class MemberDao implements Dao {

    final private DBConnect db;

    public MemberDao() {
        db = DBConnect.getInstance();
    }

    @Override
    public void save(MemberDTO member) {

        Connection connection = null;
        PreparedStatement pstmt = null;
        String sql = "INSERT INTO member VALUES(MEMBER_MNO_SEQ.NEXTVAL, ?, ?, ?, ?)";

        try {
            connection = db.getConnection();

            pstmt = connection.prepareStatement(sql);

            pstmt.setString(1, member.getId());
            pstmt.setString(2, member.getPassword());
            pstmt.setString(3, member.getName());
            pstmt.setString(4, member.getMobile());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }

    @Override
    public MemberDTO findMemberbyId(String id) {

        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs;

        // 대소문자 구분은 회원가입 시 필요할듯
//        String sql = "SELECT * FROM MEMBER WHERE LOWER(id) = LOWER(?)";
        String sql = "SELECT * FROM MEMBER WHERE id=?";

        MemberDTO member = new MemberDTO();

        try {
            connection = db.getConnection();

            pstmt = connection.prepareStatement(sql);

            pstmt.setString(1, id);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                member.setMno(Long.valueOf(rs.getString("mno")));
                member.setId(rs.getString("id"));
                member.setPassword(rs.getString("password"));
                member.setName(rs.getString("name"));
                member.setMobile(rs.getString("mobile"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return member;
    }
}
