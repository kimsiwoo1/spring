package kr.or.ddit.user.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.config.test.WebTestConfig;
import kr.or.ddit.user.model.User;
import kr.or.ddit.user.service.IUserService;

public class UserControllerTest extends WebTestConfig{
	
	@Resource(name="userService")
	private IUserService userService;


	/**
	* Method : userListTest
	* 작성자 : PC-07
	* 변경이력 :
	* Method 설명 : 사용자 전체 리스트 조회 테스트
	 * @throws Exception 
	*/
	@Test
	public void userListTest() throws Exception {
		/***Given***/
		

		/***When***/
		mockMvc.perform(get("/user/userList"))
				.andExpect(model().attributeExists("userList"))
				.andExpect(view().name("user/userList"));
		/***Then***/
	}
	
	@Test
	public void userListOnlyHelfTest() throws Exception {
		mockMvc.perform(get("/user/userListOnlyHalf"))
			.andExpect(model().attributeExists("userList"))
			.andExpect(view().name("user/userListOnlyHalf"));
	}
	
	@Test
	public void userPagingListTest() throws Exception {
		mockMvc.perform(get("/user/userPagingList"))
		.andExpect(model().attributeExists("userList"))
		.andExpect(view().name("user/userPagingList"));
	}

}
