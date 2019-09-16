package kr.or.ddit.user.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.config.test.RootTestConfig;
import kr.or.ddit.user.dao.IUserDao;
import kr.or.ddit.user.model.User;

public class UserDaoTest extends RootTestConfig{
	private static final Logger logger = LoggerFactory.getLogger(UserDaoTest.class);
	//userDao를 테스트 하기 위해 필요한거
	//db 연결, 트랜잭션, dao
	private String userId = "brownTest";
	
	@Resource(name="userDao")
	private IUserDao userDao;
	
	//테스트에 공통적으로 사용한 자원을 해제
	@After
	public void tearDown() {
		logger.debug("after");
	}

	@Test
	public void getuserListTest() {
		/***Given***/
		

		/***When***/
		List<User> userList = userDao.getUserList();
		logger.debug("userList : {}", userList.size());
		
		/***Then***/
		assertTrue(userList.size() > 4);
	}
	
	/**
	 * 
	* Method : getUserTest
	* 작성자 : PC-07
	* 변경이력 :
	* Method 설명 : 사용자 정보 조회 테스트
	 */
	@Test
	public void getUserTest() {
		/***Given***/
		String userId = "brown";
		
		/***When***/
		User userVo = userDao.getUser(userId);
		
		/***Then***/
		assertEquals("브라운브라운1", userVo.getUserNm());
		//assertEquals("brown1234", userVo.getPass());
	}
	
	@Test
	public void getCntUserListTest() {
		/***Given***/
		
		/***When***/
		List<User> userList = userDao.getCntUserList();
		
		/***Then***/
		assertEquals(5, userList.size());
		System.out.println(userList);
	}
	
	@Test
	public void getUserPagingListTest() {
		/***Given***/
		Page page = new Page();
		page.setPage(3);
		page.setPagesize(10);
		
		/***When***/
		List<User> userList = userDao.getUserPagingList(page);
		
		/***Then***/
		assertEquals(0, userList.size());
		//assertEquals("xuserid22", userList.get(0).getUserId());
		
	}
	
	/**
	* Method : getUserTotalCntTest
	* 작성자 : PC-07
	* 변경이력 :
	* Method 설명 :전체사용자 건수 조회 테스트
	*/
	@Test
	public void getUserTotalCntTest() {
		/***Given***/

		
		/***When***/
		int totalCnt = userDao.getUserTotalCnt();
		
		/***Then***/
		assertEquals(5, totalCnt);
		
	}
	
	@Test
	public void insertUserTest() throws ParseException{
		/***Given***/
		User user = new User();
		
	
		user.setUserId(userId);
		user.setUserNm("브라운테스트");
		user.setPass("brownTest1234");
		user.setReg_dt(new SimpleDateFormat("yyyy-MM-dd").parse("2019-08-08"));
		user.setAlias("곰테스트");
		user.setAddr1("대전광역시 중구 중앙로 76");
		user.setAddr2("영민빌딩 2층 DDIT");
		user.setZipcode("34940");
		
		
		/***When***/
		int insertCnt = userDao.insertUser(user);
		
		/***Then***/
		assertEquals(1, insertCnt);
	}
	
	@Test
	public void updateUserTest() throws ParseException {
		/***Given***/
		User user = new User();
		
	
		user.setUserId(userId);
		user.setUserNm("brownTest1테스트");
		user.setPass("brownTest11234");
		user.setReg_dt(new SimpleDateFormat("yyyy-MM-dd").parse("2019-08-08"));
		user.setAlias("브라운유저테스트");
		user.setAddr1("대전광역시 중구 중앙로 76");
		user.setAddr2("영민빌딩 2층 DDIT");
		user.setZipcode("34940");
		
		/***When***/
		userDao.insertUser(user);
		int updateCnt = userDao.updateUser(user);
		
		/***Then***/
		assertEquals(1, updateCnt);
	}

}
