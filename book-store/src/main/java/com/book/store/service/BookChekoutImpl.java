package com.book.store.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.book.store.domain.BookDO;
import com.book.store.utill.BookUtill;

@Service
public class BookChekoutImpl implements BookChekout {
	
	Logger logger = LoggerFactory.getLogger(BookChekoutImpl.class);
	/**
	 * @author Syyed Sheeraz Shaukat
	 * 
	 * 
	 */

	@Override
	public Double getBookSellPrice(Integer id, String isbn, Double price, Double discntPercntge) {
		Double bookPrice = BookUtill.getPriceForDicnt(price, discntPercntge);
		logger.info("Inside BookChekoutImpl Service : getBookSellPrice()");
		return bookPrice;
	}

	@Override
	public BookDO getBookSellPrice(BookDO bookObj) {
		if (bookObj != null) {
			double CalcultedBookPrice = getBookSellPrice(bookObj.getBookId(), bookObj.getIsbn(), bookObj.getPrice(),
					BookUtill.calculateDiscount(bookObj.getType()));
			bookObj.setPrice(CalcultedBookPrice);
			logger.info("Inside BookChekoutImpl Service : getBookSellPrice(bookObj)");
		}
		return bookObj;
	}

	@Override
	public Double getBookSellPrice(List<BookDO> bookObjList) {
		Double totalPrice = 0.0;

		if (bookObjList != null && !bookObjList.isEmpty()) {

			for (BookDO bookObj : bookObjList) {
				getBookSellPrice(bookObj);
				totalPrice = totalPrice + bookObj.getPrice();
				logger.info("Inside BookChekoutImpl Service : getBookSellPrice(bookObjList)");
			}
		}
		return totalPrice;
	}

	@Override
	public Double getBookSellPrice(List<BookDO> bookObjList, String promoCode) {

		Double totalPrice = getBookSellPrice(bookObjList);

		if (StringUtils.isNotEmpty(promoCode)) {

			Double promoCodeDiscount = BookUtill.calculateDiscountForPromoCode(promoCode);
			totalPrice = BookUtill.getPriceForDicnt(totalPrice, promoCodeDiscount);
			logger.info("Inside BookChekoutImpl Service : getBookSellPrice(bookObjList,promoCode)");
		}
		return totalPrice;
	}

}
