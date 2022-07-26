package core;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class createtable {
	 public static void createNewTable() {  
	        // SQLite connection string  
	        String url = "jdbc:sqlite:C://sqlite/movieslist.db";  
	          
	        // SQL statement for creating a new table  
	        String sql = "CREATE TABLE IF NOT EXISTS Movies (\n"  
	                + " no INT PRIMARY KEY,\n" 
	        		+ " name varchar(45) NOT NULL,\n"
	                + " actor varchar(45) NOT NULL,\n" 
	                + " actress varchar(45) NOT NULL,\n"
	                + " director varchar(45) NOT NULL,\n"
	                + " year INT NOT NULL"  
	                + ");";  
	          
	        try{  
	            Connection conn = DriverManager.getConnection(url);  
	            Statement stmt = conn.createStatement();  
	            stmt.execute(sql);  
	        } catch (SQLException e) {  
	            System.out.println(e.getMessage());  
	        }  
	    }  
	public static void main(String[] args) {
		  createNewTable();  

	}

}
