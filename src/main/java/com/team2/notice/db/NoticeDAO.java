package com.team2.notice.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

// DB에 연결해서 처리하는 모든동작 수행
public class NoticeDAO {
	Connection con = null;
	String sql = "";
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	//디비연결
	private void getCon() throws Exception{
		Context init = new InitialContext(); //업캐스팅
		// 고정문구"java:comp/env/다른문구context파일의 name값입력"
		DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/class7_230118_team2");
		con = ds.getConnection();
		System.out.println("DAO: 디비연결성공"+con);
	}//getCon닫음
	
	//자원해제 메서드 구현
	public void closeDB(){
		try{
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(con != null) con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}//closeDB닫음
	
	// 글쓰기
	public int insertNotice(NoticeDTO dto) {
		int result = 0;
		int noticeNo = 0;
		
		try {
			getCon();
			sql = "select max(noticeNo) from notice";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				noticeNo = rs.getInt(1)+1; // 인덱스 사용 호출
			}
			System.out.println("DAO : 글번호 " + noticeNo);
			
			// 정보 저장(글쓰기)
			sql = "insert into notice(noticeNo,noticeTitle,noticeContents,noticeDate,noticeRc,noticeFile) values(?,?,?,now(),?,?)";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, noticeNo);
			pstmt.setString(2, dto.getNoticeTitle());
			pstmt.setString(3, dto.getnoticeContents());
			pstmt.setInt(4, 0);
			pstmt.setString(5, dto.getNoticeFile());
		
			
			// sql 실행
			result = pstmt.executeUpdate();
			System.out.println(" 글쓰기 완료! ");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		
		return result;
	} // 글쓰기
	
	// 게시글 카운트
	public int getNoticeCount() {
		int cnt = 0;
		
		try {
			getCon();
			sql="select count(*) from notice";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				cnt = rs.getInt(1);
			}
			System.out.println("DAO : DB에 저장된 글의 수 " + cnt);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		
		return cnt;
	} // 게시글 카운트
	
	// 게시글 불러오기
	public List<NoticeDTO> getNoticeList() {
		
		List<NoticeDTO> noticeList = new ArrayList<NoticeDTO>(); // 업캐스팅
		
		try {
			getCon();
			sql="select * from notice";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				NoticeDTO dto = new NoticeDTO();
				dto.setnoticeNo(rs.getInt("noticeNo"));
				dto.setnoticeTitle(rs.getString("noticeTitle"));
				dto.setnoticeContents(rs.getString("noticeContents"));
				dto.setnoticeDate(rs.getDate("noticeDate"));
				dto.setNoticeRcnt(rs.getInt("noticeRc"));
				dto.setNoticeFile(rs.getString("NoticeFile"));
				
				noticeList.add(dto);
				
				System.out.println(dto);
			}
			System.out.println("DAO : 게시글 불러오기");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		return noticeList;
	} // 게시글 불러오기

	


}//DAO
