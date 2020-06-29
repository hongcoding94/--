package hide.freeBoard.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class FreeBoard implements Serializable {

	private static final long serialVersionUID = 1123L;

	private int Fno;
	private String Ftitle;
	private String Fcontent;
	private String Fwriter;
	private int Fcount;
	private Date Fdate;
	
	public FreeBoard() { super(); }

	public FreeBoard(int fno, String ftitle, String fcontent, String fwriter, int fcount, Date fdate) {
		super();
		Fno = fno;
		Ftitle = ftitle;
		Fcontent = fcontent;
		Fwriter = fwriter;
		Fcount = fcount;
		Fdate = fdate;
	}

	/* 해당 필요에 의한 필드 선언 */
	
	@Override
	public String toString() {
		return "FreeBoard [Fno=" + Fno + ", Ftitle=" + Ftitle + ", Fcontent=" + Fcontent + ", Fwriter=" + Fwriter
				+ ", Fcount=" + Fcount + ", Fdate=" + Fdate + "]";
	}

	public int getFno() {
		return Fno;
	}

	public String getFtitle() {
		return Ftitle;
	}

	public String getFcontent() {
		return Fcontent;
	}

	public String getFwriter() {
		return Fwriter;
	}

	public int getFcount() {
		return Fcount;
	}

	public Date getFdate() {
		return Fdate;
	}

	public void setFno(int fno) {
		Fno = fno;
	}

	public void setFtitle(String ftitle) {
		Ftitle = ftitle;
	}

	public void setFcontent(String fcontent) {
		Fcontent = fcontent;
	}

	public void setFwriter(String fwriter) {
		Fwriter = fwriter;
	}

	public void setFcount(int fcount) {
		Fcount = fcount;
	}

	public void setFdate(Date fdate) {
		Fdate = fdate;
	}
	
	
}
