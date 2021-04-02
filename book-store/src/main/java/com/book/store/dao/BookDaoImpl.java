package com.book.store.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.book.store.entity.BookEntity;

@Transactional
@Repository
public class BookDaoImpl implements BookDao {
	
	/**
	 *  @author Syyed Sheeraz Shaukat
	 *  
	 * 
	 */

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<BookEntity> getAllBooks() {

		String hql = "FROM BookEntity as b ORDER BY b.bookId";
		return (List<BookEntity>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public BookEntity getBookById(Integer isbn) {

		return entityManager.find(BookEntity.class, isbn);
	}


	@Override
	public void addBook(BookEntity bookEntity) {

		entityManager.persist(bookEntity);
	}

	@Override
	public void updateBook(BookEntity bookEntity) {
		BookEntity book = getBookById(bookEntity.getBookId());
		book.setName(bookEntity.getName());
		book.setDescription(bookEntity.getDescription());
		book.setAuthor(bookEntity.getAuthor());
		book.setPrice(bookEntity.getPrice());
		book.setType(bookEntity.getType());
		entityManager.flush();

	}

	@Override
	public void deleteBook(Integer bookId) {

		entityManager.remove(getBookById(bookId));
	}

	@Override
	public boolean bookExists(String name, String description) {

		String hql = "FROM BookEntity as b WHERE b.name = ?1 and b.description = ?2";
		int count = entityManager.createQuery(hql).setParameter(1, name).setParameter(2, description).getResultList()
				.size();
		return count > 0 ? true : false;
	}

}
