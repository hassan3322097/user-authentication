package detals;
import java.util.*;
import java.sql.*;
//import java.sql.Connection;

public class guest_input {
//guest input taken
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn =DriverManager.getConnection("jdbc:mysql://localhost/demo","root","");
		Statement st=conn.createStatement();
		
		System.out.println("enter id");
		int id=sc.nextInt();
		
		System.out.println("enter name");
		String name =sc.next();
		
		System.out.println("enter mail");
		String mail =sc.next();
		
		st.executeUpdate("insert into guest value('"+id+"','"+name+"','"+mail+"')");
		System.out.println("values inserted");
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
