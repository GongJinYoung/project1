<%@page import="com.team2.notice.db.NoticeDAO"%>
<%@page import="com.team2.notice.db.NoticeDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		// request 영역에 noticeList 저장
		ArrayList<NoticeDTO> noticeList = (ArrayList<NoticeDTO>) request.getAttribute("noticeList"); // 캐스팅
		int cnt = (int)request.getAttribute("cnt");
		
		// 페이징 정보 저장
		String pageNum = (String)request.getAttribute("pageNum");
		int pageCount = (Integer)request.getAttribute("pageCount");
		int pageBlock = (Integer)request.getAttribute("pageBlock");
		int startPage = (Integer)request.getAttribute("startPage");
		int endPage = (Integer)request.getAttribute("endPage");
		
		// 게시판 모든 내용을 화면에 출력
		String id = (String) session.getAttribute("id");
		
// 		NoticeDAO dao = new NoticeDAO();
// 		dao.getNoticeList();
	%>
	
	게시글 개수 : <%=noticeList.size() %>
	
		<div id="contents">
	게시판 총 글의 수 : <%=cnt%> 개
	<%
	if(id == null){
	%>
	<input type="button" value="로그인" onclick="location.href='./MemberLogin.me'">
	<%
	
	}
	%>
	<br>
	<table border="1">
	<tr>
		<th>글번호</th>
		<th>제목</th>
		<th>작성일</th>
		<th>조회수</th>
		<th>첨부파일</th>
	</tr>
	
	<%
	//size()메서드는 배열의 요소의 갯수를 리턴
	for(int i=0;i<noticeList.size(); i++){
		//ArrayList 한칸의 정보 ->BoardBean 객체 하나로 이동
		NoticeDTO dto = (NoticeDTO)noticeList.get(i);
	%>
	<tr>
		<td><%=dto.getnoticeNo()%></td>
		<td>
	
		<a href="./BoardContent.bo?bno=<%=dto.getnoticeNo()%>&pageNum=<%=pageNum%>"><%=dto.getNoticeTitle()%></a></td>
		<td><%=dto.getnoticeDate()%></td>
		<td><%=dto.getNoticeRcnt()%></td>
		<td><%=dto.getNoticeFile() %></td>
	
	</tr>
	<%
	}
	%>
	</table>
	</div>
		
	<%
 // 다른 페이지 이동 버튼
 if(cnt != 0){
	%>
	<div id="pageBlock">
	<%
	 // 이전
	 if(startPage > pageBlock){
		 %>
			<a href="./noticeList.park?pageNum=<%=startPage-pageBlock%>">[이전]</a>
		 <%
	 }
	 // 숫자 (1...10/11...20/.....)
	 for(int i=startPage;i<=endPage;i++){
		 %>
		   <a href="./noticeList.park?pageNum=<%=i%>">[<%=i %>]</a>
		 <%
	 }
	 // 다음
	 if(endPage < pageCount){
		 %>
		   <a href="./noticeList.park?pageNum=<%=startPage+pageBlock%>">[다음]</a>
		 <%
	 }
	%>
	</div>
	<% 
 }     
%>
	
</body>
</html>