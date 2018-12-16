package com.bet.cn.dao;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.LinkedList;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.beans.PropertyVetoException;



public class DBOperator {

	//Fields
	private static String queryCornerHostEngland = "select " + 
			"team, avg(host_self) avg_self, avg(host_opposite) avg_opposite " + 
			"from t_football_corner_host_england " + 
			"group by team " + 
			"order by avg(host_self) asc";

	private static String queryCornerCustEngland = "select " + 
			"team, avg(cust_self) avg_self, avg(cust_opposite) avg_opposite " + 
			"from t_football_corner_cust_england " + 
			"group by team " + 
			"order by avg(cust_self) asc";

	private static String queryCornerHostFrance = "select " + 
			"team, avg(host_self) avg_self, avg(host_opposite) avg_opposite " + 
			"from t_football_corner_host_france " + 
			"group by team " + 
			"order by avg(host_self) asc";

	private static String queryCornerCustFrance = "select " + 
			"team, avg(cust_self) avg_self, avg(cust_opposite) avg_opposite " + 
			"from t_football_corner_cust_france " + 
			"group by team " + 
			"order by avg(cust_self) asc";
	
	
	
	
	
	
	
	//Methods
	public static List<Map<String, Object>> selectCornerHostEngland() throws PropertyVetoException, SQLException {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(queryCornerHostEngland);
		ResultSet resultSet = preparedStatement.executeQuery();
		List<Map<String, Object>> resultList = new LinkedList<>();

		//Get resultset columns values
		while(resultSet.next()) {
			Map<String, Object> result = new HashMap<String, Object>();

			result.put("team", resultSet.getString("team"));
			result.put("avgSelf", resultSet.getString("avg_self"));
			result.put("avgOpposite", resultSet.getString("avg_opposite"));
			
			resultList.add(result);
		}

		//Close resultSet
		resultSet.close();
		preparedStatement.close();
		connection.close();

		//Return result set
		return resultList;

	}



	public static List<Map<String, Object>> selectCornerCustEngland() throws PropertyVetoException, SQLException {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(queryCornerCustEngland);
		ResultSet resultSet = preparedStatement.executeQuery();
		List<Map<String, Object>> resultList = new LinkedList<>();

		//Get resultset columns values
		while(resultSet.next()) {
			Map<String, Object> result = new HashMap<String, Object>();

			result.put("team", resultSet.getString("team"));
			result.put("avgSelf", resultSet.getString("avg_self"));
			result.put("avgOpposite", resultSet.getString("avg_opposite"));
			
			resultList.add(result);
		}

		//Close resultSet
		resultSet.close();
		preparedStatement.close();
		connection.close();

		//Return result set
		return resultList;
	}

	

	public static List<Map<String, Object>> selectCornerHostFrance() throws PropertyVetoException, SQLException {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(queryCornerHostFrance);
		ResultSet resultSet = preparedStatement.executeQuery();
		List<Map<String, Object>> resultList = new LinkedList<>();

		//Get resultset columns values
		while(resultSet.next()) {
			Map<String, Object> result = new HashMap<String, Object>();

			result.put("team", resultSet.getString("team"));
			result.put("avgSelf", resultSet.getString("avg_self"));
			result.put("avgOpposite", resultSet.getString("avg_opposite"));
			
			resultList.add(result);
		}

		//Close resultSet
		resultSet.close();
		preparedStatement.close();
		connection.close();

		//Return result set
		return resultList;

	}



	public static List<Map<String, Object>> selectCornerCustFrance() throws PropertyVetoException, SQLException {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(queryCornerCustFrance);
		ResultSet resultSet = preparedStatement.executeQuery();
		List<Map<String, Object>> resultList = new LinkedList<>();

		//Get resultset columns values
		while(resultSet.next()) {
			Map<String, Object> result = new HashMap<String, Object>();

			result.put("team", resultSet.getString("team"));
			result.put("avgSelf", resultSet.getString("avg_self"));
			result.put("avgOpposite", resultSet.getString("avg_opposite"));
			
			resultList.add(result);
		}

		//Close resultSet
		resultSet.close();
		preparedStatement.close();
		connection.close();

		//Return result set
		return resultList;
	}
	
}