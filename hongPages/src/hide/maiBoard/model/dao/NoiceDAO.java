package hide.maiBoard.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import hide.maiBoard.model.vo.Notice;
import hide.maiBoard.*;

public class NoiceDAO {
		prop = new Properties();
		
		String filePath =NoiceDAO.class
						 .getResource("/config/notice.properties")
						 .getPath();
		try {
			
			prop.load(new FileReader(filePath));
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Notice> selectList(Connection con) {
		ArrayList<Notice> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectList");
		
		pstmt = con.prepareStatement(sql);
		
		return null;
	}

}
