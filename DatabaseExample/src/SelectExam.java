import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectExam {

	public static void main(String[] args) {

		final String url = "jdbc:mysql://127.0.0.1:3306/exam";
		final String id = "root";
		final String pw = "";

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try (Connection conn = DriverManager.getConnection(url, id, pw);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("select * from t1");) {
			while (rs.next()) {
				System.out.println(rs.getString("name") + "-" + rs.getString("month") + "-" + rs.getString("day"));
			}

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
