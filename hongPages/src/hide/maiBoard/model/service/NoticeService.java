package hide.maiBoard.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import hide.maiBoard.model.dao.NoticeDAO;
import hide.maiBoard.model.vo.Notice;

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

	public int inserNotice(Notice m) throws Exception {
		con = getConnection();
		
		int result = nDAO.insertNotice(con, m);
		
		if(result > 0) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
	}

	public int updateNotice(Notice m) throws Exception {
		con = getConnection();
		
		int result = nDAO.updateNotice(con,m);
		
		if(result >0) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
		
		
	}

	public int deleteNotice(int mno) throws Exception {
		con= getConnection();
		
		int result = nDAO.deleteNotice(con,mno);
		
		if(result > 0) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
		
	}

	public Notice viewBoard(int mno) {
		con = getConnection();
		Notice m = nDAO.selectOne(con,mno);
		
		close(con);
		
		return m;
	}
	
}
