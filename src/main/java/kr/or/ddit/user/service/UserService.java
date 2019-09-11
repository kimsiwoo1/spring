package kr.or.ddit.user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.user.dao.IUserDao;
import kr.or.ddit.user.model.User;

@Service
public class UserService implements IUserService{
	@Resource(name="userDao")
	private IUserDao userDao;
	
	public UserService() {
		
	}
	
	public UserService(IUserDao userDao) {
		this.userDao = userDao;
	}
	/**
	* Method : getUserList
	* 작성자 : PC-07
	* 변경이력 :
	* @return
	* Method 설명 : 사용자 전체 리스트 보기
	*/
	@Override
	public List<User> getUserList() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userDao.getUserList();
	}
	
	@Override
	public User getUser(String userId) {
		return userDao.getUser(userId);
	}

	@Override
	public List<User> getCntUserList() {
		return userDao.getCntUserList();
	}

	@Override
	public Map<String, Object> getUserPagingList(Page page) {
		Map<String, Object> map = new HashMap<String, Object>();

		
		List<User> userList = userDao.getUserPagingList(page);
		int totalCnt = userDao.getUserTotalCnt();
		
		map.put("userList", userList);
		map.put("paginationSize", (int)Math.ceil((double)totalCnt / page.getPagesize()));
		return map;
	}

	@Override
	public int insertUser(User user) {
		//선언적트랜잭션
		//.예외가 발생했을때 정상적으로 rollback이 되는지
		//.예외가 발생하지 않고 정상적으로 코드가 실행되었을때
		// 명시적인 commit이 없는데 commit이 정상적으로 되는지
		return userDao.insertUser(user);
	}
	
	
	@Override
	public int deleteUser(String userId) {
		return userDao.deleteUser(userId);
	}

	@Override
	public int updateUser(User user) {
		return userDao.updateUser(user);
	}

}
