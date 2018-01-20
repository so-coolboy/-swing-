package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.VisitorBean;
import db.DbHelper;

public class VisitorDao {
	public void addvistor(VisitorBean g) throws Exception {
		Connection conn=DbHelper.getConnection();
		String sql=""+
		        "insert into visitor"+
				"(Vname,Vtel,Sname,Vtime)"+
		        "values("+
				"?,?,?,?)";
		PreparedStatement ptmt=(PreparedStatement) conn.prepareStatement(sql);
		ptmt.setString(1, g.getVname());
		ptmt.setString(2, g.getVtel());
		ptmt.setString(3, g.getSname());
		ptmt.setString(4, g.getVtime());
		ptmt.execute();
	}
	
	public List<VisitorBean> query() throws SQLException{
		Connection conn=DbHelper.getConnection();
		Statement stmt = (Statement) conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from visitor");
		List<VisitorBean> gs=new ArrayList<VisitorBean>();
		VisitorBean g=null;
		while(rs.next()) {
			g=new VisitorBean();
			g.setVno(rs.getInt("Vno"));
			g.setVname(rs.getString("Vname"));
			g.setVtel(rs.getString("Vtel"));
			g.setSname(rs.getString("Sname"));
			g.setVtime(rs.getString("Vtime"));
			gs.add(g);
		}
		return gs;
	}

	

}
