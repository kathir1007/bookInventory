package com.msys.bookinventory.controller;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.msys.bookinventory.model.Book;
import com.msys.bookinventory.service.BookService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = BookController.class)
@WithMockUser
class BookControllerTest {
	
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private BookService bookService;
	
	Book mockBook = new Book(3l, "Jpa","Rob", 12,5);
	

	@Test
	public void retrieveBook() throws Exception {

		Mockito.when(
				bookService.getBookData(Mockito.any())).thenReturn(mockBook);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"http://localhost:8081/book/getBookData/3").accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());
		String expected = "{id:3,title:Jpa,authorName:Rob,price:12.0,rating:5}";


		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
	}

}
