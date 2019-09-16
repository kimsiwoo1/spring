package kr.or.ddit.lprod.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.lprod.model.Lprod;

public interface ILprodService {
	public List<Lprod> getAllLprod();
	
	public Map<String, Object> getLprodPagingList(Page page);
}
