<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰 전체 목록</title>
</head>
<body>
	<%@ include file="/common/header.jsp" %>
	
	<h2>리뷰 목록</h2>
	<table class="table table-striped table-bordered">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>글쓴이</th>
			<th>내용</th>
			<th>조회수</th>
			<th>영상</th>
		</tr>
		<c:forEach items="${list}" var="review">
			<tr>
				<td>${review.reviewId}</td>
				
				<td>
					<a href="review?meta=detail&reviewId=${review.reviewId}">${review.title}</a>
				</td>
				<td>${review.writer}</td>
				<td>${review.content}</td>
				<td>${review.viewCnt}</td>
				<td>${review.videoId}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>