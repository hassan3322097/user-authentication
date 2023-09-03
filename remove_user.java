package detals;
import java.sql.*;
import java.util.Scanner;


public class remove_user {

	public static void main(String[] args) {
	
		        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/demo","root","")) {
		            Scanner scanner = new Scanner(System.in);
		            
		            System.out.print("Enter user name to delete: ");
		            String username = scanner.next();
		            
		            String deleteQuery = "DELETE FROM users WHERE username = ?";
		            
		            try (PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
		                preparedStatement.setString(1, username);
		                
		                int rowsAffected = preparedStatement.executeUpdate();
		                System.out.println(rowsAffected + " rows deleted.");
		            }
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		    }
		}


	


