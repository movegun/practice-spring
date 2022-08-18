package soo.md.ServiceTests;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;
import soo.md.domain.Board;
import soo.md.service.BoardService;


@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BoardServiceTests {
	
	@Autowired
	private BoardService boardService;
	
	@Test
	public void testListS() {
		
		List<Board> list= boardService.listS();
		
		log.info("boardService list :"+list);
		
		
		
	}

}
