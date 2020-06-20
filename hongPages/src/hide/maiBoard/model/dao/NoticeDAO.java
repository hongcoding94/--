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
		
		String filePath = NoticeDAO.class.getResource("/config/notice/properties").getPath();
	
		try {
			prop.load(new FileReader(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Notice> selectList(Connection con) throws Exception {
		ArrayList<Notice> list = null;
		PreparedStatement pstmt= null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectList");
		
		try {
			pstmt=con.prepareStatement(sql);
			rset = pstmt.executeQuery();
			list= new ArrayList<Notice>();
			
			while(rset.next()) {
				Notice m = new Notice();
				
				m.setMno(rset.getInt(1));			// 게시판 글번호
				m.setMtitle(rset.getString(2));		// 게시판 제목
				m.setMcontent(rset.getString(3));	// 게시판 내용
				m.setMwriter(rset.getString(4));	// 게시판 작성자
				m.setMcount(rset.getInt(5));		// 게시판 조회수
				m.setMdate(rset.getDate(6));		// 게시판 작성일
				
				list.add(m);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("[DAO 에러] :" + e.getMessage());
		
		} finally{
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
	
	
}
