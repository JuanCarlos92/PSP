package com.juancarlos.misegundomicroservicio;

import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@AutoConfigureMockMvc
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class MisegundomicroservicioApplicationTests {

	@Autowired
	MockMvc mockMvc;

	@Test
	@Order(0)
	void eliminarCurso() throws Exception {
		mockMvc.perform(delete("/api/delete/4"));

	}

	@Test
	@Order(1)
	void testCursos() throws Exception {
		mockMvc.perform(get("/api")).andDo(print());
	}

	@Test
	@Order(2)
	void testCurso() throws Exception {
		mockMvc.perform(post("/api/create")
		.contentType("application/json") // Indica que el contenido es JSON
		.content("{\"id\":5,\"nombre\":\"Ciencias\",\"horario\":\"Tarde\"}"))
		.andDo(print());

	}

	@Test
	@Order(3)
	void testCurso2() throws Exception {
		mockMvc.perform(put("/api/update/2")
		.contentType("application/json") // Indica que el contenido es JSON
		.content("{\"id\":2,\"nombre\":\"EducacionFisica\",\"horario\":\"Mañana\"}"))
		.andDo(print());
	}
}
