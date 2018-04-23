package JDBC_Programming;
import java.sql.*;

public class Mysql {
	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("DB 연결 드라이버가 없음");
		}
		
		Connection connect = null;
		String url = "jdbc:mysql://127.0.0.1:3306/user";
		String id = "root";
		String pw = "";
		try {
			connect = DriverManager.getConnection(url, id, pw);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("DB 서버 연결실패");
		}
		
		Statement stmt = null;
		try {
			stmt = connect.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("작업 처리 객체 생성 실패");
		}
		
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery("select * from umi");
			System.out.println("- MySQL Connection");
			while(rs.next()) {
				System.out.println("** classNumber: "+ rs.getString("classNumber"));
				System.out.println("  -> name:"+ rs.getString("name"));
				System.out.println("  -> PhoneNumber:" + rs.getString("phoneNumber"));
				System.out.println("  -> password:" + rs.getString("password"));	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			rs.close();
			stmt.close();
			connect.close();
			System.out.println("- MySQL Connection Close");
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
