package kr.or.ddit.lprod.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.lprod.model.Lprod;

public interface ILprodDao {
	public List<Lprod> getAllLprod();
	
	public List<Lprod> getLprodPagingList(Page page);
	
	int getUserTotalCnt();
}
