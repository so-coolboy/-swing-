package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.Come_back_lateBean;
import db.DbHelper;

public class Late_informationDao {
	public void addCom_back_late(Come_back_lateBean g) throws Exception {
		Connection conn=DbHelper.getConnection();
		String sql=""+
		        "insert into come_back_late"+
				"(Lno,Ltime,Sno,Ddor,Drea)"+
		        "values("+
				"?,?,?,?,?)";
		PreparedStatement ptmt=(PreparedStatement) conn.prepareStatement(sql);
		ptmt.setInt(1, g.getLno());
		ptmt.setString(2, g.getLtime());
		ptmt.setInt(3, g.getSno());
		ptmt.setInt(4, g.getDdor());
		ptmt.setString(5, g.getDrea());
		ptmt.execute();
	}
	
	
	public List<Come_back_lateBean> query() throws SQLException{
		Connection conn=DbHelper.getConnection();
		Statement stmt = (Statement) conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from come_back_late");
		List<Come_back_lateBean> gs=new ArrayList<Come_back_lateBean>();
		Come_back_lateBean g=null;
		while(rs.next()) {
			g=new Come_back_lateBean();
			g.setLno(rs.getInt("Lno"));
			g.setLtime(rs.getString("Ltime"));
			g.setSno(rs.getInt("Sno"));
			g.setDdor(rs.getInt("Ddor"));
			g.setDrea(rs.getString("Drea"));
			gs.add(g);
		}
		return gs;
	}

}
