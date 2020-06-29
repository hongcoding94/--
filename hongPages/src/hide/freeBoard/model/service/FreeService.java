package hide.freeBoard.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import hide.freeBoard.model.dao.FreeDAO;
import hide.freeBoard.model.vo.*;

import static hide.common.JDBCTemplate.*;

public class FreeService {
	private FreeDAO fDAO = new FreeDAO();
	private Connection con;
	
	public int insertFree(FreeBoard fb) throws Exception {
		con = getConnection();
		
		int result = fDAO.insertFree(con, fb);
		
		if(result > 0)commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
	}

	public int updateFreeBoard(FreeBoard fb) throws Exception {
		con = getConnection();
		
		int result = fDAO.updateFreeBoard(con, fb);
		
		if(result>0) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
	}

	public int deleteFree(int fno) throws Exception {
		con = getConnection();
		
		int result = fDAO.deleteFreeBoard(con, fno);
		
		if(result>0) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
		
	}

	public FreeBoard selectOne(int fno) throws Exception {
		con = getConnection();
		
		FreeBoard fb = fDAO.selectOne(con, fno);
		
		if(fb != null) {
			int result = fDAO.updateReadCount(con,fno);
			
			if(result>0) commit(con);
			else rollback(con);
			
		}
		close(con);
		
		return fb;
	}

	public int getSelectListCount(String condition, int currentPage, int limit, String keyword) {
		con = getConnection();
		int result = 0;
		
		if(condition != null && (condition.length()>0 && !condition.equals("null"))) {
			result = fDAO.getSelectListCount(con, condition, keyword);
		}else {
			
			result = fDAO.getListCount(con);
			
		}
		
		return result;
	}

	public ArrayList<FreeBoard> searchfreeBoard(String condition, String keyword, int currentPage, int limit) {
		con = getConnection();
		ArrayList<FreeBoard> list = null;
		
		if(condition != null && (condition.length()>0 && !condition.equals("null"))) {
			list = fDAO.searchList(con,condition,keyword,currentPage, limit);
		}else {
			list = fDAO.selectList(con,currentPage, limit);
		}

		return list;
	}
	
	
}
