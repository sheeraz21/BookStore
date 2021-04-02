package com.book.store;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.book.store.domain.BookDO;
import com.book.store.service.BookChekout;
import com.book.store.utill.BookUtill;

@SpringBootTest
public class BookChekoutImplTest {
	
	@Autowired
	BookChekout bookCheckOut;
	
	
	@Test
	@DisplayName("Test getBookSellPrice Success")
	public void testgetBookSellPrice() {

		BookDO bookOne = new BookDO(1, "Mining", "Spring In Action Book By Minin", "123ABCD", "Spring In Action",
				"Technical", 2000.0);
		double discountPer = 175.5;
		
		try {
			double discount = bookCheckOut.getBookSellPrice(bookOne.getBookId(), bookOne.getIsbn(), bookOne.getPrice(),BookUtill.calculateDiscount(bookOne.getType()));
			assertEquals(discountPer, discount);
			Assert.fail("NullPointerException not thrown");
		} catch (NullPointerException expected) {
		}
	}
	
	
	@Test
	@DisplayName("Test getBookSellPrice Success")
	public void testgetBookSellPriceWithBookDO() {

		BookDO bookOne = new BookDO(1, "Mining", "Spring In Action Book By Minin", "123ABCD", "Spring In Action",
				"Technical", 2000.0);
		
		
		try {
			BookDO bookTwo = bookCheckOut.getBookSellPrice(bookOne);
			assertEquals(bookOne, bookTwo);
			Assert.fail("NullPointerException not thrown");
		} catch (NullPointerException expected) {
		}
	}
	
	@Test
	@DisplayName("Test testgetBookSellPriceWithBookDOList Success")
	public void testgetBookSellPriceWithBookDOList() {

	
		List<BookDO> list = new ArrayList<BookDO>();
		BookDO bookOne = new BookDO(1, "Mining", "Spring In Action Book By Minin", "123ABCD", "Spring In Action",
				"Technical", 2000.0);
		BookDO bookTwo = new BookDO(2, "Mining", "Java In Action Book By Minin", "123ABCD", "Java In Action",
				"Technical", 4000.0);
		BookDO bookThree = new BookDO(3, "Mining", "SQL In Action Book By Minin", "123ABCD", "SQL In Action",
				"Technical", 1000.0);

		list.add(bookOne);
		list.add(bookTwo);
		list.add(bookThree);
		
		double discountPer = 175.5;
		
		try {
			Double dicount = bookCheckOut.getBookSellPrice(list);
			assertEquals(discountPer, dicount);
			Assert.fail("NullPointerException not thrown");
		} catch (NullPointerException expected) {
		}
	}
	
	@Test
	@DisplayName("Test getBookSellPrice Success")
	public void testgetBookSellPriceWithBookDOListandPromoCode() {

	
		List<BookDO> list = new ArrayList<BookDO>();
		BookDO bookOne = new BookDO(1, "Mining", "Spring In Action Book By Minin", "123ABCD", "Spring In Action",
				"Technical", 2000.0);
		BookDO bookTwo = new BookDO(2, "Mining", "Java In Action Book By Minin", "123ABCD", "Java In Action",
				"Technical", 4000.0);
		BookDO bookThree = new BookDO(3, "Mining", "SQL In Action Book By Minin", "123ABCD", "SQL In Action",
				"Technical", 1000.0);

		list.add(bookOne);
		list.add(bookTwo);
		list.add(bookThree);
		
		double discountPer = 175.5;
		
		try {
			Double dicount = bookCheckOut.getBookSellPrice(list, "firstUser10");
			assertEquals(discountPer, dicount);
			Assert.fail("NullPointerException not thrown");
		} catch (NullPointerException expected) {
		}
	}

}
