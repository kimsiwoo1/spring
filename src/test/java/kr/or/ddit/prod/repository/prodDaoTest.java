package kr.or.ddit.prod.repository;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import kr.or.ddit.config.test.RootTestConfig;
import kr.or.ddit.prod.model.Prod;
import kr.or.ddit.prod.repository.IProdDao;
import kr.or.ddit.prod.repository.ProdDao;

public class prodDaoTest extends RootTestConfig{
	
	@Resource(name="prodDao")
	private IProdDao prodDao;

	@Test
	public void getProdListTest() {
		String lprod_gu = "P101";
		/***Given***/
		
		/***When***/
		List<Prod> prodList = prodDao.getProdList(lprod_gu);
		
		/***Then***/
		assertEquals(6, prodList.size());
	}

}
