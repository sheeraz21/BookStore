package com.book.store.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.book.store.dao.BookDao;
import com.book.store.entity.BookEntity;

@Service
public class BookCacheService {
	Logger logger = LoggerFactory.getLogger(BookCacheService.class);
	@Autowired
	BookDao bookDao;

	@Cacheable(value = "bookCache", key = "#p0")
	public BookEntity getBookById(int bookId) {
		logger.info("Inside Cache Service : getBookById()");
		return bookDao.getBookById(bookId);
	}

	@CachePut(value = "bookCache")
	public void addBookInCache(BookEntity bookEntity) {
		logger.info("Inside Cache Service : addBookInCache()");
		bookDao.addBook(bookEntity);

	}
	
	@CacheEvict(value="bookCache", key="#p0")
    public void deleteBookById(int bookId) {
		logger.info("Inside Cache Service : deleteBookById()");
		bookDao.deleteBook(bookId);
    }

}
