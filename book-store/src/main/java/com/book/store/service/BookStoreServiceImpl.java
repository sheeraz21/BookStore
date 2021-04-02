package com.book.store.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.store.cache.BookCacheService;
import com.book.store.dao.BookDao;
import com.book.store.domain.BookDO;
import com.book.store.entity.BookEntity;
import com.book.store.mapper.BookMapper;

@Service
public class BookStoreServiceImpl implements BookStoreService {

	/**
	 * @author Syyed Sheeraz Shaukat
	 * 
	 * 
	 */
	Logger logger = LoggerFactory.getLogger(BookCacheService.class);
	
	@Autowired
	BookDao book;

	@Autowired
	BookMapper mapper;
	
	@Autowired
	BookCacheService cache;

	@Override
	public List<BookDO> getAllBooks() {
		logger.info("Inside BookStoreServiceImpl : getAllBooks()");
		List<BookEntity> list = book.getAllBooks();
		List<BookDO> listDo = new ArrayList<BookDO>();
		mapper.convertDTOListToEntityList(listDo, list);
		return listDo;
	}

	@Override
	public BookDO getBookById(Integer bookId) {
		BookEntity bookEntity = new BookEntity ();
		logger.info("Befor Cache Service : getBookById()");
		bookEntity = cache.getBookById(bookId);
		logger.info("After Cache Service : getBookById()");
		if(bookEntity==null) {
			logger.info("After DB Service Call : getBookById()");
		 bookEntity = book.getBookById(bookId);
		}
		BookDO book = new BookDO();
		book = mapper.convertDtoToEntity(book, bookEntity);
		return book;
	}

	@Override
	public synchronized boolean addBooks(BookDO bookDO) {
		BookEntity bookEntity = new BookEntity();
		logger.info("Inside BookStoreServiceImpl : addBooks()");
		bookEntity = mapper.convertEntityToDTO(bookEntity, bookDO);

		if (book.bookExists(bookEntity.getName(), bookEntity.getIsbn())) {
			return false;
		} else {
			book.addBook(bookEntity);
			return true;
		}
	}

	@Override
	public void updateBook(BookDO bookDO) {
		BookEntity bookEntity = new BookEntity();
		logger.info("Inside BookStoreServiceImpl : updateBook()");
		bookEntity = mapper.convertEntityToDTO(bookEntity, bookDO);
		book.updateBook(bookEntity);

	}

	@Override
	public void deleteBook(Integer isbn) {
		logger.info("Inside BookStoreServiceImpl : deleteBook()");
		book.deleteBook(isbn);

	}

}
