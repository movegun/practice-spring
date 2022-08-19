package soo.md.persistence;

import java.sql.*;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;

import lombok.extern.log4j.Log4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class DataSourceTests {
	@Autowired //dataSource와 같은이름의 객체가 프로젝트 내에 존재하면 알아서 객체주입해버림
	private DataSource dataSource; // 
	
	@Test
	public void testConnection() {
//		log.info("#dataSource :"+ dataSource);
		
		try {
			Connection con = dataSource.getConnection();
//			log.info("#con :"+ con);
			
		}catch (SQLException se) {
			log.info("예외발생1");
			

		}
		
		
	}
	
	

}
