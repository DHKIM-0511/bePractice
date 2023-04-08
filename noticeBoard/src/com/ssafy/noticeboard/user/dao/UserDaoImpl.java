package com.ssafy.noticeboard.user.dao;

import java.sql.*;
import com.ssafy.noticeboard.util.DBUtil;

public class UserDaoImpl implements UserDao{
	
	private final DBUtil util = DBUtil.getInstance(); 
	
	private static UserDaoImpl instance = new UserDaoImpl();
	private UserDaoImpl() {
		
	}
	public static UserDaoImpl getInstance() {
		return instance;
	}
	
	public int login(String user_id , String user_pw) {
		String sql ="SELECT user_pw FROM USERS WHERE user_id=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user_id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString(1).equals(user_pw)) return 1; // 로그인 성공
				else return 0; // pw 불일치
			}
			return -1; // id 없음
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -2; //  db로유
	}
}
