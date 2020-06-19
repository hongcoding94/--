package hide.maiBoard.model.service;

import static hide.common.JDBCTemplate.*;


import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.http.HttpServlet;

import hide.maiBoard.model.vo.mainBoard;
import hide.maimainBoard.model.dao.mainBoardDAO;


public class mainBoardService {
	private mainBoard bDAO = new mainBoard();
	private Connection con;
	
	public ArrayList<mainBoard> selectList() throws Exception {
		con = getConnection();
		
		ArrayList<mainBoard> list = bDAO.selectList(con);
		
		close(con);
		
		return list;
	}

	public mainBoard selectOne(int nno) throws Exception {
		con = getConnection();
		
		mainBoard n = bDAO.selectOne(con, nno);
		
		if(n != null) {
			// 조회수 1증가
			int result = bDAO.updateReadCount(con, nno);
			
			if(result > 0) commit(con);
			else rollback(con);
		}
		
		close(con);
		
		return n;
	}

	public int insertmainBoard(mainBoard n) throws Exception {
		con = getConnection();
		
		int result = bDAO.insertmainBoard(con, n);
		
		if(result > 0) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
	}

	public mainBoard updateView(int nno) throws Exception {
		con = getConnection();
		mainBoard n = bDAO.selectOne(con, nno);
		
		close(con);
		
		return n;
	}

	public int updatemainBoard(mainBoard n) throws Exception {
		con = getConnection();
		
		int result = bDAO.updatemainBoard(con, n);
		
		if(result > 0) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
	}

	public int deletemainBoard(int nno) throws Exception {
		con = getConnection();
		
		int result = bDAO.deletemainBoard(con, nno);
		
		if(result > 0) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
	}

	public ArrayList<mainBoard> searchmainBoard(String condition, String keyword) throws Exception {
	      con = getConnection();
	      ArrayList<mainBoard> list = null;
	      
	      // 컨디션에 뭐라도 내용이 들어왔다면
	      // 조건부 검색 실시(제목, 내용 등)
	      if(condition.length() > 0) {
	         list = bDAO.searchList(con,condition,keyword);
	      } else { // 검색 조건이 없다면 전체 검색을 실시
	         list = bDAO.selectList(con);
	      }
	      
	      close(con);
	      
	      return list;
	   }
	
	
}
