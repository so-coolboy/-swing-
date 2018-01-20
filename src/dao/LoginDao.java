package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import db.DbHelper;

public class LoginDao {
	public boolean getBoolUP(String users, String password) throws SQLException {
		Connection connection=(Connection) DbHelper.getConnection();
		String sql=("select * from student where Llogin=? and Password=?");
		PreparedStatement p=connection.prepareStatement(sql);
		p.setString(1, users);
		p.setString(2, password);
		ResultSet rs= p.executeQuery();
		if (!rs.next()) {
			return false;
		}else {
			return true;
		}
	}
	
	
	public Boolean getBoolMUP(String users, String pass) throws SQLException {
		Connection connection=(Connection) DbHelper.getConnection();
		String sql=("select * from management where Llogin=? and Password=?");
		PreparedStatement p=connection.prepareStatement(sql);
		p.setString(1, users);
		p.setString(2, pass);
		ResultSet rs= p.executeQuery();
		if (!rs.next()) {
			return false;
		}else {
			return true;
		}
	}
}
