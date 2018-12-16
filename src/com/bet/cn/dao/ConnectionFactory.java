package com.bet.cn.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.beans.PropertyVetoException;
import com.mchange.v2.c3p0.ComboPooledDataSource;



public class ConnectionFactory {
	//Fields
	private static ComboPooledDataSource dataSource;

	//Methods
	static {
		dataSource = new ComboPooledDataSource();
		try {
			dataSource.setDriverClass("com.mysql.jdbc.Driver");
			//Append url : ?user=root&password=root&useUnicode=true&characterEncoding=UTF8
			dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/my_e_sports?useUnicode=true&characterEncoding=UTF8");
			dataSource.setUser("root");
			dataSource.setPassword("root");
			dataSource.setInitialPoolSize(5);
			dataSource.setMinPoolSize(3);
			dataSource.setMaxPoolSize(10);
			dataSource.setMaxIdleTime(1000);
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws PropertyVetoException, SQLException {
		return dataSource.getConnection();
	}
}