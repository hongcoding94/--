package hide.MemberSystem.model.sevice;

import java.sql.Connection;

import hide.MemberSystem.model.dao.MemberDAO;
import hide.MemberSystem.model.vo.Member;
import static hide.common.JDBCTemplate.*;


public class MemberService {
	private Connection con;
	private MemberDAO mDAO = new MemberDAO();
	
	public int insertMember(Member m) throws Exception {
		con = getConnection();
		int result = mDAO.insertMember(con, m);
		
		if(result > 0) commit(con);
		else rollback(con);
		close(con);
		return result;
	}

	public Member selectMember(Member m) throws Exception {
		con = getConnection();
		Member result = mDAO.selectMember(con, m);
		
		close(con);
		if(result == null) throw new Exception("[Service에러] : 로그인 실패!");
		
		return result;
	}

	public int updateMember(Member m) throws Exception {
		con = getConnection();
		
		int result = mDAO.updateMember(con, m);
		
		if(result > 0 ) commit(con);
		
		close(con);
		
		return result;
		
	}

	public int deleteMember(String userId) throws Exception {
		con = getConnection();
		int result = mDAO.deleteMember(con, userId);
		
		if(result > 0) commit(con);
		
		close(con);
		
		return result;
		
	}

	public int idDupCheck(String id) {
		con = getConnection();
		int result = mDAO.idDupCheck(con, id);
		
		close(con);
			
		return result;
	}
	

}
