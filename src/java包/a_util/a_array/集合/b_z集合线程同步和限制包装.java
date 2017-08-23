package java包.a_util.a_array.集合;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class b_z集合线程同步和限制包装 {
	public void method(){
		//synchronizedxxx-将某一个 类变成同步的
		Collections.synchronizedList(new ArrayList<>());
		//只读设置  都是 xxxXXX()类型的  
		Collections.emptyList();//返回一个空的只读的list
		Collections.unmodifiableList(new ArrayList<>());//设置 这个list 内容不可修改
		Collections.singletonList("xxx");//只有一个参数的list
	}
}