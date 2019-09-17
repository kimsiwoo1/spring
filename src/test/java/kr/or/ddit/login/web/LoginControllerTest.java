package kr.or.ddit.login.web;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.config.test.WebTestConfig;
import kr.or.ddit.user.model.User;

public class LoginControllerTest extends WebTestConfig{
private static final Logger logger = LoggerFactory.getLogger(LoginControllerTest.class);

	/**
	* Method : test
	* 작성자 : PC-07
	* 변경이력 :
	* Method 설명 : 로그인 화면 요청 테스트
	 * @throws Exception 
	*/
	@Test
	public void loginViewTest() throws Exception {
		/***Given***/
		
		/***When***/
		MvcResult mvcResult = mockMvc.perform(get("/login")).andReturn();
		ModelAndView mav = mvcResult.getModelAndView();
		
		/***Then***/
		assertEquals("login/login", mav.getViewName());
	}
	
	@Test
	public void loginProcessTest() throws Exception {
		MockHttpSession session = new MockHttpSession();

		mockMvc.perform(post("/login").param("userId", "brown")
									 .param("pass", "brown1234")
									 .session(session))
								.andExpect(status().isOk())
								.andExpect(view().name("main"));
								//.andExpect(request().sessionAttribute("S_USERVO", "brown"));
		
		User user = (User)session.getAttribute("S_USERVO");
		logger.debug("user : {}", user);
		assertNotNull(user);
															
	}

}
