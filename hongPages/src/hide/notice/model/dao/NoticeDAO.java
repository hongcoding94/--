package hide.notice.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import hide.notice.model.vo.Notice;
import static hide.common.JDBCTemplate.*;

public class NoticeDAO {
	private Properties prop;
	
	public NoticeDAO() {
		prop = new Properties();
		
		String FilePath = NoticeDAO.class.getResource("/config/notice.properties").getPath();
		
		try {
			prop.load(new FileReader(FilePath));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Notice> selectList(Connection con) throws Exception {
		ArrayList<Notice> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectList");
		
		try {
			pstmt = con.prepareStatement(sql);
			rset = pstmt.executeQuery();
			list = new ArrayList<Notice>();
			
			while(rset.next()) {
				Notice n = new Notice();
				
				n.setMno(rset.getInt(1));
				n.setMtitle(rset.getString(2));
				n.setMcontent(rset.getNString(3));
				n.setMwriter(rset.getString(4));
				n.setMcount(rset.getInt(5));
				n.setMdate(rset.getDate(6));
				
				list.add(n);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("[DAO 에러] : " + e.getMessage());
		
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public int insertNotice(Connection con, Notice n) throws Exception {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertNotice");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, n.getMtitle());
			pstmt.setString(2, n.getMcontent());
			pstmt.setString(3, n.getMwriter());
			pstmt.setDate(4, n.getMdate());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("[DAO 에러] : " + e.getMessage());
		
		}finally { 
			close(pstmt);
		}
		
		return result;
	}

	public int deleteNotice(Connection con, int mno) throws Exception {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteNotice");
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, mno);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("[DAO 에러] : " +e.getMessage());
			
		}finally {
			close(pstmt);
		
		}
		
		return result;
	}

	public int updateNotice(Connection con, Notice n) throws Exception {
		
		int result = 0;
		PreparedStatement pstmt=null;
		String sql = prop.getProperty("dateNotice");
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, n.getMtitle());
			pstmt.setString(2, n.getMcontent());
			pstmt.setInt(3, n.getMno());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("[DAO에러] : " + e.getMessage());
			
		}finally {
			close(pstmt);
			
		}
		
		return result;
	}

	public Notice selectOne(Connection con, int mno) throws Exception {
		Notice n = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql =prop.getProperty("selectOne");
		
		try {
			pstmt =con.prepareStatement(sql);
			pstmt.setInt(1, mno);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				n = new Notice();
				
				n.setMno(rset.getInt("mno"));
				n.setMtitle(rset.getString("mtitle"));
				n.setMcontent(rset.getString("mcontent"));
				n.setMwriter(rset.getString("mwriter"));
				n.setMcount(rset.getInt("mcount"));
				n.setMdate(rset.getDate("mdate"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("[DAO 에러] : " + e.getMessage());
			
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return n;
	}

	public int updateReadCount(Connection con, int mno) throws Exception {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateReadCount");
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, mno);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("[DAO 에러] : " + e.getMessage());
			
		}finally {
			close(pstmt);
		}
		
		return result;
	}
	
}
