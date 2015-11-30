package springbook.user.dao;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.context.annotation.Bean;

import lombok.Getter;

@Getter
public class CountConnectionMaker implements ConnectionMaker {

	int counter = 0;
	private ConnectionMaker realCountConnectionMaker;
	
	public CountConnectionMaker(ConnectionMaker realCountConnectionMaker) {
		this.realCountConnectionMaker = realCountConnectionMaker;
	}
	
	public Connection makeConnection() throws ClassNotFoundException,
			SQLException {
		this.counter++;
		return realCountConnectionMaker.makeConnection();
	}
}
