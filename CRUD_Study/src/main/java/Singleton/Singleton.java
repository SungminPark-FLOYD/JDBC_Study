package Singleton;


import Util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
        Singleton 생성

 */
public class Singleton {

    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    private static Singleton instance = null;

    //외부에서 생성자를 사용할 수 없도록 접근자를 private로 선언
    private Singleton() {}
    public static Singleton getInstance() {
        if(instance == null) {
            //인스턴스가 없으면 하나 생성해서 instance필드에 저장한다.
            instance = new Singleton();
        }
        return instance;
    }

    public Member insertMem(Member member) {
        try{
            conn = DBUtil.getConnection();

            String sql = "insert into MYMEMBER(mem_id, mem_pass, mem_name, mem_tel, mem_addr) VALUES (?,?,?,?,?) ";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, member.getMemId());
            pstmt.setString(2, member.getMemPass());
            pstmt.setString(3, member.getMemName());
            pstmt.setString(4, member.getMemTel());
            pstmt.setString(5, member.getMemAddr());
            int cnt = pstmt.executeUpdate();

            if(cnt > 0) System.out.println("회원 등록 성공!!");
            else System.out.println("회원 등록 실패~~~");

        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (pstmt!=null) try{pstmt.close();}catch (SQLException e) {}
            if (conn!=null) try{conn.close();}catch (SQLException e) {}
        }

        return member;
    }

}
