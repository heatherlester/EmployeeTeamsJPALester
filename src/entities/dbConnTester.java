package entities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class dbConnTester {

	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306/organization";
		String user = "root";
		String password = "DIAD2016";
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("Connection made");
			
			String q = "SELECT * from employees";
			
			Statement st = (Statement) con.createStatement();
			ResultSet rs = st.executeQuery(q);
			
			while(rs.next()){
				String firstName = rs.getString(1);
				String lastName = rs.getString(2);
				String position = rs.getString(3);
				System.out.println(firstName + " " + lastName + " -- " + position);
			}
		}catch (Exception ex){
			System.out.println("SQL Exception");
		}
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("Connection made");
			
			String q = "SELECT * from teams";
			
			Statement st = (Statement) con.createStatement();
			ResultSet rs = st.executeQuery(q);
			
			while(rs.next()){
				String teamName = rs.getString(1);
				String department = rs.getString(2);
				System.out.println(teamName + " -- " + department);
			}
		}catch (Exception ex){
			System.out.println("SQL Exception");
		}

	}

}
