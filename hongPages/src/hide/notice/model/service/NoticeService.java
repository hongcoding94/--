package hide.notice.model.service;

import java.sql.Connection;
import java.util.ArrayList;


import hide.notice.model.dao.NoticeDAO;
import hide.notice.model.vo.Notice;

import static hide.common.JDBCTemplate.*;

public class NoticeService {
	private NoticeDAO nDAO = new NoticeDAO();
	private Connection con;
	
	public ArrayList<Notice> selectList() throws Exception {
		con = getConnection();
		
		ArrayList<Notice> list = nDAO.selectList(con);
		
		close(con);
		
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

	public ArrayList<Notice> selectList(int currentPage, int limit) {
		con = getConnection();
		
		ArrayList<Notice> list = nDAO.selectList(con, currentPage, limit);
		
		close(con);
		
		return list;
		
	}


	public int getSelectListCount(String condition, int currentPage, int limit, String keyword) {
		con = getConnection();
		int result = 0;
		
		if(condition != null && (condition.length()>0 && !condition.equals("null"))) {
			result = nDAO.getSelectListCount(con, condition, keyword);
		}else {
			
			result = nDAO.getListCount(con);
			
		}
		
		return result;
	}

	public ArrayList<Notice> searchNotice(String condition, String keyword, int currentPage, int limit) {
		con = getConnection();
		ArrayList<Notice> list = null;
		
		if(condition != null && (condition.length()>0 && !condition.equals("null"))) {
			list = nDAO.searchList(con,condition,keyword,currentPage, limit);
		}else {
			list = nDAO.selectList(con,currentPage, limit);
		}

		return list;
	}

	public void deleteFree(int fno) {
		
		
	}
}
