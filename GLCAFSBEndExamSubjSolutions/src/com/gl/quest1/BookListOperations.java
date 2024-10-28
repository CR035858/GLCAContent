package com.gl.quest1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class BookListOperations {

	ArrayList <Book> bookList = new ArrayList<Book>();
	
	public void viewBooks()
	{
		
		Iterator <Book> bIter = bookList.iterator();
		System.out.println("The Book List details are ....");
		while(bIter.hasNext())
		{
			Book book = bIter.next();
			System.out.println(book);
		}
		
	}
	public void addBook(Book book)
	{
		bookList.add(book);
		System.out.println("Book added to The Book List Successfully...");
	}
	public void deleteBookById(String bookId)
	{
		Iterator <Book> bIter = bookList.iterator();
		int ctr = 0;
		while(bIter.hasNext())
		{
			Book book = bIter.next();
			if(book.getBookId().equals(bookId))
			{
				bookList.remove(ctr);
				break;
			}
			ctr++;
		}
		
	}
	public Book getBookById(String bId)
	{
		Iterator <Book> bIter = bookList.iterator();
		while(bIter.hasNext())
		{
			Book bookG = bIter.next();
			if(bookG.getBookId().equals(bId))
			{
				return bookG;
				
			}
			
		}
		return null;
	}
	public void updateBookById(String bookId,Book book)
	{
		Iterator <Book> bIter = bookList.iterator();
		int ctr = 0;
		while(bIter.hasNext())
		{
			Book bookU = bIter.next();
			if(bookU.getBookId().equals(bookId))
			{
				bookU.setBookName(book.getBookName());
				bookU.setBookAuthorName(book.getBookAuthorName());
				bookU.setBookPrice(book.getBookPrice());
				bookList.remove(ctr);
				bookList.add(ctr, bookU);
			}
			ctr++;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan1 = new Scanner(System.in);
		String reply = "yes";
		int option=0;
		BookListOperations bOperation = new BookListOperations();
		while(reply.equals("yes") || reply.equals("YES"))
		{
			System.out.println("-------------BookList Menu----------------");
			System.out.println("1. View Books");
			System.out.println("2. Add Book");
			System.out.println("3. Delete Book By Id");
			System.out.println("4. Update Book By Id");
			System.out.println("Enter Your Option .");
			option = scan1.nextInt();
			switch(option)
			{
				case 1:
				{
					bOperation.viewBooks();
					break;
				}
				case 2:
				{
					String bookId, bookName,bookAuthorName;
					int bookPrice;
					System.out.println("Enter the Book Id");
					bookId = scan1.next();
					System.out.println("Enter the Book Name");
					bookName = scan1.next();
					System.out.println("Enter the Book Author Name");
					bookAuthorName = scan1.next();
					System.out.println("Enter the Book Price");
					bookPrice = scan1.nextInt();
					Book book = new Book(bookId, bookName,bookAuthorName,bookPrice);
					bOperation.addBook(book);
					break;
				}
				case 3:
				{
					String bId;
					System.out.println("Enter the Id of the Book which you wish to delete...");
					bId = scan1.next();
					bOperation.deleteBookById(bId);
					System.out.println("Book Deleted Successfully for Id "+bId);
					break;
				}
				case 4:
				{
					Book bookU = new Book();
					String bId ;
					System.out.println("Enter the Id of the Book which you wish to Update...");
					bId = scan1.next();
					bookU = bOperation.getBookById(bId);
					String bookName,bookAuthorName;
					int bookPrice;
					
					System.out.println("Enter the New Book Name");
					bookName = scan1.next();
					System.out.println("Enter the New Book Author Name");
					bookAuthorName = scan1.next();
					System.out.println("Enter the New Book Price");
					bookPrice = scan1.nextInt();
					
					bookU.setBookName(bookName);
					bookU.setBookAuthorName(bookAuthorName);
					bookU.setBookPrice(bookPrice);
					
					bOperation.updateBookById(bId, bookU);
					System.out.println("Book Updated Successfully.....");
					break;
				}
				default:
				{
					System.out.println("Sorry Correct Options are 1-4");
				}
			}
			System.out.println("Do You Wish to Continue yes/no");
			reply = scan1.next();
		}
		
		System.out.println("You are Out of Loop...");

	}

}
