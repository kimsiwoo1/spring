package kr.or.ddit.prod.web;


import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.prod.repository.IProdDao;

@RequestMapping("prod/")
@Controller
public class ProdController {
	@Resource(name="prodDao")
	private IProdDao prodDao;
	
	@RequestMapping(path = "prodList", method = RequestMethod.GET)
	public String prodList(Model model, String lprod_gu) {
		model.addAttribute("prodList", prodDao.getProdList(lprod_gu));
		return "prod/prodList";
	}

}
