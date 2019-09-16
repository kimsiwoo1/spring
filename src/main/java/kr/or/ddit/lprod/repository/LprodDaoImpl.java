package kr.or.ddit.lprod.repository;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.lprod.model.Lprod;

@Repository
public class LprodDaoImpl implements ILprodDao {
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;

	@Override
	public List<Lprod> getAllLprod() {
		
		return sqlSession.selectList("lprod.getAllLprod");
	}

	@Override
	public List<Lprod> getLprodPagingList(Page page) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("lprod.getLprodPagingList", page);
	}

	@Override
	public int getUserTotalCnt() {
		return sqlSession.selectOne("lprod.getUserTotalCnt");
	}

}
