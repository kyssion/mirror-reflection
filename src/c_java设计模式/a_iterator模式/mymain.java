package c_java设计模式.a_iterator模式;

import c_java设计模式.a_iterator模式.a_接口.Iterator;
import c_java设计模式.a_iterator模式.b_元素类.Book;
import c_java设计模式.a_iterator模式.c_元素集合类.BookShelf;
//感悟核心就是生成可迭代元素的方法---iteratort---将处理和原来的元素分离
public class mymain {
	public static void main(String[] args) {
		BookShelf bookShelf = new BookShelf(100);
		for(int a=0;a<100;a++){
			bookShelf.appendBook(new Book(String.valueOf(a)));
		}
		Iterator iterator = bookShelf.iteratort();
		while(iterator.hasnext()){
			Book book = (Book)iterator.next();
			System.out.println(book.getName());
		}
	}
}
