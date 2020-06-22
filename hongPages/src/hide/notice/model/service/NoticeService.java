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
	
	
}
