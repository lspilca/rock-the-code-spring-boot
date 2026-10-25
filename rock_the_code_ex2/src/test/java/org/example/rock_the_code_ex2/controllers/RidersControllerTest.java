package org.example.rock_the_code_ex2.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RidersController.class)
public class RidersControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testGetRiders() throws Exception {
		this.mockMvc.perform(get("/api/riders")).andExpect(status().isOk()).andExpect(jsonPath("$.length()").value(2))
				.andExpect(jsonPath("$[0].name").value("Lara")).andExpect(jsonPath("$[1].name").value("John"));
	}
}
