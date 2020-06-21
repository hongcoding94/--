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
	

}
