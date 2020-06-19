package hide.maiBoard.model.vo;

import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;

public class mainBoard {

	private int mno;			// 게시글 번호
	private String mtitle;		// 게시글 제목
	private String mcontent;	// 게시글 내용
	private String mwriter;		// 게시글 작성자
	private Date mdate;			// 게시글 작성일
	
	public mainBoard() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public mainBoard(int mno, String mtitle, String mcontent, String mwriter, Date mdate) {
		super();
		this.mno = mno;
		this.mtitle = mtitle;
		this.mcontent = mcontent;
		this.mwriter = mwriter;
		this.mdate = mdate;
	}
	
	public mainBoard(String mtitle, String mcontent, String mwriter) {
		super();
		this.mtitle = mtitle;
		this.mcontent = mcontent;
		this.mwriter = mwriter;
	}
	
	@Override
	public String toString() {
		return "mainBoard [mno=" + mno + ", mtitle=" + mtitle + ", mcontent=" + mcontent + ", mwriter=" + mwriter
				+ ", mdate=" + mdate + "]";
	}
	
	public int getMno() {
		return mno;
	}
	public String getMtitle() {
		return mtitle;
	}
	public String getMcontent() {
		return mcontent;
	}
	public String getMwriter() {
		return mwriter;
	}
	public Date getMdate() {
		return mdate;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public void setMtitle(String mtitle) {
		this.mtitle = mtitle;
	}
	public void setMcontent(String mcontent) {
		this.mcontent = mcontent;
	}
	public void setMwriter(String mwriter) {
		this.mwriter = mwriter;
	}
	public void setMdate(Date mdate) {
		this.mdate = mdate;
	}

	
	
}
