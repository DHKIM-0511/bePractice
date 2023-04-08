<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰 등록</title>
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
			<input type = "hidden" name = "meta" value = "insertResult"><br>
			[제목]<input class="form-control" type = "text" name ="title" style="width:700px"><br>
			[작성자]<input class="form-control" type = "text" name ="writer" style="width:700px"><br>
			[내용]<input class="form-control" type = "text" name ="content" style="width:700px"><br>
			[영상]<input class="form-control" type = "text" name ="videoId" style="width:700px"><br>
			<button class="btn btn-primary btn-sm">등록</button>
		</form>
	</div>
</body>
</html>