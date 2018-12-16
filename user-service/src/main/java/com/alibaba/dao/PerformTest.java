package com.alibaba.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class PerformTest {

	public static final String DRIVER = "com.mysql.jdbc.Driver";

	public static final String URL = "jdbc:mysql://localhost:3306/db1?useSSL=false";

	public static final String USERNAME = "root";

	public static final String PASSWORD = "123456";

	public static final String INSERT_SQL = "insert into t_user(id,name) values(?,?)";
	public static final String DELETE_SQL = "delete from t_user";
	public static final String UPDATE_SQL = "update t_user set name=? where id=?";
	public static final String SELECT_SQL = "select id,name from t_user where id=?";

	public static void main(String[] args) throws Exception {
		Class.forName(DRIVER);
		Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		PreparedStatement ppst = conn.prepareStatement(DELETE_SQL);
//		ppst.setInt(1, 3);
//		ppst.setString(2, "nihao");
		long begin = System.nanoTime();
//		for (int i = 0; i < 10000; i++) {
		ppst.execute();
//		}
		System.out.println("cost time:" + (System.nanoTime() - begin));
	}
}
