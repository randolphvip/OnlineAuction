package util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSourceFactory;

public class DBCPUtil {
	private static Properties properties = new Properties();
	private static DataSource dataSource;
	private static Connection connection;
	// 加载DBCP配置文件
	static {
		try {
//	            FileInputStream is = new FileInputStream("dbcp.properties");  
			InputStream is = DBCPUtil.class.getClassLoader().getResourceAsStream("dbcp.properties");
			properties.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			dataSource = BasicDataSourceFactory.createDataSource(properties);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 从连接池中获取一个连接
	public static Connection getConnection() {

		try {
			if (connection == null || connection.isClosed()) {
				connection = dataSource.getConnection();
				connection.setAutoCommit(true);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return connection;
	}

	public static void main(String[] args) throws SQLException {
		long begin = new java.util.Date().getTime();
		Connection connection = getConnection(); // 利用构造方法取得数据库连接
		for (int i = 0; i < 10; i++) {

			String sql = "insert into t_user(username,password) values(?,?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			// id自动增加
			ps.setString(1, "username" + i);
			ps.setString(2, "3333");
			int updateCount = ps.executeUpdate();
			System.out.println(updateCount);
//				 ps =null;
//				connection.close();

		}
		System.out.println(new java.util.Date().getTime() - begin);

	}

}
