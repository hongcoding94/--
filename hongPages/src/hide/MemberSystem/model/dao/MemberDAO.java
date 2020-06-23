package hide.MemberSystem.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import hide.MemberSystem.model.vo.Member;
import static hide.common.JDBCTemplate.*;

public class MemberDAO {
	private Properties prop;
	
	public MemberDAO() {
		prop = new Properties();
		
		String filePath = MemberDAO.class.getResource("/config/member.properties").getPath();
		
		try {
			prop.load(new FileReader(filePath));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int insertMember(Connection con, Member m) throws Exception {
		int result =0;
		PreparedStatement pstmt = null;
		String sql =prop.getProperty("insertMember");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, m.getUserId());
			pstmt.setString(2, m.getUserPssword());
			pstmt.setString(3, m.getUserName());
			pstmt.setString(4, m.getGender());
			pstmt.setInt(5, m.getUserAge());
			pstmt.setString(6, m.getUserPhone());
			pstmt.setString(7, m.getAddress());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("[DAO 에러] : " + e.getMessage());
			
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public Member selectMember(Connection con, Member m) throws Exception {
		Member result = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectMember");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, m.getUserId());
			pstmt.setString(2, m.getUserPssword());
			
			System.out.println("result 조회 전 : " + result);
			
			if(rset.next()) {
				result = new Member();
				
				result.setUserId(m.getUserId());
				result.setUserPssword(m.getUserPssword());
				result.setUserName(rset.getString("userName"));
				result.setGender(rset.getString("Gender"));
				result.setUserAge(rset.getInt("UserAge"));
				result.setUserPhone(rset.getString("UserPhone"));
				result.setAddress(rset.getString("Address"));
				
			}
			System.out.println("result 조회 후 : " +result);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			throw new Exception("[DAO에러] : " +e.getMessage());
			
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
	}

	public int updateMember(Connection con, Member m) throws Exception {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateMember");
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, m.getUserPssword());
			pstmt.setInt(2, m.getUserAge() );
			pstmt.setString(3, m.getUserPhone());
			pstmt.setString(4, m.getAddress());
			pstmt.setString(5, m.getUserId());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
			throw new Exception("[DAO 에러] : " +e.getMessage());
			
		}finally {
			close(pstmt);
			
		}
		
		return result;
	}

	public int deleteMember(Connection con, String userId) throws Exception {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteMember");
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userId);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("[DAO 에러] : " + e.getMessage());
			
		}finally {
			close(pstmt);
			
		}
		
		return result;
	}
}
