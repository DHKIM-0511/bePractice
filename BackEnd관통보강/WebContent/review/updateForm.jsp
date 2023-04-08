<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰 수정</title>
	<style type="text/css">
		#form {
			margin: 0 auto;
          	text-align: center;
		}
		
		form {
			display: inline-block;
		}
	</style>
</head>
<body>
	<%@ include file="/common/header.jsp" %>
	
	<div id ="form">
		<form class="validation-form" method="post" action="review">
		<input type="hidden" name="meta" value="update"><br>
		<input type= "hidden" name="reviewId" value="${review.reviewId }"><br>
		[제목]<input calss = "form-control" type="text" name="title" value="${review.title }"><br>
		[작성자]<input calss = "hidden" type="text" name="writer" value="${review.writer }"><br>
		[내용]<input calss = "form-control" type="text" name="content" value="${review.content }"><br>
		[영상]<input calss = "hidden" type="text" name="videoId" value="${review.videoId }"><br>
		<button class="btn btn-primary btn-sm">수정</button>
		</form>
	</div>
</body>
</html>