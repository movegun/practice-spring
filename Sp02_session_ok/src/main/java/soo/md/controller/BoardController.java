package soo.md.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
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
	
	@GetMapping("/list.do")
	public ModelAndView list(PagingVO vo, String cp, String ps, String orderBy, HttpSession session, HttpServletRequest request) {
		
		String cpFromJsp = request.getParameter("cp");
		String psFromJsp = request.getParameter("ps");
		String orderByFromJsp = request.getParameter("orderBy");
		
		log.info("cpFromJsp : "+cpFromJsp);
		log.info("psFromJsp : "+psFromJsp);
		log.info("orderByFromJsp : "+orderByFromJsp);
		
		///////////////////////////// 다른페이지 갔다 왔을 때 모두 다 null로 들어옴
		
		if ( cpFromJsp == null ) {
			Object cpObject = session.getAttribute("cp");
			if(cpObject != null) {
				cp = (String)cpObject;
			}			
		}else {
			cp = cpFromJsp;
		}
		session.setAttribute("cp", cp);
		//////////////////////////////////////////
		
		if (psFromJsp == null) {
			Object psObject =session.getAttribute("ps");
			if(psObject != null) {
				ps = (String)psObject;				
			}
		}else {
			ps = psFromJsp;			
		}
		session.setAttribute("ps", ps);
		
		if(orderByFromJsp == null) {
			Object orderByObject = session.getAttribute("orderBy");
			if(orderByObject != null) {
				orderBy = (String)orderByObject;				
			}			
		}else {
			orderBy = orderByFromJsp;
		}
		
		session.setAttribute("orderBy", orderBy);
		

		int total = boardService.countBoardS();
		// 둘다 비어있다 = 처음 들어갔을 당시 디폴트 현재페이지 페이지당 갯수를 각각 1 5 로 하겠다
		if (cp == null && ps == null) {
			cp = "1";
			ps = "5";
		} else if (cp == null) {
			cp = "1";
		} else if (ps == null) {
			ps = "5";
		}
		
		if (orderBy == null) {
			orderBy = "desc";
		}		
		
		log.info("확인용 orderBy : " + orderBy);
		log.info("확인용1 cp : " + cp);
		log.info("확인용2 ps : " + ps);

		vo = new PagingVO(total, Integer.parseInt(cp), Integer.parseInt(ps));

		// default = cp:1 , ps:5 , order:desc
		List<Board> pagingList = null;
		if (orderBy.equals("desc")) {
			pagingList = boardService.selectBoardS(vo);
		} else {
			pagingList = boardService.selectBoardAscS(vo);
		}
		
		int lastPage = vo.getLastPage();
		log.info("lastPage"+lastPage);
		session.setAttribute("lastPage", lastPage);

		ModelAndView mv = new ModelAndView("board/list", "boardNums", vo);
		mv.addObject("pagingList", pagingList);
		mv.addObject("orderBy", orderBy);
		return mv;
	}

//	@GetMapping("/list.do")
//	public ModelAndView list(PagingVO vo, String cp, String ps, String orderBy, HttpSession session, HttpServletRequest request) {
//		
//		String cpFromJsp = request.getParameter("cp");
//		String psFromJsp = request.getParameter("ps");
//		String orderByFromJsp = request.getParameter("psOrder");
//		
//		log.info("cpFromJsp : "+cpFromJsp);
//		log.info("psFromJsp : "+psFromJsp);
//		log.info("orderByFromJsp : "+orderByFromJsp);
//		
//		
//		
//		
//		if (orderBy == null) {
//			orderBy = "desc";
//		}
//
//		log.info("확인용 orderBy : " + orderBy);
//		log.info("확인용1 cp : " + cp);
//		log.info("확인용2 ps : " + ps);
//
//		int total = boardService.countBoardS();
//		// 둘다 비어있다 = 처음 들어갔을 당시 디폴트 현재페이지 페이지당 갯수를 각각 1 5 로 하겠다
//		if (cp == null && ps == null) {
//			cp = "1";
//			ps = "5";
//		} else if (cp == null) {
//			cp = "1";
//		} else if (ps == null) {
//			ps = "5";
//		}
//		log.info("확인용3 cp : " + cp);
//		log.info("확인용4 ps : " + ps);	
//		vo = new PagingVO(total, Integer.parseInt(cp), Integer.parseInt(ps));
//		log.info("확인용5 vo : " + vo);
//
//		// default = cp:1 , ps:5 , order:desc
//		List<Board> pagingList = null;
//		if (orderBy.equals("desc")) {
//			pagingList = boardService.selectBoardS(vo);
//		} else {
//			pagingList = boardService.selectBoardAscS(vo);
//		}
//
//		ModelAndView mv = new ModelAndView("board/list", "boardNums", vo);
//		mv.addObject("pagingList", pagingList);
//		mv.addObject("orderBy", orderBy);
//		return mv;
//	}
//
	@GetMapping("/write.do")
	public String write() {
		return ("board/write");
	}

	@PostMapping("/write.do")
	public String write(Board board , HttpSession session) {
		log.info("orderByorderByorderBy : "+ session.getAttribute("orderBy"));
		boardService.insertS(board);
		Object orderByObject = session.getAttribute("orderBy");
		String orderBy = (String)orderByObject;
		
		log.info("StringorderBy :"+orderBy);
		
		Object lastPageObject = session.getAttribute("lastPage");
		String lastPage = lastPageObject.toString();		
		log.info("StringlastPageStringlastPage : "+lastPage);
		
		
		if (orderBy=="desc") {
			return ("redirect:list.do/?cp=1");			
		}else {
			return ("redirect:list.do/?cp="+lastPage);
		}		
	}

	@GetMapping("/content.do")
	public ModelAndView content(long seq) {
		Board foundBoard = boardService.findS(seq);
		log.info("find() : " + foundBoard);
		ModelAndView mv = new ModelAndView("board/content", "foundBoard", foundBoard);
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
		ModelAndView mv = new ModelAndView("board/update", "foundBoard", foundBoard);
		return mv;
	}

	@PostMapping("update.do")
	public String update(Board board) {
		log.info("찍히면 들어왔어찍히면 들어왔어찍히면 들어왔어찍히면 들어왔어");
		boardService.updateS(board);
		return "redirect:list.do";
	}

}
