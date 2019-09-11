package com.yst.demo;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.RestDocsProperties;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.hasSize;

import com.yst.demo.controller.TodoController;
import com.yst.demo.model.Todo;
import com.yst.demo.service.TodoService;


@ExtendWith(RestDocumentationExtension.class)
@WebMvcTest(controllers = TodoController.class)
public class TodoControllerTests {

	@Autowired WebApplicationContext context;
	private  MockMvc mockMvc;
	@MockBean
	private TodoService todoService;
	
	@BeforeEach
	void setUp(RestDocumentationContextProvider restDocumentation) {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(context)
				.apply(documentationConfiguration(restDocumentation)).build();
	}
	
	@Test
	void getAllTodos() throws Exception{
		List<Todo> todos = new ArrayList<>();
		todos.add(new Todo(1L,"Eat",true));
		todos.add(new Todo(2L,"Sleep",true));
		when(todoService.findAll()).thenReturn(todos);
		
		this.mockMvc.perform(MockMvcRequestBuilders.get("/todos")
				.contentType(MediaType.APPLICATION_JSON)
				).andExpect(jsonPath("$",hasSize(2)))
		.andDo(print())
		.andDo(document("todos"))
		;
			
	}
}
