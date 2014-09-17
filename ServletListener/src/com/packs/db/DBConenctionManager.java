package com.packs.db;

import java.sql.Connection;
import java.sql.SQLException;

public class DBConenctionManager {
	private String dbURL;
	private String user;
	private String password;
	private Connection con;
	
	public DBConenctionManager(String dbURL, String user, String password) {
		this.dbURL = dbURL;
		this.user = user;
		this.password = password;
		
		//veri tabanı baglantısı burada yapılacak
	}
	
	public Connection getConnection(){
		return this.con;
	}
	public void closeConnection() throws SQLException{
		con.close();
	}
}
