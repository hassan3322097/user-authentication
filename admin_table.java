package detals;
//import java.util.*;
import java.sql.*;
import java.util.Scanner;



public class admin_table {
	
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("choose your option : ");
		System.out.println("1: admin creates user  ");
		System.out.println("2: admin removes user  ");
		System.out.println("3: admin edits users  ");
		  
		int choice=sc.nextInt();

	        switch (choice) {
	            case 1:
	                admin_creation(); 
	                break;
	                
	            case 2:
	            	admin_removes();
	                break;
	            case 3:
	            	admin_edits();
	                break;
	            default:
	                System.out.println("Invalid choice.");
	        }
	        sc.close();
	}
	        static void admin_creation() {
//creating guest and guest table will have changes;
	        	Scanner sc=new Scanner(System.in);
	    		try {
	    		Class.forName("com.mysql.cj.jdbc.Driver");
	    		Connection conn =DriverManager.getConnection("jdbc:mysql://localhost/demo","root","");
	    		Statement st=conn.createStatement();
	    		
	    		System.out.println("admin creates account : ");
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
	        static void admin_removes() {
	        //removing user , user table will have changes;
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
	        
	        static void admin_edits() {
	        	//updating guest , guest table will have changes
	            try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/demo","root","")){
		            Scanner scanner = new Scanner(System.in);
		            
		            System.out.print("Enter guest ID to update: ");
		            int id = scanner.nextInt();
		            
		            System.out.print("Enter new name: ");
		            String name = scanner.next();
		            
		            String updateQuery = "UPDATE guest SET name = ? WHERE id = ?";
		            
		            try (PreparedStatement pst = connection.prepareStatement(updateQuery)) {
		                pst.setString(1, name);
		                pst.setInt(2, id);
		                
		                int rowsAffected = pst.executeUpdate();
		                System.out.println(rowsAffected + " rows updated.");
		            }
		        } 
		        catch (SQLException e) {
		            e.printStackTrace();
		        }
	        }
	        
	        
	        
	        }


