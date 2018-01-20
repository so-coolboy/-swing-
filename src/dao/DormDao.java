package dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.DormBean;
import bean.StudentBean;
import db.DbHelper;

public class DormDao {
	
	public void addDorm (DormBean g ) throws SQLException {
		Connection connection = (Connection) DbHelper.getConnection();
		String sql=""+
		        " insert into dorm"+
				" (Ddor, Dbuil, Dbednum, Dunused)"+
		        "values("+
				"?,?,?,?)";
		PreparedStatement ptmt = connection.prepareStatement(sql);
		ptmt.setInt(1, g.getDdor());
		ptmt.setInt(2, g.getDbuil());
		ptmt.setInt(3, g.getDbednum());
		ptmt.setInt(4, g.getDunused());
		ptmt.execute();
	}
	
	public void delDorm(Integer dno) throws SQLException {
		Connection connection = (Connection) DbHelper.getConnection();
		String sql=""+
		        " delete from dorm"+
		        " where Ddor=? ";
		PreparedStatement ptmt = connection.prepareStatement(sql);
		ptmt.setInt(1, dno);
		ptmt.execute();
	}

	
	
	public DormBean get(Integer Dno) throws SQLException {
		DormBean g=null;
		Connection conn = (Connection) DbHelper.getConnection();
		String sql=""+
		        " select Ddor, Dbuil, Dbednum, Dunused from dorm"+
		        " where Ddor=? ";
		PreparedStatement ptmt=(PreparedStatement) conn.prepareStatement(sql);
		ptmt.setInt(1, Dno);
		ResultSet rs=ptmt.executeQuery();
		while(rs.next()) {
			g=new DormBean();
			g.setDdor(rs.getInt("Ddor"));
			g.setDbuil(rs.getInt("Dbuil"));
			g.setDbednum(rs.getInt("Dbednum"));
			g.setDunused(rs.getInt("Dunused"));
		}
		return g;
	}
	
	public void updateDrom(Integer ddor, Integer dbuil, Integer dbednum, Integer dunused) throws SQLException {
		Connection conn = (Connection) DbHelper.getConnection();
		String sql=""+
		        " update dorm"+
				" set Dbuil=?,Dbednum=?,Dunused=? "+
		        " where Ddor=? ";
		PreparedStatement ptmt=(PreparedStatement) conn.prepareStatement(sql);
		ptmt.setInt(1, dbuil);
		ptmt.setInt(2, dbednum);
		ptmt.setInt(3, dunused);
		ptmt.setInt(4, ddor);
		ptmt.execute();
	}
	
	
	
	
	
	
}
