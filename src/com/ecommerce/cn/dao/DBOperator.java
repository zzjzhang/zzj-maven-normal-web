package com.ecommerce.cn.dao;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import com.ecommerce.cn.bean.User;
import java.sql.PreparedStatement;
import com.ecommerce.cn.bean.Product;
import java.beans.PropertyVetoException;



public class DBOperator {
	//Fields
	private static String queryUser = "select * from dimUser where name = ? and password = ?";
	private static String queryProduct = "select * from dimproduct where name = ?";

	//Methods
	public static boolean selectUser(User user) throws PropertyVetoException, SQLException {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(queryUser);
		preparedStatement.setString(1, user.getName());
		preparedStatement.setString(2, user.getPassword());
		ResultSet resultSet = preparedStatement.executeQuery();

		//Get resultset rows
		resultSet.last();
		int result = resultSet.getRow();

		//Close resultset, statement, and connection
		resultSet.close();
		preparedStatement.close();
		connection.close();

		//Judge resultSet rows
		if(result == 1) {
			return true;

		} else {
			return false;

		}

	}



	public static Product selectProduct(Product product) throws SQLException, PropertyVetoException {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(queryProduct);
		preparedStatement.setString(1, product.getName());
		ResultSet resultSet = preparedStatement.executeQuery();

		//Get resultset columns values
		while(resultSet.next()) {
			product.setCategory(resultSet.getString("category"));
			product.setDescription(resultSet.getString("description"));
			product.setName(resultSet.getString("name"));
			product.setPrice(resultSet.getInt("price"));
			product.setUnit(resultSet.getString("unit"));
			product.setVolume(resultSet.getInt("volume"));
		}

		//Close resultSet
		resultSet.close();
		preparedStatement.close();
		connection.close();

		//Return result set
		return product;

	}

}