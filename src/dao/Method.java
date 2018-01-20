package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mysql.jdbc.Connection;

import bean.Damage_goodsBean;
import db.DbHelper;

public class Method {

	public String Sanitary_query(Integer Ddor) throws SQLException {
		String g = null;
		Connection connection = (Connection) DbHelper.getConnection();
		String sql = ("select * from sanitary where Ddor=?");
		PreparedStatement p = connection.prepareStatement(sql);
		p.setInt(1, Ddor);
		ResultSet rs = p.executeQuery();
		while (rs.next()) {
			g = rs.getString("Sanitary");
		}
		return g;

	}

	public void Damage_goodsAdd(Integer dno, String damage) {
		Connection connection = (Connection) DbHelper.getConnection();
		String sql = "insert into damage_goods(Ddor,Dgoods,Dtime) values(?,?,?);";
		PreparedStatement p;
		try {
			p = connection.prepareStatement(sql);
			p.setInt(1, dno);
			p.setString(2, damage);
			p.setString(3, new Date().toString());
			p.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Integer getUP(String user, String name) throws SQLException {
		Integer a = null;
		Connection connection = (Connection) DbHelper.getConnection();
		String sql = "select Sno from student where Llogin = ? and Password = ?";
		PreparedStatement p = connection.prepareStatement(sql);
		p.setString(1, user);
		p.setString(2, name);
		ResultSet rs1 = p.executeQuery();
		while (rs1.next()) {
			a = rs1.getInt("Sno");
		}
		return a;
	}
	
	public Integer getUP_Dorm(String user, String name) throws SQLException {
		Integer a = null;
		Connection connection = (Connection) DbHelper.getConnection();
		String sql = "select Mno from  management where Llogin = ? and Password = ?";
		PreparedStatement p = connection.prepareStatement(sql);
		p.setString(1, user);
		p.setString(2, name);
		ResultSet rs1 = p.executeQuery();
		while (rs1.next()) {
			a = rs1.getInt("Mno");
		}
		return a;
	}
	
	

	public void updateUP(Integer a,  String name) throws SQLException {
		Connection connection = (Connection) DbHelper.getConnection();
		String sql = "update student set  Password = ? where Sno = ? ";
		PreparedStatement p = connection.prepareStatement(sql);
	
		p.setString(1, name);
		p.setInt(2, a);
		p.execute();
	}
	
	public void updateUP_Dorm(Integer a,  String pass) throws SQLException {
		Connection connection = (Connection) DbHelper.getConnection();
		String sql = "update management set  Password = ? where Mno = ? ";
		PreparedStatement p = connection.prepareStatement(sql);
		p.setString(1, pass);
		p.setInt(2, a);
		p.execute();
	}
	
	
	

	public Boolean Query_dorm_Dno(Integer dno)  {
		Connection connection = (Connection) DbHelper.getConnection();
		String sql = "select * from dorm where Ddor = ?";
		PreparedStatement p = null;
		try {
			p = connection.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		try {
			p.setInt(1, dno);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("hahahaha");
		}
		ResultSet rs2 = null;
		try {
			rs2 = p.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		try {
			if (rs2.next()) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}

		return false;
	}
	
	
	public List<Damage_goodsBean> query() throws SQLException{
		Connection conn=(Connection) DbHelper.getConnection();
		Statement stmt = (Statement) conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from damage_goods");
		List<Damage_goodsBean> gs=new ArrayList<Damage_goodsBean>();
		Damage_goodsBean g=null;
		while(rs.next()) {
			g=new Damage_goodsBean();
			g.setDno(rs.getInt("Dno"));
			g.setDdor(rs.getInt("Ddor"));
			g.setDgoods(rs.getString("Dgoods"));
			g.setDtime(rs.getString("Dtime"));	
			gs.add(g);
		}
		return gs;
	}

}

