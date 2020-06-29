package hide.freeBoard.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import hide.freeBoard.model.vo.*;

import static hide.common.JDBCTemplate.*;
public class FreeDAO {
	private Properties prop;

	public FreeDAO() {
		prop = new Properties();
		
		String FilePath = FreeDAO.class.getResource("/config/free.properties").getPath();
	
		try {
			prop.load(new FileReader(FilePath));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int insertFree(Connection con, FreeBoard fb) throws Exception {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertFree");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, fb.getFtitle());
			pstmt.setString(2, fb.getFcontent());
			pstmt.setString(3, fb.getFwriter());
			pstmt.setDate(4, fb.getFdate());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("[DAO 에러] : " + e.getMessage());
		}finally{
			close(pstmt);
		}
		
		return result;
	}

	public int updateFreeBoard(Connection con, FreeBoard fb) throws Exception {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertFree");
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, fb.getFtitle());
			pstmt.setString(2, fb.getFcontent());
			pstmt.setInt(3, fb.getFno());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("[DAO에러] : " +e.getMessage());
			
		}finally{
			close(pstmt);
		}
		
		return result;
	}

	public int deleteFreeBoard(Connection con, int fno) throws Exception {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteFree");
		
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, fno);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("[DAO에러] : " + e.getMessage());
			
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int updateReadCount(Connection con, int fno) throws Exception {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateFree");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, fno);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("[DAO에러] : " + e.getMessage());
			
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public FreeBoard selectOne(Connection con, int fno) throws Exception {
		FreeBoard fb = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectOneFree");
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, fno);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				fb = new FreeBoard();
				
				fb.setFno(rset.getInt("fno"));
				fb.setFtitle(rset.getString("ftitle"));
				fb.setFcontent(rset.getString("fcontent"));
				fb.setFwriter(rset.getString("fwriter"));
				fb.setFcount(rset.getInt("fcount"));
				fb.setFdate(rset.getDate("fdate"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("[DAO에러] : " +e.getMessage());
			
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return fb;
	}

	public int getSelectListCount(Connection con, String condition, String keyword) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = null;
		
		switch(condition) {
		case "writer" : 
			sql = prop.getProperty("countWriterFree");
			break;
		case "tilte" :
			sql = prop.getProperty("countTitleFree");
			break;
		case "content" :
			sql = prop.getProperty("countContentFree");
			break;
		}
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, keyword);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result =rset.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}finally {
			close(rset);
			close(pstmt);
			
		}
		return result;
	}

	public ArrayList<FreeBoard> searchList(Connection con, String condition, String keyword, int currentPage, int limit) {
		ArrayList<FreeBoard> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = null;
		 switch(condition) {
		 case "writer" : 
				sql = prop.getProperty("countWriterFree");
				break;
			case "tilte" :
				sql = prop.getProperty("countTitleFree");
				break;
			case "content" :
				sql = prop.getProperty("countContentFree");
				break;
			}
		  
		  try {
			  pstmt = con.prepareStatement(sql);
			  
			  int startRow = (currentPage - 1) * limit + 1;
			  int endRow = startRow + limit - 1;
			  
			  pstmt.setString(1, keyword);
			  pstmt.setInt(2, endRow);
			  pstmt.setInt(3, startRow);			
			  
			  rset = pstmt.executeQuery();
			  
			  list = new ArrayList<FreeBoard>();
			  
			  while(rset.next()) {
				  FreeBoard fb = new FreeBoard();
				  
				  fb.setFno(rset.getInt("fno"));
				  fb.setFtitle(rset.getString("ftitle"));
				  fb.setFcontent(rset.getString("fcontent"));
				  fb.setFwriter(rset.getString("fwriter"));
				  fb.setFcount(rset.getInt("fcount"));
				  fb.setFdate(rset.getDate("fdate"));
				  
				  list.add(fb);
			  }
		  } catch (SQLException e) {
			  e.printStackTrace();
		  }finally{
			  close(rset);
			  close(pstmt);
		  }
		  
		  return list;
	  }

	public ArrayList<FreeBoard> selectList(Connection con, int currentPage, int limit) {
		ArrayList<FreeBoard> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectFree");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			int startRow = (currentPage - 1) * limit + 1;
			int endRow = startRow + limit - 1;
			
			pstmt.setInt(1, endRow);
			pstmt.setInt(2, startRow);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<FreeBoard>();
			
			while(rset.next()) {
				FreeBoard fb = new FreeBoard();
				
				fb.setFno(rset.getInt("fno"));
				fb.setFtitle(rset.getString("ftitle"));
				fb.setFcontent(rset.getString("fcontent"));
				fb.setFwriter(rset.getString("fwriter"));
				fb.setFcount(rset.getInt("fcount"));
				fb.setFdate(rset.getDate("fdate"));
				
				list.add(fb);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}		
		
		return list;
	}

	public int getListCount(Connection con) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("listCountFree");
		
		try {
			pstmt = con.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
	}


}
