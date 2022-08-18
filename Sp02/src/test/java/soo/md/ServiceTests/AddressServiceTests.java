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
	@Autowired //dataSource�� �����̸��� ��ü�� ������Ʈ ���� �����ϸ� �˾Ƽ� ��ü�����ع���
	private AddressService addressService; // 
	
//	@Test
//	public void testListS() {
//		log.info("#addressService :"+ addressService);
//		List<Address> list = addressService.listS();		
//		log.info("#addressService list :"+ list);		
//	}

	
//	@Test
//	public void testInsertS() {
//		Address address = new Address(-1L, "�̸�", "�����ּ�", null);
//		addressService.insertS(address);
//		log.info("#addressService testInsert() ����");		
//	}
	
	
	@Test
	public void testDeleteS() {
		long seq = 11;
		addressService.deleteS(seq);
		log.info("���� ����");
	}
	
		
		
}
	
	



