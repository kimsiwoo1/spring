package kr.or.ddit.lprod.service;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.config.test.RootTestConfig;
import kr.or.ddit.lprod.model.Lprod;

public class LprodServiceTest extends RootTestConfig{
	@Resource(name="lprodService")
	private ILprodService userService;
	
	
	@Test
	public void getAllLprodTest() {
		/***Given***/
		
		
		/***When***/
		List<Lprod> lprodList = userService.getAllLprod();
		
		/***Then***/
		assertEquals(10, lprodList.size());
	}
	
	@Test
	public void getLprodPagingListTest() {
		/*** Given ***/
		Page page = new Page();
		page.setPage(1);
		page.setPagesize(5);

		/*** When ***/
		Map<String, Object> resultMap = userService.getLprodPagingList(page);
		List<Lprod> lprodList = (List<Lprod>)resultMap.get("lprodList");
		int paginationSize = (Integer)resultMap.get("paginationSize");

		/*** Then ***/
		assertEquals(5, lprodList.size());
		assertEquals(2, paginationSize);
		
	}


}
