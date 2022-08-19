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
import soo.md.domain.Address;
import soo.md.service.AddressService;

@Log4j
@AllArgsConstructor
@Controller
@RequestMapping("/address")
public class AddressController {
		
	private AddressService addressService;
	
	@GetMapping("/list.do")
	public ModelAndView list(){
		
		List<Address> addressesss = addressService.listS();
				
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("address/list");
//		mv.addObject("list", list);
		
		ModelAndView mv = new ModelAndView("address/list","addresses",addressesss);
//		log.info("Alist"+addressesss);
		return mv;
		
	}
	

//	write(){}
	@GetMapping("/write.do")
	public String write(){		
		log.info("/address/write.do 첫번째놈한테 들어왔다");
		return ("address/write");		
	}
	
	@PostMapping("/write.do")
	public String write(Address address){
		addressService.insertS(address);
		return "redirect:list.do";
	}
	
	@GetMapping("/delete.do")
	public String delete(long seq){
		addressService.deleteS(seq);
		return "redirect:list.do";
	}

	
//	@PostMapping("/write.do")
//	public String write(HttpServletRequest request){
//		try {	
//			log.info("/address/write.do 두번째놈한테 들어왔다");
//			String name = request.getParameter("name");
//			String addr = request.getParameter("addr");
//			log.info("POST로 넘어 왔나 확인 "+"name : "+name+" addr :"+addr);
//			
//			Address newAddress = new Address();
//			newAddress.setName(name);
//			newAddress.setAddr(addr);
//			
//			addressService.insertS(newAddress);						
//			
//		} catch (Exception e) {
//			log.info("아마도 sql에서 에러발생11");
//		}		
//		
//		log.info("찍히나 ??????????");
//		
//		return ("redirect:/address/list.do");
//		
//	}	

	
	
//	@GetMapping("/delete.do")
//	public ModelAndView delete(@RequestParam int seq){
//		log.info("삭제할 row의 seq번호 : "+seq);
//		addressService.deleteS(seq);
//		
//		log.info("seq 받아서 해당하는 녀석 삭제완료!");
//		
//		
//				
//		List<Address> addressesss = addressService.listS();
//		
//		ModelAndView mv = new ModelAndView("address/list","addresses",addressesss);
//
//		return mv;
//		
//	}
	
	
}

