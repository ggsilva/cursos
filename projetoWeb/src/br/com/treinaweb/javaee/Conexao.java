package br.com.treinaweb.javaee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	public static String status = "";
	
	public static Connection getConnection(){
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String url = "jdbc:mysql://127.0.0.1/loja?user=root&password=javaweb";
			connection = DriverManager.getConnection(url);
			status = "Conexão Aberta!";
		} catch (SQLException e) {
			
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}		
		return connection;
	}
	
}
