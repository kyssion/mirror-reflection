package c_java设计模式.a_iterator模式.d_集合迭代类;

import c_java设计模式.a_iterator模式.a_接口.Iterator;
import c_java设计模式.a_iterator模式.c_元素集合类.BookShelf;
//使用适配器模式可以动态修改迭代策略从而降低项目的耦合度
public class BookShelfIterator implements Iterator {
	private BookShelf bookShelf;
	private int index=0;
	public BookShelfIterator(BookShelf bookShelf) {
		// TODO Auto-generated constructor stub
		this.bookShelf=bookShelf;
	}
	@Override
	public boolean hasnext() {
		// TODO Auto-generated method stub
		return index<bookShelf.getLength()?true:false;
	}

	@Override
	public Object next() {
		// TODO Auto-generated method stub
		return bookShelf.getBookAt(index++);
	}

}
