package jdbc_project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserLogin {
	private boolean result;
	UserLogin(){
		result = false;
	}
	public void login( String userName, String password ) {
			try {
				Connection connection = DBConnectionFactory.getConnection();
				PreparedStatement st = connection.prepareStatement("Select username, password from user where username=? and password=?");
				st.setString(1, userName);
                st.setString(2, password);
                ResultSet rs = st.executeQuery();
                if(rs.next()) {
                	System.out.println("Login Successfully!");
                	this.result = true;
                }
                else {
                	System.out.println("Username or password is wrong!");
                }
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	public boolean isResult() {
		return result;
	}
}
