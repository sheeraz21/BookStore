package com.book.store.mapper;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.book.store.cache.BookCacheService;
import com.book.store.domain.BookDO;
import com.book.store.entity.BookEntity;

@Component
public class BookMapper {
	
	Logger logger = LoggerFactory.getLogger(BookCacheService.class);

	/**
	 * @author Syyed Sheeraz Shaukat
	 * 
	 * 
	 */

	public BookDO convertDtoToEntity(BookDO book, BookEntity bookEntity) {
		try {
			if(bookEntity != null) {
			BeanUtils.copyProperties(book, bookEntity);
			}
		} catch (IllegalAccessException e) {

			logger.debug("Unable to map the object",e.getCause());
		
		} catch (InvocationTargetException e) {

			logger.debug("Unable to find  the target",e.getCause());
		}

		return book;
	}

	public BookEntity convertEntityToDTO(BookEntity bookEntity, BookDO book) {

		try {
			if(book != null) {
			BeanUtils.copyProperties(bookEntity, book);
			}
		} catch (IllegalAccessException e) {

			logger.debug("Unable to map the object",e.getCause());
		} catch (InvocationTargetException e) {

			logger.debug("Unable to find  the target",e.getCause());
		}
		return bookEntity;
	}

	public List<BookDO> convertDTOListToEntityList(List<BookDO> listBookDO, List<BookEntity> listBookEntity) {

		try {
			if(listBookEntity != null) {
			BeanUtils.copyProperties(listBookDO, listBookEntity);
			}
		} catch (IllegalAccessException e) {


			logger.debug("Unable to map the object",e.getCause());
		} catch (InvocationTargetException e) {

			logger.debug("Unable to find  the target",e.getCause());
		}

		return listBookDO;

	}

}
