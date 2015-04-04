/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

/**
 *
 * @author moh.afifun
 */
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {
	
	private static String user;
	private static String pass;
	static Connection con;
	static String url;
	static String dbname;
	static String dbhost;
	static String imagepath;
	
	String propertiesFileName = "config.properties";
	Properties properti = null;
	
	public ConnectionManager() throws IOException {
		
//		properti = new Properties();
//		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propertiesFileName);
//		properti.load(inputStream);
//		user = properti.getProperty("dbuser");
//		pass = properti.getProperty("dbpassword");
//		dbname = properti.getProperty("dbname");
//		dbhost = properti.getProperty("dbhost");
//		imagepath = properti.getProperty("imgdir");

		user = "root";
		pass = "";
		dbname = "teambook_db";
		dbhost = "jdbc:mysql://127.0.0.1:3306/";
		
	}
	
	public Connection getConnection() {
		try {
			System.out.println("dbhost : " + dbhost);
			System.out.println("dbname : " + dbname);
			System.out.println("user : " + user);
			System.out.println("dbpassword : " + pass);
			System.out.println("imagepath : " + imagepath);
			String url = dbhost + dbname;

			Class.forName("com.mysql.jdbc.Driver");
			try {
				con = DriverManager.getConnection(url, user, pass);
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		}
		return con;
	}
	
	public static Connection getConnectionCoba() {
		try {
			String url = "jdbc:mysql:" + "//127.0.0.1:3306/abs_sizakat_coba";

			Class.forName("com.mysql.jdbc.Driver");
			try {
				con = DriverManager.getConnection(url, user, pass);
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		}
		return con;
	}

	public void setConnection(Connection con){
		ConnectionManager.con = con;
	}
	
	public void disconnect() throws SQLException {
		if (con != null)
			con.close();
	}

	public boolean isConnected() {
		return (con != null);
	}

}