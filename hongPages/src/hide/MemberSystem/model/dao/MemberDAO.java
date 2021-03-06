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
		int result = 0;
		PreparedStatement pstmt = null;
		String sql =prop.getProperty("insertMember");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, m.getUserId());
			pstmt.setString(2, m.getUserPassword());
			pstmt.setString(3, m.getUserName());
			pstmt.setString(4, m.getUserPhone());
			pstmt.setString(5, m.getAddress());
			pstmt.setInt(6, m.getUserAge());
			pstmt.setString(7, m.getGender());
			
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
		//System.out.println(m);
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, m.getUserId());
			pstmt.setString(2, m.getUserPassword());
			// 회원
			rset = pstmt.executeQuery();
			
			System.out.println("result 조회 전 : " + result);
			
			if(rset.next()) {
				result = new Member();
				
				
				result.setUserId(rset.getString("userId"));
				result.setUserPassword(rset.getString("userPassWord"));
				result.setUserName(rset.getString("userName"));
				result.setUserPhone(rset.getString("userPhone"));
				result.setAddress(rset.getString("address"));
				result.setUserAge(rset.getInt("userAge"));
				result.setGender(rset.getString("gender"));
				
			}
			System.out.println("result 조회 후 : " + result);
			
		} catch (SQLException e) {
			// 정상 작동함
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
			pstmt.setString(1, m.getUserPassword());
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

	public int idDupCheck(Connection con, String id) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql =prop.getProperty("idDupCheck");
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}finally {
			close(rset);
			close(pstmt);
		}
		
		
		return result;
	}
}
