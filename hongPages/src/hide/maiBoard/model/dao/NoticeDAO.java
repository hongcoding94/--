package hide.maiBoard.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import hide.maiBoard.model.vo.Notice;
import static hide.common.JDBCTemplate.*;

public class NoticeDAO {
	private Properties prop;
	
	public NoticeDAO() {
		prop = new Properties();
		
		String filePath = NoticeDAO.class
							.getResource("/config/notice.properties")
							.getPath();
		
		try {
			prop.load(new FileReader(filePath));
			
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
				n.setMcontent(rset.getString(3));
				n.setMwriter(rset.getString(4));
				n.setMcount(rset.getInt(5));
				n.setMdate(rset.getDate(6));
				
				list.add(n);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("[DAO에러] : " + e.getMessage());
		
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public int insertNotice(Connection con, Notice m) throws Exception {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertNotice");
		
		try {
			pstmt=con.prepareStatement(sql);
			
			pstmt.setString(1, m.getMtitle());
			pstmt.setString(2, m.getMcontent());
			pstmt.setString(3, m.getMwriter());
			pstmt.setDate(4, m.getMdate());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("[DAO에러] : " + e.getMessage());
			
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public int updateNotice(Connection con, Notice m) throws Exception {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateNotice");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, m.getMtitle());
			pstmt.setString(2, m.getMcontent());
			pstmt.setInt(3, m.getMno());
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("[DAO에러] : " + e.getMessage());
			
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
			throw new Exception("[DAO에러] : " + e.getMessage());
			
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public Notice selectOne(Connection con, int mno) {
		Notice m = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectOne");
		
		try {
			pstmt= con.prepareStatement(sql);
			pstmt.setInt(1, nno);
			
			rset = pstmt.executeQuery();
			while(rset.next()) {
				m = new Notice();
				
				m.setMno(rset.getInt("mno"));
				m.setMtitle(rset.getString("Mtitle"));
				m.setMcontent(rset.getString("Mcontent"));
				m.setMwriter(rset.getString("mwriter"));
				m.setMcount(rset.getInt("mcount"));
				m.setMdate(rset.getDate("mdate"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("[DAO에러] : " + e.getMessage());
			
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return m;
	}
}
