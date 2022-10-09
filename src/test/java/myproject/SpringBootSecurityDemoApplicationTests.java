package myproject;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
@WithMockUser(username = "1", password = "11", roles = "ADMIN")
class SpringBootSecurityDemoApplicationTests {

	@Autowired
	MockMvc mvc;

	@Test
	void checkingAllUsers() throws Exception {
		mvc.perform(get("/api/users"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$").hasJsonPath())
				.andExpect(jsonPath("$[0].name").value("Faina"))
				.andExpect(jsonPath("$[1].name").value("Diana"));


	}
	@Test
	void checkingOneUsers() throws Exception {
		mvc.perform(get("/api/users/3"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$").hasJsonPath())
				.andExpect(jsonPath("$.username").value("1"));
	}

}