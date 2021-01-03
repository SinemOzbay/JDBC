package JDBC_Queries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class JDBC_Test {

	public static void main(String[] args) throws SQLException {
		
		
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		// Format for url jdbc:mysql://hostname:portnumber/databaseName
		String url = "jdbc:mysql://127.0.0.1:3306/ebookshop" + "?serverTimezone=UTC";
		
		String user= "root";
		String password = "root";
		
		try {
			
			connection = DriverManager.getConnection(url, user, password);
			System.out.println("Connected to the Database");
			
			statement = connection.createStatement();
			
			// Inserting a row
			String sqlInsert ="Insert into books values (6,'Java For Dummies' , 'jack Jones' , 29.99, 25);";
			// int countInserted = statement.executeUpdate(sqlInsert);
			// System.out.println(countInserted + " rows were inserted");
			
			
			// Inserting multiple records
			sqlInsert = "insert into books values (7, 'Anna Karenina', 'Leo Tolstoy', 39.99, 50),+"
					+ "(8, 'crime and Punishment', 'Dostoevsky', 24.99, 60) ";
		//	int countInserted2 = statement.executeUpdate(sqlInsert);
		//	System.out.println(countInserted2+ "rows were inserted");
			
			// Delete books where id is equal to 2 and 3
//			String delete = "delete from books where id >= 2 and id < 4";
//			int countDeleted = statement.executeUpdate(delete);
//			
//			System.out.println(countDeleted + "rows were deleted");
			
			// Increase the price of id 1 by 30 %
			String update = "update books set price = price * 1.3 where id =1;";
			statement.executeUpdate(update);
			
			
			String select = "select * from books;";
			System.out.println("The SQL statement is: "+ select);
			System.out.println();
			
			
			resultSet =statement.executeQuery(select);
			
			while (resultSet.next()){
				System.out.println(resultSet.getInt(1)+" " +resultSet.getString("title")+ " - " + resultSet.getString("author") +" "+
						resultSet.getDouble("price"));
			}
			
		} catch (Exception e) {
			
			System.out.println("Error connecting to the Database");
			e.printStackTrace();
		}
		
		finally {
			if (connection != null) {
				connection.close();
			}
			if (connection !=null) {
				statement.close();
			}
			if (resultSet !=null) {
				resultSet.close();
			}
		}
		
		
	}

}
