package kr.or.ddit.lprod.repository;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.config.test.RootTestConfig;
import kr.or.ddit.lprod.model.Lprod;


public class LprodDaoTest extends RootTestConfig{
	private static final Logger logger = LoggerFactory.getLogger(LprodDaoTest.class);
	
	@Resource(name="lprodDaoImpl")
	private ILprodDao lprodDao;
	
	@Before
	public void setup() {
		logger.debug("before");
	}
	
	//테스트에 공통적으로 사용한 자원을 해제
	@After
	public void tearDown() {
		logger.debug("after");
	}
	
	@Test
	public void getAllLprodTest() {
		/***Given***/
		
		/***When***/
		List<Lprod> lprodList = lprodDao.getAllLprod();
		
		/***Then***/
		assertEquals(10, lprodList.size());
	}
	
	@Test
	public void getLprodPagingListTest() {
		/***Given***/
		Page page = new Page();
		page.setPage(1);
		page.setPagesize(5);
		
		/***When***/
		List<Lprod> lprodList = lprodDao.getLprodPagingList(page);
		
		/***Then***/
		assertEquals(5, lprodList.size());
		//assertEquals("xuserid22", lprodList.get(0).getUserId());
		
	}

}
