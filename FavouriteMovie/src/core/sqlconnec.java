package core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class sqlconnec {

	public static void main(String[] args) {
		String jdbcurl = "jdbc:sqlite:/C:\\sqlite\\forconnec.db";
		try {
			Connection connection=DriverManager.getConnection(jdbcurl);
			String sql="SELECT rowid, * FROM users";
			Statement statement=connection.createStatement();
			ResultSet result=statement.executeQuery(sql);
			while(result.next()) {
				Integer id=result.getInt("rowid");
				String name=result.getString("name");
				String email=result.getString("email");
				System.out.println(id+"|"+name+"|"+email);
			}
		
		}
		catch(SQLException e) {
			System.out.println("Error connecting to SQLite database");
			e.printStackTrace();
		}
        
	}

}
