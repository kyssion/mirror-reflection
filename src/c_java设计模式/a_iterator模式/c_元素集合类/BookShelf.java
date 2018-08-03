package c_java设计模式.a_iterator模式.c_元素集合类;

import c_java设计模式.a_iterator模式.a_接口.Aggregate;
import c_java设计模式.a_iterator模式.a_接口.Iterator;
import c_java设计模式.a_iterator模式.b_元素类.Book;
import c_java设计模式.a_iterator模式.d_集合迭代类.BookShelfIterator;

public class BookShelf implements Aggregate{
	private Book[] books;
	private int last=0;
	public BookShelf(int sizeMax) {
		// TODO Auto-generated constructor stub
		this.books=new Book[sizeMax];
	}
	public Book getBookAt(int index){
		return books[index];
	}
	public void appendBook(Book book){
		this.books[this.last]=book;
		this.last++;
	}
	public int getLength(){
		return this.last;
	}
	
	@Override
	public Iterator iteratort() {
		// TODO Auto-generated method stub
		return new BookShelfIterator(this);
	}

}
