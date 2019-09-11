package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class BbsDAO {
	public void insert(BbsDTO dto) throws Exception {
		
		DBConnectionMgr mgr = DBConnectionMgr.getInstance();
		Connection con = mgr.getConnection();

		String sql = "insert into bbs2 values(?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);

		ps.setString(1, dto.getId());
		ps.setString(2, dto.getTitle());
		ps.setString(3, dto.getContent());
		ps.setString(4, dto.getWriter());
		ps.executeUpdate();

		ps.close();
		con.close();

	}
}
