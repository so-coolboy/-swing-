package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

import bean.StudentBean;
import db.DbHelper;

public class StudentDao {
	public void addstudent(StudentBean g) throws Exception {
		Connection connection = (Connection) DbHelper.getConnection();
		String sql=""+
		        "insert into student"+
				"(Sno,Sname,Ssex,Sclass,Sdept,Stel,Llogin,Password)"+
		        "values("+
				"?,?,?,?,?,?,?,?)";
		PreparedStatement ptmt = connection.prepareStatement(sql);
		ptmt.setInt(1, g.getSno());
		ptmt.setString(2, g.getSname());
		ptmt.setString(3, g.getSsex());
		ptmt.setString(4, g.getSclass());
		ptmt.setString(5, g.getSdept());
		ptmt.setString(6, g.getStel());
		ptmt.setString(7, String.valueOf(g.getSno()));
		ptmt.setString(8, "123456");
		ptmt.execute();
	}
	
	
	public void delStudent(Integer sno) throws SQLException {
		Connection connection = (Connection) DbHelper.getConnection();
		String sql=""+
		        " delete from student"+
		        " where Sno=? ";
		PreparedStatement ptmt = connection.prepareStatement(sql);
		ptmt.setInt(1, sno);
		ptmt.execute();
	}
	
	public Boolean querySno(Integer sno ) throws SQLException {
		Connection connection = (Connection) DbHelper.getConnection();
		String sql = ""+
		       " select * from student where sno = ?" ;
		PreparedStatement ptmt = connection.prepareStatement(sql);
		ptmt.setInt(1, sno);
		ResultSet rs = ptmt.executeQuery();
		if (rs.next()) {
			return true;
		}else {
			return false;
		}

	}
	
	public Boolean querySname(String name ) throws SQLException {
		Connection connection = (Connection) DbHelper.getConnection();
		String sql = ""+
		       " select * from student where Sname = ?" ;
		PreparedStatement ptmt = connection.prepareStatement(sql);
		ptmt.setString(1, name);
		ResultSet rs = ptmt.executeQuery();
		if (rs.next()) {
			return true;
		}else {
			return false;
		}

	}
	
	public StudentBean get(Integer Sno) throws SQLException {
		StudentBean g=null;
		Connection conn = (Connection) DbHelper.getConnection();
		String sql=""+
		        " select Sno,Sname,Ssex,Sclass,Sdept,Stel from student"+
		        " where Sno=? ";
		PreparedStatement ptmt=(PreparedStatement) conn.prepareStatement(sql);
		ptmt.setInt(1, Sno);
		ResultSet rs=ptmt.executeQuery();
		while(rs.next()) {
			g=new StudentBean();
			g.setSno(rs.getInt("Sno"));
			g.setSname(rs.getString("Sname"));
			g.setSsex(rs.getString("Ssex"));
			g.setSclass(rs.getString("Sclass"));
			g.setSdept(rs.getString("Sdept"));
			g.setStel(rs.getString("Stel"));
		}
		return g;
	}

	
	public void updateStudent(Integer sno, String sname, String ssex, 
			String sclass, String sdept, String stel) throws SQLException {
		Connection conn=(Connection) DbHelper.getConnection();
		String sql=""+
		        " update student"+
				" set Sname=?,Ssex=?,Sclass=?,Sdept=?,Stel=? "+
		        " where Sno=? ";
		PreparedStatement ptmt=(PreparedStatement) conn.prepareStatement(sql);
		
		ptmt.setString(1, sname);
		ptmt.setString(2, ssex);
		ptmt.setString(3, sclass);
		ptmt.setString(4, sdept);
		ptmt.setString(5, stel);
		ptmt.setInt(6, sno);
		ptmt.execute();
	}

}
