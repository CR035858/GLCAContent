package com.gl.quest1;

public class Book {
	
	String bookId;
	String bookName;
	String bookAuthorName;
	int bookPrice;
	
	
	public Book() {
		super();
	}


	public Book(String bookId, String bookName, String bookAuthorName, int bookPrice) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookAuthorName = bookAuthorName;
		this.bookPrice = bookPrice;
	}


	public String getBookId() {
		return bookId;
	}


	public void setBookId(String bookId) {
		this.bookId = bookId;
	}


	public String getBookName() {
		return bookName;
	}


	public void setBookName(String bookName) {
		this.bookName = bookName;
	}


	public String getBookAuthorName() {
		return bookAuthorName;
	}


	public void setBookAuthorName(String bookAuthorName) {
		this.bookAuthorName = bookAuthorName;
	}


	public int getBookPrice() {
		return bookPrice;
	}


	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}


	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName + ", bookAuthorName=" + bookAuthorName
				+ ", bookPrice=" + bookPrice + "]";
	}

	
	

}
