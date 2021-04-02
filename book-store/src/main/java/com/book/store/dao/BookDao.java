package com.book.store.dao;

import java.util.List;

import com.book.store.entity.BookEntity;

public interface BookDao {

	/**
	 *  @author Syyed Sheeraz Shaukat
	 *  
	 * 
	 */
	List<BookEntity> getAllBooks();

	BookEntity getBookById(Integer bookId);

	void addBook(BookEntity bookEntity);

	void updateBook(BookEntity bookEntity);

	void deleteBook(Integer bookId);

	boolean bookExists(String name, String description);

}
