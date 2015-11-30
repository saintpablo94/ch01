package springbook.user.dao;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import springbook.user.domain.User;

public class Test {

	public static void main(String[] args) throws ClassNotFoundException,
			SQLException {

		ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);

		UserDao userDao = context.getBean("userDao",UserDao.class);
		UserDao userDaoTwo = context.getBean("userDao",UserDao.class);
		
		UserDao userDaoThree = new DaoFactory().userDao();
		UserDao userDaoFour = new DaoFactory().userDao();
		
		System.out.println(userDao);
		System.out.println(userDaoTwo);
		
		if(userDao == userDaoTwo) System.out.println("userDaoOne == userDaoTwo");
		if(userDao.equals(userDaoTwo)) System.out.println("userDao.equals(userDaoTwo)");
		
		System.out.println(userDaoThree);
		System.out.println(userDaoFour);
		
		if(userDaoThree != userDaoFour) System.out.println("userDaoOne != userDaoTwo");
		if(userDaoThree.equals(userDaoFour)) System.out.println("userDaoOne.equals(userDaoTwo)");
	
		User user = new User().setId("test").setName("테스트").setPasswordString("married");

		userDao.add(user);
		System.out.println("등록성공");

		User user2 = userDao.get(user.getId());
		System.out.println(user2.getId());
		System.out.println(user2.getName());
		System.out.println(user2.getPasswordString());
	}

}
