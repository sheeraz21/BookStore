package com.book.store;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.book.store.dao.BookDao;
import com.book.store.entity.BookEntity;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
public class BookDaoImplTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	BookDao bookDao;

	@Test
	public void whenFindAll() {

		BookEntity entity = new BookEntity();
		entity.setAuthor("Mining");
		entity.setDescription("Spring In Action Book By Mining");
		entity.setIsbn("123ABCD");
		entity.setName("Spring In Action");
		entity.setPrice(2000.00);
		entity.setType("Technical");
		entityManager.persist(entity);
		entityManager.flush();

		List<BookEntity> bookList = bookDao.getAllBooks();

		assertThat(bookList.size()).isEqualTo(6);

	}

	@Test
	public void whenFindAllById() {

		BookEntity bookEntity = new BookEntity();
		bookEntity.setAuthor("Mining");
		entityManager.persist(bookEntity);
		entityManager.flush();

		// when
		BookEntity testEntity = bookDao.getBookById(bookEntity.getBookId());
		assertThat(testEntity.getAuthor()).isEqualTo(bookEntity.getAuthor());
	}

	@Test
	public void whenbookExists() {

		BookEntity entity = new BookEntity();
		entity.setAuthor("Mining");
		entity.setDescription("Spring In Action Book By Mining");
		entity.setIsbn("123ABCD");
		entity.setName("Spring In Action");
		entity.setPrice(2000.00);
		entity.setType("Technical");
		entityManager.persist(entity);

		// when

		boolean flg = bookDao.bookExists(entity.getName(), entity.getDescription());
		assertEquals(flg, true);

	}

}
