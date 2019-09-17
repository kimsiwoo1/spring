package kr.or.ddit.lprod.web;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.lprod.service.ILprodService;

@RequestMapping("lprod/")
@Controller
public class LprodController {
	
	@Resource(name="lprodService")
	private ILprodService lprodService;
	
	@RequestMapping(path = "lprodList", method = RequestMethod.GET)
	public String lprodList(Model model) {
		model.addAttribute("lprodList", lprodService.getAllLprod());
		return "lprod/lprodList";
	}
	
	@RequestMapping(path = "lprodPagingList", method = RequestMethod.GET)
	public String lprodPagingList(Model model, Page page) {
		page.setNo("1");
		model.addAttribute("pageVo", page);
		
		Map<String, Object> resultMap = lprodService.getLprodPagingList(page);
		model.addAllAttributes(resultMap);
		
		return "lprod/lprodPagingList";
	}

}
