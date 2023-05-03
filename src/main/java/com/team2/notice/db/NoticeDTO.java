package com.team2.notice.db;

import java.sql.Date;

public class NoticeDTO {
	

	private String noticeTitle;
	private String noticeContents;
	private int noticeNo;
	private Date noticeDate;
	private int noticeRcnt;
	private String noticeFile;
	
	
	
	

	public String getNoticeFile() {
		return noticeFile;
	}
	public void setNoticeFile(String noticeFile) {
		this.noticeFile = noticeFile;
	}
	public int getNoticeRcnt() {
		return noticeRcnt;
	}
	public void setNoticeRcnt(int noticeRcnt) {
		this.noticeRcnt = noticeRcnt;
	}
	public String getNoticeTitle() {
		return noticeTitle;
	}
	public void setnoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}
	public String getnoticeContents() {
		return noticeContents;
	}
	public void setnoticeContents(String noticeContents) {
		this.noticeContents = noticeContents;
	}
	public int getnoticeNo() {
		return noticeNo;
	}
	public void setnoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}

	public Date getnoticeDate() {
		return noticeDate;
	}
	public void setnoticeDate(Date noticeDate) {
		this.noticeDate = noticeDate;
	}
	
	
	@Override
	public String toString() {
		return "noticeTitle=" + noticeTitle + ", noticeContents=" + noticeContents + ", noticeNo=" + noticeNo
				 + ", noticeDate=" + noticeDate + "]";
	}
	

}
