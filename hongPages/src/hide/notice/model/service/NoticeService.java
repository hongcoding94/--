package hide.notice.model.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import hide.notice.model.dao.NoticeDAO;
import hide.notice.model.vo.Notice;

import static hide.common.JDBCTemplate.*;

public class NoticeService {
	private NoticeDAO nDAO = new NoticeDAO();
	private Connection con;
	private Properties prop;
	
	public ArrayList<Notice> selectList(int currentPage, int limit) {
		ArrayList<Notice> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectList");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			int startRow = (currentPage - 1) * limit + 1;
			int endRow = startRow + limit - 1;
			
			pstmt.setInt(1, endRow);
			pstmt.setInt(2, startRow);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<Notice>();
			
			while(rset.next()) {
				Notice n = new Notice();
				
				n.setMno(rset.getInt("nno"));
				n.setMtitle(rset.getString("ntitle"));
				n.setMcontent(rset.getString("ncontent"));
				n.setMwriter(rset.getString("nwriter"));
				n.setMcount(rset.getInt("ncount"));
				n.setMdate(rset.getDate("ndate"));
				
				list.add(n);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}		
		
		return list;

	}

	public int insertNotice(Notice n) throws Exception {
		con = getConnection();
		
		int result = nDAO.insertNotice(con, n);
		
		if(result > 0) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
		
	}

	public int deleteNotice(int mno) throws Exception {
		con = getConnection();
		
		int result = nDAO.deleteNotice(con, mno);
		
		if(result >0) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
		
		
	}

	public int updateNotice(Notice n) throws Exception {
		con = getConnection();
		
		int result = nDAO.updateNotice(con, n);
		
		if(result>0) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
		
	}

	public Notice selectOne(int mno) throws Exception {
		con = getConnection();
		
		Notice n = nDAO.selectOne(con, mno);
		
		if(n != null) {
			int result = nDAO.updateReadCount(con,mno);
			
			if(result>0) commit(con);
			else rollback(con);
		}
		close(con);
		
		return n;
	}

	public int getSelectListCount(String condition, int currentPage, int limit, String keyword) {
		con = getConnection();
		int result = 0;
		
		if(condition != null && (condition.length()>0 && !condition.equals("null"))) {
			result = nDAO.searchList(con, condition, keyword);
			
		} else {
			result = nDAO.selectList(con);
		}
		
		close(con);
	
		return result;
	}

	public ArrayList<Notice> searchNotice(String condition, String keyword, int currentPage, int limit) throws Exception {
		con = getConnection();
		ArrayList<Notice> list = null;
		
		if(condition != null && (condition.length()>0 && !condition.equals("null"))) {
			list = nDAO.searchList(con, condition, keyword
														, currentPage, limit);
			
		} else {
			list = nDAO.selectList(con,	currentPage, limit);
		}
		
		close(con);
		
		return list;
	}

	public ArrayList<Notice> selectList() {
		con = getConnection();
		
		ArrayList<Notice> list = nDAO.selectList(con);
		
		close(con);
		
		return list;
	}

	
}
