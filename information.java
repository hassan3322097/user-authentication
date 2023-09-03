package detals;
import java.util.*;
import java.sql.*;

public class information {
//guest table creation
	public static void main(String[] args) {
		        String jdbcUrl = "jdbc:mysql://localhost:3306/demo";
		        String username = "root";
		        String password = "";

		        try (
		        		Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
		            String createTableSQL = "CREATE TABLE IF NOT EXISTS guest ("
		                    + "id INT NOT NULL UNIQUE,"
		                    + "name VARCHAR(255) NOT NULL,"
		                    + "email VARCHAR(255) NOT NULL)";
		            
		            Statement statement = connection.createStatement();
		            statement.executeUpdate(createTableSQL);
		            System.out.println("Table 'guest' created successfully.");
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		    }
		}


	


