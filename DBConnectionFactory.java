package jdbc_project;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionFactory {
	public static Connection getConnection() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/user_database";
		String username = "root";
		String password = "Dokyduyen2002@";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			e.getStackTrace();
		}
		return DriverManager.getConnection(url,username, password);
	}
	
}