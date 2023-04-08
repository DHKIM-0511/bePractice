<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰 상세</title>
</head>
<body>
	<%@ include file="/common/header.jsp" %>
	<h2>리뷰 상세 보기</h2>
	<hr>
	<h4>${review.title }</h4>
	
	<div>작성자 : ${review.writer }</div>
	<div>내용 : ${review.content }</div>
	<div>조회수 : ${review.viewCnt }</div>
	<div>내용 : ${review.videoId }</div>
	
	<a href="review?meta=updateForm&reviewId=${review.reviewId}"><button class="btn btn-primary">수정</button></a>
	<a href="review?meta=delete&reviewId=${review.reviewId}">삭제</a>
</body>
</html>