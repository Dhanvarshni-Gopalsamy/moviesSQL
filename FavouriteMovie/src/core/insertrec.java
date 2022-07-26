package core;
import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;  
import java.sql.SQLException; 

public class insertrec {
	 private Connection connect() {  
	        // SQLite connection string  
	        String url = "jdbc:sqlite:C://sqlite/movieslist.db";  
	        Connection conn = null;  
	        try {  
	            conn = DriverManager.getConnection(url);  
	        } catch (SQLException e) {  
	            System.out.println(e.getMessage());  
	        }  
	        return conn;  
	    }  
	   
	  
	    public void insert(int no, String name, String actor, String actress, String director, int year) {  
	        String sql = "INSERT INTO Movies(no, name, actor, actress, director, year) VALUES(?,?,?,?,?,?)";  
	   
	        try{  
	            Connection conn = this.connect();  
	            PreparedStatement pstmt = conn.prepareStatement(sql);  
	            pstmt.setInt(1, no);  
	            pstmt.setString(2, name);
	            pstmt.setString(3, actor);
	            pstmt.setString(4, actress);
	            pstmt.setString(5, director);
	            pstmt.setInt(6, year);  
	            pstmt.executeUpdate();  
	        } catch (SQLException e) {  
	            System.out.println(e.getMessage());  
	        }  
	    }  
	public static void main(String[] args) {
        insertrec app = new insertrec();  
        // insert three new rows  
        app.insert(1,"SooraraiPottru","Surya","AparnaBalamurali","SudhaKongara",2020);
        app.insert(2,"Heyram","Kamal","Vidhu","kamal",1999);
        app.insert(3,"Ayan","Surya","tamanna","K.V.Anand",2009);
        app.insert(4,"Anbesivam","Kamal","Sindu","Sundar.C",2003);
        app.insert(5,"SooraraiPottru","Surya","AparnaBalamurali","SudhaKongara",2020);
        app.insert(6,"Kumki","VikramPrabhu","Lakshmi","PrabhuSolomon",2013);
        
        

	}

}
