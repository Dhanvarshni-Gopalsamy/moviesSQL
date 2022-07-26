package core;
import java.sql.DriverManager;  
import java.sql.Connection;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.sql.Statement;  

public class selectrec {
  
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
   
  
    public void selectAll(){  
        String sql = "SELECT * FROM Movies";  
          
        try {  
            Connection conn = this.connect();  
            Statement stmt  = conn.createStatement();  
            ResultSet rs    = stmt.executeQuery(sql);  
              
            // loop through the result set  
            while (rs.next()) {  
                System.out.println(rs.getInt("no") +  "\t" +   
                                   rs.getString("name") + "\t" +
                                   rs.getString("actor") + "\t" + 
                                   rs.getString("actress") + "\t" + 
                                   rs.getString("director") + "\t" + 
                                   rs.getInt("year"));  
            }  
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
    }  
    
   
    public void selectgroupby(){  
        String sql = "SELECT actor, name FROM Movies GROUP BY actor";  
          
        try {  
            Connection conn = this.connect();  
            Statement stmt  = conn.createStatement();  
            ResultSet rs    = stmt.executeQuery(sql);  
              
            // loop through the result set  
            while (rs.next()) {  
                System.out.println(rs.getInt("no") +  "\t" +   
                                   rs.getString("actor") + "\t" +
                                   rs.getString("name")
                                   );  
            }  
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
    }  
      
	public static void main(String[] args) {
		 selectrec app = new selectrec();  
	     app.selectAll();
	     app.selectgroupby();

	}

}
