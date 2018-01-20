package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

import bean.ManagementBean;
import bean.StudentBean;
import db.DbHelper;

public class ManagerDao {
	public void addManager(ManagementBean g) throws SQLException {
		Connection connection = (Connection) DbHelper.getConnection();
		String sql=""+
		        "insert into management"+
				"(Mno,Mname,Msex,Mtel,Dbuil,Llogin,Password)"+
		        "values("+
				"?,?,?,?,?,?,?)";
		PreparedStatement ptmt = connection.prepareStatement(sql);
		ptmt.setInt(1, g.getMno());
		ptmt.setString(2, g.getMname());
		ptmt.setString(3, g.getMsex());
		ptmt.setString(4, g.getMtel());
		ptmt.setString(5, g.getMtel());
		ptmt.setString(6, String.valueOf(g.getMno()));
		ptmt.setString(7, "123456");
		ptmt.execute();
	}
	
	public Boolean queryMno(Integer mno ) throws SQLException {
		Connection connection = (Connection) DbHelper.getConnection();
		String sql = ""+
		       " select * from management where Mno = ?" ;
		PreparedStatement ptmt = connection.prepareStatement(sql);
		ptmt.setInt(1, mno);
		ResultSet rs = ptmt.executeQuery();
		if (rs.next()) {
			return true;
		}else {
			return false;
		}
	}
	
	public void delManager(Integer mno) throws SQLException {
		Connection connection = (Connection) DbHelper.getConnection();
		String sql=""+
		        " delete from management"+
		        " where Mno=? ";
		PreparedStatement ptmt = connection.prepareStatement(sql);
		ptmt.setInt(1, mno);
		ptmt.execute();
	}
	
	
	public ManagementBean get(Integer mno) throws SQLException {
		ManagementBean g=null;
		Connection conn = (Connection) DbHelper.getConnection();
		String sql=""+
		        " select Mno,Mname,Msex, Mtel,Dbuil from management"+
		        " where Mno=? ";
		PreparedStatement ptmt=(PreparedStatement) conn.prepareStatement(sql);
		ptmt.setInt(1, mno);
		ResultSet rs=ptmt.executeQuery();
		while(rs.next()) {
			g=new ManagementBean();
			g.setMno(rs.getInt("Mno"));
			g.setMname(rs.getString("Mname"));
			g.setMsex(rs.getString("Msex"));
			g.setMtel(rs.getString("Mtel"));
			g.setDbuil(rs.getInt("Dbuil"));
		
		}
		return g;
	}
	
	

	public void updateManager(Integer mno, String mname, String msex, 
		 String mtel, Integer mduil) throws SQLException {
		Connection conn=(Connection) DbHelper.getConnection();
		String sql=""+
		        " update management"+
				" set Mname=?,Msex=?,Mtel=?,Dbuil=? "+
		        " where Mno=? ";
		PreparedStatement ptmt=(PreparedStatement) conn.prepareStatement(sql);
		
		ptmt.setString(1, mname);
		ptmt.setString(2, msex);
		ptmt.setString(3, mtel);
		ptmt.setInt(4, mduil);
		ptmt.setInt(5, mno);
		ptmt.execute();
	}


}
