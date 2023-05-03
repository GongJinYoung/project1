<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<a href="#">소개</a>
		<a href="#">예약하기</a>
		<a href="#">커뮤니티</a>
		
	</div>
	
	
	<div>
		<h1> 공지사항(관리자) </h1>
	</div>
	
	<form action="./NoticeWriteAction.park" method="post" enctype="multipart/form-data" name="fr">
	<div>
		제목 : <input type="text" name="title">
	</div>
	
	<div>
		내용 : <textarea rows="5" cols="10" name="contents" placeholder="내용을 입력하세요."></textarea>
	</div>
	
	<div>
		첨부파일 : <input type="file" name="file">
	</div>
	
	<div>
		<input type="submit" value="등록">
	</div>
	
	<div>
		<input type="button" value="목록으로" onclick="location.href='./noticeList.park'">
	</div>
	</form>
</body>
</html>