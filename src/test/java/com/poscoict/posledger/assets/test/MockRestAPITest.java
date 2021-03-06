package com.poscoict.posledger.assets.test;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.poscoict.posledger.assets.model.vo.AccessToken;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class MockRestAPITest {

	private static final Logger logger = LoggerFactory.getLogger(MockRestAPITest.class);

	@Autowired
	private MockMvc mockMvc;

	@Before
	public void setUp() {
		//this.user = User.builder().id("test02").password("1234").build();
		logger.info("RestAPITest's setup is done...");
	}
	
	public static String asJsonString(final Object obj) {
	    try {
	        final ObjectMapper mapper = new ObjectMapper();
	        final String jsonContent = mapper.writeValueAsString(obj);
	        return jsonContent;
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}
	
	public static AccessToken toAccessToken(final String contents) {
	    try {
	        final ObjectMapper mapper = new ObjectMapper();
	        final AccessToken object = mapper.readValue(contents, AccessToken.class);
	        return object;
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}

	/**
	 * 로그인 화면 테스트
	 */
	@Test
	public void loginTest() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders
				.get("/oauth/list")
			    .accept(MediaType.TEXT_HTML))
				.andDo(print())
				.andExpect(status().isOk());
	}
}
