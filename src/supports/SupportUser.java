package supports;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.User;
import connection.ConectDB;

public class SupportUser {

	
	public User getUser(User us) {
		
		User user = null; 
		
		Connection con = null; 
		PreparedStatement ppt = null; 
		ResultSet rs = null; 
		
		try {
			
			con = ConectDB.getConnection();
			String sql = "SELECT * FROM UserTable where Username = ? AND Password = ?";  
			
			ppt = con.prepareStatement(sql); 
			ppt.setString(1, us.getUsername());
			ppt.setString(2, us.getPassword());  
			
			rs = ppt.executeQuery(); 
			
			while (rs.next()) {
				
				user = new User (rs.getString(1),rs.getString(2));
				
			}
			
		} catch (Exception e) {
			System.out.println("Error, user not allowed");
		}
		
		return user;
		
	}
}
