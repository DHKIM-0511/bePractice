package com.ssafy.review.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.review.model.dao.ReviewDaoImpl;
import com.ssafy.review.model.dto.Review;

/**
 * Servlet implementation class ReviewController
 */
@WebServlet("/review")
public class ReviewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ReviewDaoImpl dao = ReviewDaoImpl.getInstance();
   
    @Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		if(req.getMethod().equals("POST")) {
			req.setCharacterEncoding("UTF-8");
		}
		
		String meta = req.getParameter("meta");
		
		switch(meta) {
		case "list":
			doList(req, resp);
			break;
		case "insert":
			doInsert(req, resp);
			break;
		case "insertResult":
			doInsertResult(req, resp);
			break;
		case "detail":
			doDetail(req, resp);
			break;
		case "delete":
			doDeleteReview(req, resp);
			break;
		case "updateForm":
			doUpdateForm(req, resp);
			break;
		case "update":
			doUpdate(req, resp);
			break;
		case "loginForm":
			doLoginForm(req, resp);
			break;
		case "login":
			doLogin(req, resp);
			break;
		default:
			break;
		}
	}
	private void doLogin(HttpServletRequest req, HttpServletResponse resp) {
		String userId = req.getParameter("userId");
		String userPw = req.getParameter("userPw");
		
		dao.login(userId, userPw);
		
		try {
			req.getRequestDispatcher("/review?meta=login&userId="+userId+"&userPw="+userPw).forward(req, resp);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void doLoginForm(HttpServletRequest req, HttpServletResponse resp) {
		try {
			req.getRequestDispatcher("/review/loginForm.jsp").forward(req, resp);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void doUpdate(HttpServletRequest req, HttpServletResponse resp) {
		Review r = new Review();
		
		r.setReviewId(Integer.parseInt(req.getParameter("reviewId")));
		r.setTitle(req.getParameter("title"));
		r.setWriter(req.getParameter("writer"));
		r.setContent(req.getParameter("content"));
		r.setVideoId(Integer.parseInt(req.getParameter("videoId")));
		
		dao.update(r);
		
		try {
			req.getRequestDispatcher("/review?meta=detail&reviewId="+r.getReviewId()).forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void doUpdateForm(HttpServletRequest req, HttpServletResponse resp) {
		int reviewId = Integer.parseInt(req.getParameter("reviewId"));
		
		try {
			req.setAttribute("review", dao.updateReivew(reviewId));
			req.getRequestDispatcher("/review/updateForm.jsp").forward(req, resp);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void doDeleteReview(HttpServletRequest req, HttpServletResponse resp) {
		int reviewId = Integer.parseInt(req.getParameter("reviewId"));
		
		dao.deleteReview(reviewId);
		try {
			resp.sendRedirect("review?meta=list");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void doDetail(HttpServletRequest req, HttpServletResponse resp) {

		int reviewId = Integer.parseInt(req.getParameter("reviewId"));
		
		dao.updateReviewCnt(reviewId);
		try {
			req.setAttribute("review", dao.selectReview(reviewId));
			req.getRequestDispatcher("review/detail.jsp").forward(req, resp);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void doInsertResult(HttpServletRequest req, HttpServletResponse resp) {
		Review r = new Review();
		
		r.setTitle(req.getParameter("title"));
		r.setWriter(req.getParameter("writer"));
		r.setContent(req.getParameter("content"));
		r.setVideoId(Integer.parseInt(req.getParameter("videoId")));
		
		dao.insertReview(r);
	}

	private void doInsert(HttpServletRequest req, HttpServletResponse resp) {
		try {
			req.getRequestDispatcher("/review/insert.jsp").forward(req, resp);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void doList(HttpServletRequest req, HttpServletResponse resp) {
		try {
			req.setAttribute("list", dao.selectAll());
			req.getRequestDispatcher("/review/list.jsp").forward(req, resp);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
