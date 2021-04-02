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
import com.book.store.service.BookStoreService;

@SpringBootTest
public class BookStoreServiceImplTest {

	@Autowired
	BookStoreService bookStoreService;

	@Test
	@DisplayName("Test findByBookId Success")
	public void testFindByBookId() {

		BookDO bookOne = new BookDO(1, "Mining", "Spring In Action Book By Minin", "123ABCD", "Spring In Action",
				"Technical", 2000.0);
		try {
			BookDO bookTwo = bookStoreService.getBookById(1);
			assertEquals(bookOne, bookTwo);
			Assert.fail("NullPointerException not thrown");
		} catch (NullPointerException expected) {
		}
	}

	@Test
	@DisplayName("Test testAllBooks Success")
	public void testAllBooks() {

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
		try {
			List<BookDO> book = bookStoreService.getAllBooks();
			assertEquals(list, book);
			Assert.fail("NullPointerException not thrown");
		} catch (NullPointerException expected) {
		}
	}

	@Test
	@DisplayName("Test testAddBooks Success")
	public void testaddBooks() {

		BookDO bookOne = new BookDO(1, "Mining", "Spring In Action Book By Minin", "123ABCD", "Spring In Action",
				"Technical", 2000.0);

		try {
			Boolean flg = bookStoreService.addBooks(bookOne);
			assertEquals(true, flg);
			Assert.fail("NullPointerException not thrown");
		} catch (NullPointerException expected) {
		}
	}

}
