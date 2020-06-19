package hong.notice.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class notice implements Serializable {

	private static final long serialVersionUID = 1L;

	private int Mno;
	private String mtitle;
	private String Mcontent;
	private String Mwriter;
	private int mcount;
	private Date mdate;
	
	
	public notice() { super(); }


	public notice(int mno, String mtitle, String mcontent, String mwriter, int mcount, Date mdate) {
		super();
		Mno = mno;
		this.mtitle = mtitle;
		Mcontent = mcontent;
		Mwriter = mwriter;
		this.mcount = mcount;
		this.mdate = mdate;
	}

	public notice(String mtitle, String mcontent, String mwriter) {
		super();
		this.mtitle = mtitle;
		Mcontent = mcontent;
		Mwriter = mwriter;
	}


	@Override
	public String toString() {
		return "notice [Mno=" + Mno + ", mtitle=" + mtitle + ", Mcontent=" + Mcontent + ", Mwriter=" + Mwriter
				+ ", mcount=" + mcount + ", mdate=" + mdate + "]";
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public int getMno() {
		return Mno;
	}


	public String getMtitle() {
		return mtitle;
	}


	public String getMcontent() {
		return Mcontent;
	}


	public String getMwriter() {
		return Mwriter;
	}


	public int getMcount() {
		return mcount;
	}


	public Date getMdate() {
		return mdate;
	}


	public void setMno(int mno) {
		Mno = mno;
	}


	public void setMtitle(String mtitle) {
		this.mtitle = mtitle;
	}


	public void setMcontent(String mcontent) {
		Mcontent = mcontent;
	}


	public void setMwriter(String mwriter) {
		Mwriter = mwriter;
	}


	public void setMcount(int mcount) {
		this.mcount = mcount;
	}


	public void setMdate(Date mdate) {
		this.mdate = mdate;
	}
	
	
	
	
}
