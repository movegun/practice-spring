package soo.md.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import soo.md.domain.Board;
import soo.md.service.BoardService;
import soo.md.util.PagingVO;

@Log4j
@AllArgsConstructor
@Controller
@RequestMapping("/board")
public class BoardController {
	
	private BoardService boardService;
	
//	@GetMapping("/list.do")
//	public ModelAndView list(){
//		log.info("list()�� ���Դ�");
//		List<Board> list = boardService.listS();
//		list.spliterator();
//		
//		ModelAndView mv = new ModelAndView("board/list","boards",list);
//		return mv;
//	}
	
	@GetMapping("/list.do")
	public ModelAndView list(PagingVO vo, String cp , String ps){
		
		
		log.info("Ȯ�ο�1 cp : "+cp);
		log.info("Ȯ�ο�2 ps : "+ps);
		
		int total = boardService.countBoardS();
		//�Ѵ� ����ִ� = ó�� ���� ��� ����Ʈ ���������� �������� ������ ���� 1 5 �� �ϰڴ�
		if (cp == null && ps == null) {
			cp = "1";
			ps = "5";
		} else if (cp == null) {
			cp = "1";
		} else if (ps == null) { 
			ps = "5";
		}
		
		
		log.info("Ȯ�ο�3 cp : "+cp);
		log.info("Ȯ�ο�4 ps : "+ps);
		
		vo = new PagingVO(total, Integer.parseInt(cp), Integer.parseInt(ps));
		
		log.info("Ȯ�ο�5 vo : "+vo);
		
		
		
		
		List<Board> pagingList =  boardService.selectBoardS(vo);
		
		
		log.info("Ȯ�ο� 6 pagingList : "+pagingList);
		
		

		ModelAndView mv = new ModelAndView("board/list","boardNums",vo);
		mv.addObject("pagingList", pagingList);
		return mv;		
		
	}
	
	
		
	

	@GetMapping("/write.do")
	public String write() {
		return("board/write");
	}
	
	@PostMapping("/write.do")
	public String write(Board board) {
		boardService.insertS(board);
		return("redirect:list.do");
	}
	

	@GetMapping("/content.do")
	public ModelAndView content(long seq) {
		Board foundBoard = boardService.findS(seq);
		log.info("find() : "+foundBoard);		
		ModelAndView mv = new ModelAndView("board/content","foundBoard",foundBoard);		
		return mv;	
	
	}
	
	@GetMapping("del.do")
	public String delete(long seq) {
		boardService.deleteS(seq);		
		return "redirect:list.do";		
	}
	
	@GetMapping("update.do")
	public ModelAndView update(long seq) {
		Board foundBoard = boardService.findS(seq);		
		ModelAndView mv = new ModelAndView("board/update","foundBoard",foundBoard);		
		return mv;
	}
	
	@PostMapping("update.do")
	public String update(Board board) {
		log.info("������ ���Ծ������� ���Ծ������� ���Ծ������� ���Ծ�");
		boardService.updateS(board);
		return "redirect:list.do";
	}
	
	

}
