package kr.or.ddit.encrypt.kisa.aria;

import static org.junit.Assert.*;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.encrypt.kisa.sha256.KISA_SHA256;

public class AriaUtilTest {
	private static final Logger logger = LoggerFactory.getLogger(AriaUtilTest.class);
	/**
	* Method : encryptDecryptTesttest
	* 작성자 : PC-07
	* 변경이력 :
	* Method 설명 : aria 블록 암호화/복호화 테스트
	 * @throws UnsupportedEncodingException 
	 * @throws InvalidKeyException 
	*/
	@Test
	public void encryptDecryptTest() throws InvalidKeyException, UnsupportedEncodingException {
		/***Given***/
		String userId = "brownm";
		
		/***When***/
		String encryptedText = ARIAUtil.ariaEncrypt(userId);
		String decryptedText = ARIAUtil.ariaDecrypt(encryptedText);
		
		logger.debug("encryptedText : {}", encryptedText);
		logger.debug("decryptedText : {}", decryptedText);
		
		
		/***Then***/
		//assertEquals("예상값", "실제값");
	}

}
