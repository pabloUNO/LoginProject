package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConectDB {
  private static Connection cn; 
  
  public static Connection getConnection() {
	  try {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
		cn=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=LoginJava","sa","1234");
	} catch (Exception e) {
		cn = null;
	} 
	  return cn;
  }  
  public static void main(String[] args) {
	Connection testCn = ConectDB.getConnection(); 
	if(testCn!=null) {
		System.out.println("Connected"); 
		System.out.println(testCn);
	}else {
		System.out.println("Disconnected"); 
	}
}
} 

