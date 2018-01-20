package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.DormBean;
import bean.Student_dormBean;
import db.DbHelper;

public class Student_Dorm_Dao {
	public List<DormBean> query() throws SQLException{
		Connection conn = DbHelper.getConnection();
		Statement stmt = (Statement) conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from dorm");
		List<DormBean> gs = new ArrayList<DormBean>();
		DormBean g=null;
		while(rs.next()) {
			g=new DormBean();
			g.setDdor(rs.getInt("Ddor"));
			g.setDunused(rs.getInt("Dunused"));
			
			gs.add(g);
		}
		return gs;
	}
	
	
	public void Check_in(Student_dormBean g) throws SQLException {
		
		Connection connection=(Connection) DbHelper.getConnection();
		String sql="insert into student_dorm(Sno,Dbuil,Ddor,Check_in) values(?,?,?,?);";
		PreparedStatement p=connection.prepareStatement(sql);
		p.setInt(1, g.getSno());
		p.setInt(2,  g.getDbuil());
		p.setInt(3,  g.getDdor());
		p.setString(4, g.getCheck_in());
		p.execute();
		
	}	
		
	public Boolean query_Unused(Integer ddor) throws SQLException {
		Connection connection=(Connection) DbHelper.getConnection();
		String sql="select  Dunused from dorm where Ddor = ?";
	
		Integer b = 0;
		PreparedStatement p=connection.prepareStatement(sql);
		p.setInt(1, ddor);
		ResultSet re = p.executeQuery();
		while(re.next()) {
			
			b = re.getInt("Dunused");
		}
		if (b <= 0) {
			return false;
		}else {
			return true;
		}
		
		
	}
	
	
	public Boolean query_Sno_ByDno(Integer ddor) throws SQLException {
		Connection connection=(Connection) DbHelper.getConnection();
		String sql="select  Sno from student_dorm where Ddor = ?";
	
		Integer b = 0;
		PreparedStatement p=connection.prepareStatement(sql);
		p.setInt(1, ddor);
		ResultSet re = p.executeQuery();
		while(re.next()) {
			
			b = re.getInt("Sno");
		}
		if (b <= 0) {
			return false;
		}else {
			return true;
		}
		
		
	}
	
	
	
	
	public void update_SD(Integer ddor) throws SQLException {
		Connection connection=(Connection) DbHelper.getConnection();
		String sql = "select Dunused from dorm where Ddor = ?";
		PreparedStatement p=connection.prepareStatement(sql);
		p.setInt(1, ddor);
		ResultSet re = p.executeQuery();
		Integer num =0;
		while(re.next()) {
			num = re.getInt("Dunused");
			String sql1="update dorm set Dunused = ? where Ddor = ?";
			PreparedStatement p1=connection.prepareStatement(sql1);
			p1.setInt(1, num-1);
			p1.setInt(2, ddor);
			p1.execute();
		}
	}
	
	public void update_Stu_DOrm(Student_dormBean sdb) throws SQLException {
		Connection connection=(Connection) DbHelper.getConnection();
		String sql = "update student_dorm set Dbuil = ? ,Ddor = ? where Sno = ?";
		PreparedStatement p=connection.prepareStatement(sql);
		p.setInt(1, sdb.getDbuil());
		p.setInt(2,  sdb.getDdor());
		p.setInt(3, sdb.getSno());
		p.execute();
	}
	
	
	public boolean query_Sno(Integer sno) throws SQLException {
		Connection connection=(Connection) DbHelper.getConnection();
		String sql = "select * from student_dorm where Sno = ?";
		PreparedStatement p=connection.prepareStatement(sql);
		p.setInt(1, sno);
		ResultSet re = p.executeQuery();
		if (re.next()) {
			return false;
		}else {
			return true;
		}
	}

// 根据学号查找到宿舍号，将对应宿舍的未使用床数量加一
	public void update_SD_bySno(Integer sno) throws SQLException {
		Connection connection=(Connection) DbHelper.getConnection();
		String sql = "select * from student_dorm where Sno = ?";
		PreparedStatement p=connection.prepareStatement(sql);
		p.setInt(1, sno);
		Integer dno1 = 0;
		ResultSet re = p.executeQuery();
		if(re.next()) {
			dno1 = re.getInt("Ddor");
			String sql1 = "select Dunused from dorm where Ddor = ?";
			PreparedStatement p1=connection.prepareStatement(sql1);
			p1.setInt(1, dno1);
			ResultSet rs = p1.executeQuery();
			Integer num =0;
			while(rs.next()) {
				num = rs.getInt("Dunused");
				String sql2="update dorm set Dunused = ? where Ddor = ?";
				PreparedStatement p2=connection.prepareStatement(sql2);
				p2.setInt(1, num+1);
				p2.setInt(2, dno1);
				p2.execute();
			}
		}
	}
	
	public void delSStu_dorm (Integer sno) throws SQLException {
		Connection connection=(Connection) DbHelper.getConnection();
		String sql = "delete from student_dorm where sno =?";
		PreparedStatement p=connection.prepareStatement(sql);
		p.setInt(1, sno);
		p.execute();
	}
	
	
	
}
