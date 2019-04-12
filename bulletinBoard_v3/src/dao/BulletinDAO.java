package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Bulletin;

public class BulletinDAO {
	private final String Driver_NAME = "com.mysql.jdbc.Driver";
	private final String JDBC_URL = "jdbc:mysql://localhost:3306/testmysql";
	private final String DB_USER = "root";
	private final String DB_PASS = "Pass@0831";

	public List<Bulletin> findAll(int pageNum) {
		Connection connection = null;
		List<Bulletin> BulletinList = new ArrayList<Bulletin>();

		try {
			Class.forName(Driver_NAME);
			connection = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
			String sql = "SELECT * FROM BULLETIN ORDER BY ID DESC LIMIT ?, 20";
			PreparedStatement psSql = connection.prepareStatement(sql);
			//結果が1以下の時、型がintだと0になる？？
			psSql.setInt(1, pageNum);
			ResultSet resultSet = psSql.executeQuery();
			while(resultSet.next()) {
				int id = resultSet.getInt("ID");
				String userName = resultSet.getString("NAME");
				String text = resultSet.getString("TEXT");
				String created_at = resultSet.getString("created_at");
				Bulletin bulletin = new Bulletin(id, userName, text, created_at);
				BulletinList.add(bulletin);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} finally {
			if(connection != null) {
				try {
					connection.close();
				} catch(SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		} //end tryCatch
		return BulletinList;
	}

	public boolean create(Bulletin bulletin) {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
			String sql = "INSERT INTO bulletin(NAME, TEXT) VALUES(?, ?)";
			PreparedStatement psSql = connection.prepareStatement(sql);
			psSql.setString(1, bulletin.getUserName());
			psSql.setString(2, bulletin.getText());
			int result = psSql.executeUpdate();
			if(result != 1) {
				return false;
			}
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} //end tryCatch
		return true;
	}

	public int count() {
		Connection connection = null;
		int countRows = 0;
		try {
			Class.forName(Driver_NAME);
			connection = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
			String countSql = "SELECT COUNT(*) as countRow FROM BULLETIN";
			PreparedStatement psCountSql = connection.prepareStatement(countSql);
			ResultSet rsCountSql = psCountSql.executeQuery();
			rsCountSql.next();
			countRows = rsCountSql.getInt("countRow");

		} catch(SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} //end tryCatch
		return countRows;
	}

}




