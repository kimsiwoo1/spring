package kr.or.ddit.user.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.user.model.User;

public interface IUserService {
	/**
	* Method : getUserList
	* 작성자 : PC-07
	* 변경이력 :
	* @return
	* Method 설명 : 사용자 전체 리스트 보기
	*/
	List<User> getUserList();
	
	/**
	* Method : getUser
	* 작성자 : PC-07
	* 변경이력 :
	* @param userId
	* @return
	* Method 설명 : 사용자 상세 조회
	*/
	User getUser(String userId);
	
	/**
	* Method : getCntUserList
	* 작성자 : PC-07
	* 변경이력 :
	* @return
	* Method 설명 : 리스트 50명 조회
	*/
	List<User> getCntUserList();

	/**
	* Method : getUserPagingList
	* 작성자 : PC-07
	* 변경이력 :
	* @param sqlSession
	* @param page
	* @return
	* Method 설명 : 사용자 페이징 리스트 조회
	*/
	Map<String, Object> getUserPagingList(Page page);
	
	
	public int insertUser(User user);


	public int deleteUser(String userId);
	
	public int updateUser(User user);
}
