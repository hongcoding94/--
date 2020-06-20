package hide.maiBoard.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Notice implements Serializable  {

	private static final long serialVersionUID = 1L;

		private int Mno;
		private String Mtitle;
		private String Mcontent;
		private String Mwriter;
		private int Mcount;
		private Date Mdate;
		
		public Notice() { super(); }

		public Notice(int mno, String mtitle, String mcontent, String mwriter, int mcount, Date mdate) {
			super();
			Mno = mno;
			Mtitle = mtitle;
			Mcontent = mcontent;
			Mwriter = mwriter;
			Mcount = mcount;
			Mdate = mdate;
		}

		public Notice(String mtitle, String mcontent, String mwriter) {
			super();
			Mtitle = mtitle;
			Mcontent = mcontent;
			Mwriter = mwriter;
		}

		@Override
		public String toString() {
			return "Notice [Mno=" + Mno + ", Mtitle=" + Mtitle + ", Mcontent=" + Mcontent + ", Mwriter=" + Mwriter
					+ ", Mcount=" + Mcount + ", Mdate=" + Mdate + "]";
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}

		public int getMno() {
			return Mno;
		}

		public String getMtitle() {
			return Mtitle;
		}

		public String getMcontent() {
			return Mcontent;
		}

		public String getMwriter() {
			return Mwriter;
		}

		public int getMcount() {
			return Mcount;
		}

		public Date getMdate() {
			return Mdate;
		}

		public void setMno(int mno) {
			Mno = mno;
		}

		public void setMtitle(String mtitle) {
			Mtitle = mtitle;
		}

		public void setMcontent(String mcontent) {
			Mcontent = mcontent;
		}

		public void setMwriter(String mwriter) {
			Mwriter = mwriter;
		}

		public void setMcount(int mcount) {
			Mcount = mcount;
		}

		public void setMdate(Date mdate) {
			Mdate = mdate;
		}
		
		
	
}
