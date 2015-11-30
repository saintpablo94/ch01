package springbook.user.dao;

import java.sql.SQLException;

import springbook.user.domain.User;

public class Test {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		UserDao userDao = new NUserDao();
		
		User user = new User();
		user.setId("test");
		user.setName("테스트");
		user.setPasswordString("married");
		
		userDao.add(user);
		System.out.println("등록성공");
		
		User user2 = userDao.get(user.getId());
		System.out.println(user2.getId());
		System.out.println(user2.getName());
		System.out.println(user2.getPasswordString());
	}

}
