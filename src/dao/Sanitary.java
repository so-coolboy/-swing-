package dao;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import com.mysql.jdbc.Connection;

import db.DbHelper;

public class Sanitary {
	public void updateSanitary(String str,Integer dno) throws SQLException {
		Connection connection = (Connection) DbHelper.getConnection();
		String sql = "update sanitary set Sanitary = ? ,Stime = ? where Ddor = ?";
		PreparedStatement p = connection.prepareStatement(sql);
		p.setString(1, str);
		p.setInt(3, dno);
		p.setString(2, String.valueOf(new Date()));
		p.execute();
	}

}
