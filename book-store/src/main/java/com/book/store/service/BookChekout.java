package com.book.store.service;

import java.util.List;

import com.book.store.domain.BookDO;

public interface BookChekout {

	/**
	 * @author Syyed Sheeraz Shaukat
	 * 
	 * 
	 */
	Double getBookSellPrice(Integer id, String isbn, Double price, Double discntPercntge);

	BookDO getBookSellPrice(BookDO bookObj);

	Double getBookSellPrice(List<BookDO> bookObjList);

	Double getBookSellPrice(List<BookDO> bookObjList, String promoCode);

}
