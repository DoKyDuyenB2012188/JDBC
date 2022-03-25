package jdbc_project;

import java.util.Random;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRegister {
	private Connection connection;
	private boolean result;
	public UserRegister() {
		result = false;
		try {
			this.connection = DBConnectionFactory.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public int getID() {
		Random rand = new Random();
		int id = rand.nextInt(100);
		try {
			while(true) {
				PreparedStatement st = this.connection.prepareStatement("Select id from user where id= ?");
				st.setString(1, String.valueOf(id));
				ResultSet rs = st.executeQuery();
				if(rs.next()) {
					id = rand.nextInt(100);
				}
				else {
					break;
				}
			}
		}catch(SQLException e) {
			e.getStackTrace();
		}
		return id;
	}
	public boolean isExistUsername(String username) {
		try {
				PreparedStatement st = this.connection.prepareStatement("Select username from user where username= ?");
				st.setString(1,username);
				ResultSet rs = st.executeQuery();
				if(rs.next()) {
					return true;
				}
				else {
					return false;
				}
		}catch(SQLException e) {
			e.getStackTrace();
		}
		return true;
	}
	public void Register( String userName, String password ) {
		if(isExistUsername(userName)) {
			System.out.println("Account is exist");
		}
		else {
			try {
				PreparedStatement st = this.connection.prepareStatement("INSERT INTO user"
	                    + " (id, username, password)"
	                    + " VALUES (?, ?, ?)");
				int id = getID();
				st.setString(1, String.valueOf(id));
	            st.setString(2, userName);
	            st.setString(3, password);
	            st.executeUpdate();
	            System.out.println("Account created Successfully!");
	            result = true;
			} catch (SQLException e) {
				System.out.println("Insert Failed!");
				e.printStackTrace();
			}
		}
   }
	public boolean isResult() {
		return result;
	}
}
