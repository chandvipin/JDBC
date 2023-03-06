package JDBCExample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbctTrans {

	  public static void main(String[] args) {
		
		  Connection con = null;
		  try {
			Class.forName("com.mysql.cj.jdbc.Driver");
	
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myjdbc", "root", "1234");
			
			System.out.println("Connection sucess");
			
			con.setAutoCommit(false);
			
			PreparedStatement pre = con.prepareStatement("insert into registration(id,first,last,age) values(?,?,?,?)");
			
			pre.setInt(1, 13);
			pre.setString(2, "vicky");
			pre.setString(3, "negi");
			pre.setInt(4, 45);
			
			pre.executeUpdate();
			pre.close();
			
            PreparedStatement pre1 = con.prepareStatement("insert into registration(id,first,last,age) values(?,?,?,?)");
			
			pre1.setInt(1, 12);
			pre1.setString(2, "utkash");
			pre1.setString(3, "yadav");
			pre1.setInt(4, 35);
			
			pre1.executeUpdate();
			pre1.close();
			
			con.commit();
			con.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}	  
	}
}
