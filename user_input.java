package detals;
import java.util.*;
import java.sql.*;
//import java.util.scanner;

public class user_input {

	public static void main(String[] args) {

	//user input taken
		Scanner sc=new Scanner(System.in);
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn =
	            DriverManager.getConnection("jdbc:mysql://localhost/demo","root","");
		Statement st=conn.createStatement();
		
//		System.out.println("ID");
//		int id=sc.nextInt();
		
		System.out.println("enter username");
		String username=sc.next();
		
		System.out.println("create password");
		String password=sc.next();
		
//		System.out.println("enter salary");
//		int empsal=sc.nextInt();

		st.executeUpdate("insert into users value('"+username+"','"+password+"')");
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

