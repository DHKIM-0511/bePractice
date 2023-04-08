package com.ssafy.review.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.review.model.dto.Review;
import com.ssafy.review.util.DBUtil;

public class ReviewDaoImpl implements ReviewDao{
	private final DBUtil util = DBUtil.getInstance(); 
	
	private static ReviewDaoImpl instance = new ReviewDaoImpl();
	private ReviewDaoImpl() {
		
	}
	public static ReviewDaoImpl getInstance() {
		return instance;
	}
	@Override
	public List<Review> selectAll() {
		String sql ="SELECT * FROM review ORDER BY view_cnt DESC";
		
		List<Review> list = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = util.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Review r = new Review();
				
				r.setReviewId(rs.getInt("reviewId"));
				r.setReviewId(rs.getInt("title"));
				r.setReviewId(rs.getInt("writer"));
				r.setReviewId(rs.getInt("content"));
				r.setReviewId(rs.getInt("view_cnt"));
				r.setReviewId(rs.getInt("videoId"));
				
				list.add(r);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			util.close(rs,stmt,conn);
		}
		return list;
	}

	@Override
	public void insertReview(Review review) {
		String sql = "INSERT INTO review(title,writer,content,videoId) VALUES(?,?,?,?)"; 
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, review.getTitle());
			pstmt.setString(2, review.getWriter());
			pstmt.setString(3, review.getContent());
			pstmt.setInt(4, review.getVideoId());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			util.close(pstmt , conn);
		}
		
	}

	@Override
	public Review selectReview(int reviewId) {
		String sql = "SELECT * FROM review WHERE reviewId = ?";
		
		Connection conn =null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
				
		Review r = new Review();
		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			pstmt.setInt(1, reviewId);
			
			while(rs.next()) {
				r.setReviewId(rs.getInt("reviewId"));
				r.setTitle(rs.getString("title"));
				r.setWriter(rs.getString("writer"));
				r.setContent(rs.getString("content"));
				r.setView_cnt(rs.getInt("view_cnt"));
				r.setVideoId(rs.getInt("videoId"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			util.close(rs,pstmt,conn);
		}
		
		return r;
	}

	@Override
	public Review updateReivew(int reviewId) {
		String sql = "SELECT * FROM review WHERE reviewId = ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		Review r= new Review();
		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				r.setReviewId(rs.getInt("reviewId"));
				r.setTitle(rs.getString("title"));
				r.setWriter(rs.getString("writer"));
				r.setContent(rs.getString("content"));
				r.setView_cnt(rs.getInt("view_cnt"));
				r.setVideoId(rs.getInt("videoId"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			util.close(rs,pstmt,conn);
		}
		return r;
	}

	@Override
	public void update(Review review) {
		String sql = "UPDATE review SET title=? , content =? , WHERE reviewId=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, review.getTitle());
			pstmt.setString(2, review.getContent());
			pstmt.setInt(3, review.getReviewId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			util.close(pstmt, conn);
		}
		
		
	}

	@Override
	public void deleteReview(int reviewId) {
		String sql = "DELETE FROM review WHERE reviewId = ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, reviewId);
			
			System.out.println(pstmt.executeQuery()+"개의 데이터가 지워졌습니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			util.close(pstmt , conn);
		}
		
	}

	@Override
	public void updateReviewCnt(int reviewId) {
		String sql = "UPDATE review SET view_cnt = COALESCE(view_cnt, 0) + 1 WHERE reviewId = ?";
		Connection conn  = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, reviewId);
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			util.close(pstmt , conn);
		}
		
	}
	@Override
	public int login(String userId, String userPw) {
		String sql ="SELECT userPw FROM userInfo WHERE userId = ?";
		Connection conn = null;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				if(rs.getString(1).equals(userPw)) return 1; // login  
				else return 0; //  PW er 
				
			}
			return -1; // ID er 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			util.close(pstmt,conn);
		}
			
		return -2; // DB er
	}

}
