package kr.or.ddit.user.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.user.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:kr/or/ddit/config/spring/context-root.xml",
		"classpath:kr/or/ddit/config/spring/context-datasource.xml",
		"classpath:kr/or/ddit/config/spring/context-transaction.xml"})
public class UserServiceTest {
	private String userId = "brownTest";
	
	@Resource(name="userService")
	private IUserService userService;
	
	@Before
	public void setup() {
		userService.deleteUser(userId);
	}
	
	@Test
	public void getUserListTest() {
		/***Given***/
		

		/***When***/
		List<User> userList = userService.getUserList();
		/***Then***/
		assertTrue(userList.size() >= 5);
	}
	
	/**
	 * 
	 * Method : getUserTest 작성자 : PC-07 변경이력 : Method 설명 : 사용자 정보 조회 테스트
	 */
	@Test
	public void getUserTest() {
		/*** Given ***/
		String userId = "brown";

		/*** When ***/
		User userVo = userService.getUser(userId);

		/*** Then ***/
		assertEquals("브라운브라운1", userVo.getUserNm());
		//assertEquals("brown1234", userVo.getPass());
	}

	@Test
	public void getCntUserListTest() {
		/*** Given ***/

		/*** When ***/
		List<User> userList = userService.getCntUserList();

		/*** Then ***/
		assertEquals(5, userList.size());
		System.out.println(userList);
	}

	@Test
	public void getUserPagingListTest() {
		/*** Given ***/
		Page page = new Page();
		page.setPage(3);
		page.setPagesize(10);

		/*** When ***/
		Map<String, Object> resultMap = userService.getUserPagingList(page);
		List<User> userList = (List<User>)resultMap.get("userList");
		int paginationSize = (Integer)resultMap.get("paginationSize");

		/*** Then ***/
		assertEquals(0, userList.size());
		//assertEquals("xuserid22", userList.get(0).getUserId());
		assertEquals(1, paginationSize);
		
	}
	
	@Test
	public void ceilingTest() {
		/*** Given ***/
		int totalCnt = 1;
		int pagesize = 10;

		/*** When ***/
		double paginationSize = Math.ceil((double)totalCnt / pagesize);

		/*** Then ***/
		assertEquals(1, (int)paginationSize);

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
		int insertCnt = userService.insertUser(user);
		
		/***Then***/
		assertEquals(1, insertCnt);
	}
	
	@Test
	public void updateUserTest() throws ParseException {
		/***Given***/
		User user = new User();
		
	
		user.setUserId(userId);
		user.setUserNm("xuserid1테스트");
		user.setPass("xuserid11234");
		user.setReg_dt(new SimpleDateFormat("yyyy-MM-dd").parse("2019-08-08"));
		user.setAlias("엑스유저테스트");
		user.setAddr1("대전광역시 중구 중앙로 76");
		user.setAddr2("영민빌딩 2층 DDIT");
		user.setZipcode("34940");

		
		
		/***When***/
		userService.insertUser(user);
		int updateCnt = userService.updateUser(user);
		
		
		/***Then***/
		assertEquals(1, updateCnt);
	}

}
