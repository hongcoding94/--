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
	
}
