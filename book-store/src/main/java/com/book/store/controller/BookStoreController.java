package com.book.store.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.book.store.domain.BookDO;
import com.book.store.service.BookChekout;
import com.book.store.service.BookStoreService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@Api(value = "BookStoreController", description = "REST Apis related to Book Store Services!!!!")
@RestController
@RequestMapping("store")
public class BookStoreController {
	
	Logger logger = LoggerFactory.getLogger(BookStoreController.class);
	
	/**
	 *  @author Syyed Sheeraz Shaukat
	 *  
	 * 
	 */

	@Autowired
	BookStoreService bookService;

	@Autowired
	BookChekout checkout;

	@ApiOperation(value = "Get specific Book from the System Based on Book Id ", response = BookDO.class, tags = "bookstore")
	@GetMapping("book/{bookId}")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Suceess|OK"),
			@ApiResponse(code = 401, message = "not authorized!"), 
			@ApiResponse(code = 403, message = "forbidden!!!"),
			@ApiResponse(code = 404, message = "not found!!!") })
	public ResponseEntity<BookDO> getBookById(@PathVariable("bookId") Integer bookId) {
		logger.info("Inside BookStoreController : getBookById()");
		BookDO book = bookService.getBookById(bookId);
		return new ResponseEntity<BookDO>(book, HttpStatus.OK);
	}

	@ApiOperation(value = "Get list of Books from the System ", response = BookDO.class, tags = "bookstore")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Suceess|OK"),
			@ApiResponse(code = 401, message = "not authorized!"), 
			@ApiResponse(code = 403, message = "forbidden!!!"),
			@ApiResponse(code = 404, message = "not found!!!") })
	@GetMapping("books")
	public ResponseEntity<List<BookDO>> getAllBooks() {
		logger.info("Inside BookStoreController : getAllBooks()");
		List<BookDO> list = bookService.getAllBooks();
		return new ResponseEntity<List<BookDO>>(list, HttpStatus.OK);
	}

	@ApiOperation(value = "Create  Book in the System ", response = BookDO.class, tags = "bookstore")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Suceess|OK"),
			@ApiResponse(code = 401, message = "not authorized!"), 
			@ApiResponse(code = 403, message = "forbidden!!!"),
			@ApiResponse(code = 404, message = "not found!!!") })
	@PostMapping("create/book")
	public ResponseEntity<Void> addBook(@Valid @RequestBody BookDO bookDO, UriComponentsBuilder builder) {
		logger.info("Inside BookStoreController : addBook()");
		boolean bookCreatedFlag = bookService.addBooks(bookDO);
		if (bookCreatedFlag == false) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/book/{id}").buildAndExpand(bookDO.getBookId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@PutMapping("update/book")
	@ApiOperation(value = "Update  Book Details in the System ", response = BookDO.class, tags = "bookstore")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Suceess|OK"),
			@ApiResponse(code = 401, message = "not authorized!"), 
			@ApiResponse(code = 403, message = "forbidden!!!"),
			@ApiResponse(code = 404, message = "not found!!!") })
	public ResponseEntity<BookDO> updateBook(@Valid @RequestBody BookDO bookDO ) {
		logger.info("Inside BookStoreController : updateBook()");
		bookService.updateBook(bookDO);
		return new ResponseEntity<BookDO>(bookDO, HttpStatus.OK);
	}

	@DeleteMapping("book/{bookId}")
	@ApiOperation(value = "Remove  Book Details from the System Based on the BookId", response = BookDO.class, tags = "bookstore")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Suceess|OK"),
			@ApiResponse(code = 401, message = "not authorized!"), 
			@ApiResponse(code = 403, message = "forbidden!!!"),
			@ApiResponse(code = 404, message = "not found!!!") })
	public ResponseEntity<Void> deleteBook(@PathVariable("bookId") Integer bookId) {
		logger.info("Inside BookStoreController : deleteBook()");
		bookService.deleteBook(bookId);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}


	@PostMapping("books/{promoCode}")
	@ApiOperation(value = "Checkout Book Details in the System", response = Double.class, tags = "bookstore")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Suceess|OK"),
			@ApiResponse(code = 401, message = "not authorized!"), 
			@ApiResponse(code = 403, message = "forbidden!!!"),
			@ApiResponse(code = 404, message = "not found!!!") })
	public ResponseEntity<Double> bookCheckOut(@RequestBody List<BookDO> bookList,
			@PathVariable("promoCode") String promoCode) {
		logger.info("Inside BookStoreController : bookCheckOut()");
		Double finalPrice = checkout.getBookSellPrice(bookList, promoCode);

		return new ResponseEntity<Double>(finalPrice, HttpStatus.OK);
	}

}
