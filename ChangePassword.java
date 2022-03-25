package jdbc_project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ChangePassword {
	public void passwordChange(String userName, String password) {
		try {
			Connection connection = DBConnectionFactory.getConnection();
			PreparedStatement st = connection.prepareStatement("Update user set password=? where username=?");
			st.setString(1, password);
			st.setString(2, userName);
            st.executeUpdate();
            System.out.println("Change password Successfully!");
		} catch (SQLException e) {
			System.out.println("Update Failed!");
			e.printStackTrace();
		}
	}
}
