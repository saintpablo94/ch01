package springbook.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import springbook.user.domain.User;

public class UserDao {

	private ConnectionMaker	connectionMaker;

	public UserDao(ConnectionMaker connectionMaker) {
		this.connectionMaker = connectionMaker;
	}

	public void add(User user) throws ClassNotFoundException, SQLException {
		Connection conn = connectionMaker.makeConnection();

		PreparedStatement stmt = conn
				.prepareStatement("insert into users(id,name,password) values(?,?,?) ");

		stmt.setString(1, user.getId());
		stmt.setString(2, user.getName());
		stmt.setString(3, user.getPasswordString());

		stmt.executeUpdate();

		stmt.close();
		conn.close();
	}	

	public User get(String id) throws ClassNotFoundException, SQLException {
		Connection conn = connectionMaker.makeConnection();

		PreparedStatement stmt = conn
				.prepareStatement("select * from users where id = ? ");

		stmt.setString(1, id);

		ResultSet rs = stmt.executeQuery();

		User user = new User();
		if (rs.next()) {
			user.setId(rs.getString("id"));
			user.setName(rs.getString("name"));
			user.setPasswordString(rs.getString("password"));
		}

		stmt.close();
		rs.close();
		conn.close();

		return user;
	}
}
