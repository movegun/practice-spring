package soo.md.mapper;



import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import lombok.extern.log4j.Log4j;
import soo.md.domain.Address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class AddressMapperTests {
	@Autowired
	private AddressMapper addressMapper;
	
	/*
//	@Test
	public void testList() {
		log.info("#addressMapper :"+ addressMapper);
		List<Address> list = addressMapper.list();		
		log.info("#list :"+ list);		
	}
	*/
	/*
	@Test
	public void testInsert() {
		Address address = new Address(-1L, "±è¹Î¼ö", "ÀÎÃµ °¡ÁÂµ¿", null);
		addressMapper.insert(address);
		log.info("#addressMapper testInsert() ¼º°ø");		
	}*/
	
	@Test
	public void testDelete() {
		long seq = 5;
		addressMapper.delete(seq);
		log.info("»èÁ¦ ¼º°ø");
	}
	
	
	

}
