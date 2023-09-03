package detals;
import java.util.Scanner;
import java.sql.*;
import java.sql.ResultSet;

public class user_login_chck {

	public static void main(String[] args) {

		        Scanner sc = new Scanner(System.in);
		        try {
		            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/demo", "root", "");
		            Statement st = conn.createStatement();

		            System.out.println("Enter name:");
		            String username = sc.next();

		            String findQuery = "SELECT * FROM users WHERE username=?";
		    		try (PreparedStatement pst = conn.prepareStatement(findQuery)) {
		    		    pst.setString(1, username);

		    		    ResultSet resultSet = pst.executeQuery();

		    		    if (resultSet.next()) {
		    		        boolean isLoggedIn = resultSet.getBoolean("is_logged_in");
		    		        if (isLoggedIn) {
		    		            System.out.println("User is already logged in.");
		    		        } else {
		    		            // Assuming you will update the 'is_logged_in' column in the database to indicate user is logged in
		    		            String updateQuery = "UPDATE users SET is_logged_in = ? WHERE username = ?";
		    		            try (PreparedStatement updatePst = conn.prepareStatement(updateQuery)) {
		    		                updatePst.setBoolean(1, true); // Set 'is_logged_in' to true
		    		                updatePst.setString(2, username); // Update for this user's name

		    		                int rowsAffected = updatePst.executeUpdate();
		    		                if (rowsAffected > 0) {
		    		                    System.out.println("User successfully logged in.");
		    		                } else {
		    		                    System.out.println("Failed to update user login status.");
		    		                }
		    		            }
		    		        }
		    		    } else {
		    		        System.out.println("User not found."); 
		    		    }
		    		}
		            
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		    }
		}


		

