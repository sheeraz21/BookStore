package com.book.store;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.book.store.domain.BookDO;

@SpringBootTest()

public class BookStoreControllerIntegrationTest {

	@Test
	public void testGetBookListSuccess() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();

		final String baseUrl = "http://localhost:" + 8888 + "/store/books";
		URI uri = new URI(baseUrl);

		try {
			ResponseEntity<BookDO> result = restTemplate.getForEntity(uri, BookDO.class);

			// Verify request succeed
			Assert.assertEquals(200, result.getStatusCodeValue());
			Assert.assertEquals(true, result.getBody());
			Assert.fail("RestClientException not thrown");
		} catch (RestClientException expected) {
		}
	}

	@Test
	public void testGetBookById() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();

		final String baseUrl = "http://localhost:" + 8888 + "/store/book/10";
		URI uri = new URI(baseUrl);
		try {
			ResponseEntity<BookDO> result = restTemplate.getForEntity(uri, BookDO.class);

			// Verify request succeed
			Assert.assertEquals(200, result.getStatusCodeValue());
			Assert.assertEquals(true, result.getBody());
			Assert.fail("HttpServerErrorException not thrown");
		} catch (HttpServerErrorException expected) {
		}
	}

	@Test
	public void testUpdateBook() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();

		final String baseUrl = "http://localhost:" + 8888 + "/store/update/book";
		URI uri = new URI(baseUrl);

		BookDO entity = new BookDO();
		entity.setAuthor("Mining");
		entity.setDescription("Spring In Action Book By Mining");
		entity.setIsbn("123ABCD");
		entity.setName("Spring In Action");
		entity.setPrice(2000.00);
		entity.setType("Technical");
		HttpEntity<BookDO> httpEntity = new HttpEntity<BookDO>(entity);
		try {
			ResponseEntity<BookDO> result = restTemplate.exchange(uri, HttpMethod.PUT, httpEntity, BookDO.class);

			// Verify request succeed
			Assert.assertEquals(200, result.getStatusCodeValue());
			Assert.assertEquals(true, result.getBody());
			Assert.fail("HttpServerErrorExceptionNotFound not thrown");
		} catch (HttpServerErrorException expected) {
		}
	}

	@Test()
	public void testdeleteBook() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();

		final String baseUrl = "http://localhost:" + 8888 + "/store/book/";
		URI uri = new URI(baseUrl);

		BookDO entity = new BookDO();
		entity.setBookId(10);

		HttpEntity<BookDO> httpEntity = new HttpEntity<BookDO>(entity);
		try {
			ResponseEntity<BookDO> result = restTemplate.exchange(uri, HttpMethod.DELETE, httpEntity, BookDO.class);

			// Verify request succeed
			Assert.assertEquals(200, result.getStatusCodeValue());
			Assert.assertEquals(true, result.getBody());
			Assert.fail("HttpClientErrorExceptionNotFound not thrown");
		} catch (HttpClientErrorException expected) {
		}
	}

	@Test()
	public void testaddBook() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();

		final String baseUrl = "http://localhost:" + 8888 + "/create/book";
		URI uri = new URI(baseUrl);

		BookDO entity = new BookDO();
		entity.setAuthor("Mining");
		entity.setDescription("Spring In Action Book By Mining");
		entity.setIsbn("123ABCD");
		entity.setName("Spring In Action");
		entity.setPrice(2000.00);
		entity.setType("Technical");
		HttpEntity<BookDO> httpEntity = new HttpEntity<BookDO>(entity);

		try {

			ResponseEntity<BookDO> result = restTemplate.exchange(uri, HttpMethod.POST, httpEntity, BookDO.class);

			// Verify request succeed
			Assert.assertEquals(201, result.getStatusCodeValue());
			Assert.assertEquals(true, result.getBody());
			Assert.fail("HttpClientErrorExceptionNotFound not thrown");

		} catch (HttpClientErrorException expected) {
		}
	}

	@Test
	public void testGetDiscountByPromoCode() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();

		final String baseUrl = "http://localhost:" + 8888 + "/store/books/10percnetage";
		URI uri = new URI(baseUrl);
		BookDO entity = new BookDO();
		entity.setAuthor("Mining");
		entity.setDescription("Spring In Action Book By Mining");
		entity.setIsbn("123ABCD");
		entity.setName("Spring In Action");
		entity.setPrice(2000.00);
		entity.setType("Technical");

		HttpEntity<BookDO> httpEntity = new HttpEntity<BookDO>(entity);
		try {
			ResponseEntity<Double> result = restTemplate.exchange(uri, HttpMethod.POST, httpEntity, Double.class);

			// Verify request succeed
			Assert.assertEquals(200, result.getStatusCodeValue());
			Assert.assertEquals(true, result.getBody());
			Assert.fail("HttpClientErrorExceptionNotFound not thrown");
		} catch (HttpClientErrorException expected) {
		}
	}
}
