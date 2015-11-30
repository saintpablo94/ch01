package springbook.user.dao;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import springbook.user.domain.User;

public class Test {

	public static void main(String[] args) throws ClassNotFoundException,
			SQLException {

		ApplicationContext context = new AnnotationConfigApplicationContext(CountDaoFactory.class);

		UserDao userDao = context.getBean("userDao",UserDao.class);
		CountConnectionMaker countConnectionMaker = context.getBean(CountConnectionMaker.class);
	
		User user = new User().setId("test1").setName("테스트").setPasswordString("married");

		userDao.add(user);
		System.out.println("등록성공");

		User user2 = userDao.get(user.getId());
		System.out.println(user2.getId());
		System.out.println(user2.getName());
		System.out.println(user2.getPasswordString());
		
		System.out.println(countConnectionMaker.getCounter());
	}
	

}
