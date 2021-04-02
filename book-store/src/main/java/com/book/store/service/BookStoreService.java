package com.book.store.service;

import java.util.List;

import com.book.store.domain.BookDO;

public interface BookStoreService {

	/**
	 * @author Syyed Sheeraz Shaukat
	 * 
	 * 
	 */

	List<BookDO> getAllBooks();

	public BookDO getBookById(Integer bookId);

	boolean addBooks(BookDO bookDO);

	void updateBook(BookDO bookDO);

	void deleteBook(Integer isbn);

}
