package soo.md.ServiceTests;

import java.sql.*;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;

import lombok.extern.log4j.Log4j;
import soo.md.domain.Address;
import soo.md.service.AddressService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class AddressServiceTests {
	@Autowired //dataSource와 같은이름의 객체가 프로젝트 내에 존재하면 알아서 객체주입해버림
	private AddressService addressService; // 
	
//	@Test
//	public void testListS() {
//		log.info("#addressService :"+ addressService);
//		List<Address> list = addressService.listS();		
//		log.info("#addressService list :"+ list);		
//	}

	
//	@Test
//	public void testInsertS() {
//		Address address = new Address(-1L, "이름", "서비스주소", null);
//		addressService.insertS(address);
//		log.info("#addressService testInsert() 성공");		
//	}
	
	
	@Test
	public void testDeleteS() {
		long seq = 11;
		addressService.deleteS(seq);
		log.info("삭제 성공");
	}
	
		
		
}
	
	



