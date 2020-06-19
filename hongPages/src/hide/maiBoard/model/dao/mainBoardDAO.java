package hide.maiBoard.model.dao;

import static hide.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import hide.maiBoard.model.vo.mainBoard;

public class mainBoardDAO {
	private Properties prop;
	
	public mainBoardDAO(){
		prop = new Properties();
		
		String filePath =mainBoardDAO.class
						 .getResource("/config/mainBoard.properties")
						 .getPath();
		try {
			
			prop.load(new FileReader(filePath));
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<mainBoard> selectList(Connection con) throws Exception {
		ArrayList<mainBoard> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectList");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<mainBoard>();
			
			while(rset.next()) {
				mainBoard n = new mainBoard();
				
				n.setMno(rset.getInt(1));
				n.setMtitle(rset.getString(2));
				n.setMcontent(rset.getString(3));
				n.setMwriter(rset.getString(4));
				n.setMdate(rset.getDate(5));
				
				list.add(n);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
			throw new Exception("[ DAO 에러 ] : " + e.getMessage());
			
		} finally {
			close(rset);
			close(pstmt);
		}		
		
		return list;
	}

	public mainBoard selectOne(Connection con, int nno) throws Exception {
		mainBoard n = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectOne");
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, nno);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				n = new mainBoard();
				
				n.setMno(rset.getInt("nno"));
				n.setMtitle(rset.getString("ntitle"));
				n.setMcontent(rset.getString("ncontent"));
				n.setMwriter(rset.getString("nwriter"));
				n.setMdate(rset.getDate("ndate"));
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
			throw new Exception("[ DAO 에러 ] : " + e.getMessage());
			
		} finally {
			close(rset);
			close(pstmt);
		}		
		
		return n;
	}

	public int updateReadCount(Connection con, int nno) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateReadCount");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, nno);
			result = pstmt.executeUpdate();
			
		} catch(SQLException e) {
			
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int insertmainBoard(Connection con, mainBoard n) throws Exception {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertmainBoard");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, n.getMtitle());
			pstmt.setString(2, n.getMcontent());
			pstmt.setString(3, n.getMwriter());
			pstmt.setDate(4, n.getMdate());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("[ DAO 에러 ] : " + e.getMessage());
			
		} finally {
			close(pstmt);
		}	
		
		return result;
	}

	
	public int updatemainBoard(Connection con, mainBoard n) throws Exception {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updatemainBoard");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, n.getMtitle());
			pstmt.setString(2, n.getMcontent());
			pstmt.setInt(3, n.getMno());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("[ DAO 에러 ] : " + e.getMessage());
			
		} finally {
			close(pstmt);
		}	
		
		return result;
	}
	
	public int deletemainBoard(Connection con, int nno) throws Exception {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deletemainBoard");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, nno);
			result = pstmt.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
			throw new Exception("[ DAO 에러 ] : " + e.getMessage());
			
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public ArrayList<mainBoard> searchList(Connection con, String condition, String keyword) throws Exception {
		ArrayList<mainBoard> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = null;
		
		switch(condition){
			case "writer" : // 작성자로 검색을 햇다면
				sql = prop.getProperty("searchWritermainBoard");
				break;
			case "title" :  //제목으로 검색 할 경우
				sql = prop.getProperty("searchTitlemainBoard");
				break;
			case "content" : // 내용으로 검색할 경우
				sql = prop.getProperty("searchContentmainBoard");
				break;
		}
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, keyword);
			
			rset = pstmt.executeQuery();
			list = new ArrayList<mainBoard>();
			
			while(rset.next()) {
				mainBoard n = new mainBoard();
				
				n.setMno(rset.getInt(1));
				n.setMtitle(rset.getString(2));
				n.setMcontent(rset.getString(3));
				n.setMwriter(rset.getString(4));
				n.setMdate(rset.getDate(5));
				
				list.add(n);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
			throw new Exception("[ DAO 에러 ] : " + e.getMessage());
			
		} finally {
			close(rset);
			close(pstmt);
		}	
		
		
		return list;
	}

}