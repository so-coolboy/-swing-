package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;





public class DbHelper {
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/dorm?useUnicode=true&characterEncoding=utf-8";
	private static final String USER = "root";
	private static final String PASSWORD = "";
	
	private static Connection conn = null;
	
	static {
		//1 ������������
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//2 ��ȡ���ݿ������				
		try {
			conn = (Connection) DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		return conn;
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		//3ͨ�����ݿ������ʵ����ɾ�Ĳ�
		Statement stmt = (Statement) conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from student");
		while(rs.next()) {
			System.out.println(rs.getString("Sname") );
		}
	}

}
