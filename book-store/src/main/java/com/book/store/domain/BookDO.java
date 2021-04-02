package com.book.store.domain;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;

public class BookDO implements Serializable {



	/**
	 * @author Syyed Sheeraz Shaukat
	 * 
	 * 
	 */

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(notes = "Book Id is unique id for book ",name="bookId",required=true,value="bookId")
	private Integer bookId;

	@ApiModelProperty(notes = "ISBN is unique id for book ",name="isbn",required=true,value="isbn")
	@NotBlank(message = "ISBN cannot be null")
	private String isbn;

	@ApiModelProperty(notes = "Name of the book ",name="name",required=true,value="name")
	@NotBlank(message = "Name cannot be null")
	private String name;

	@ApiModelProperty(notes = "Description of the book ",name="description",required=true,value="description")
	@Size(min = 10, max = 200, message = "Description  must be between 10 and 200 characters")
	private String description;

	@ApiModelProperty(notes = "Author Name of the book ",name="author",required=true,value="author")
	@NotNull(message = "Author cannot be null")
	private String author;

	@ApiModelProperty(notes = "Type of the book ",name="type",required=true,value="type")
	@NotNull(message = "Type cannot be null")
	private String type;

	@ApiModelProperty(notes = "Price of the book ",name="price",required=true,value="price")
	@Positive(message = "Price Must be Positive Value ")
	private Double price;

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "BookDO [bookId=" + bookId + ", isbn=" + isbn + ", name=" + name + ", description=" + description
				+ ", author=" + author + ", type=" + type + ", price=" + price + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((bookId == null) ? 0 : bookId.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookDO other = (BookDO) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (bookId == null) {
			if (other.bookId != null)
				return false;
		} else if (!bookId.equals(other.bookId))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	public BookDO(Integer bookId, @NotBlank(message = "ISBN cannot be null") String isbn,
			@NotBlank(message = "Name cannot be null") String name,
			@Size(min = 10, max = 200, message = "Description  must be between 10 and 200 characters") String description,
			@NotNull(message = "Author cannot be null") String author,
			@NotNull(message = "Type cannot be null") String type,
			@Positive(message = "Price Must be Positive Value ") Double price) {
		super();
		this.bookId = bookId;
		this.isbn = isbn;
		this.name = name;
		this.description = description;
		this.author = author;
		this.type = type;
		this.price = price;
	}
	
	public BookDO() {
		
	}
}
