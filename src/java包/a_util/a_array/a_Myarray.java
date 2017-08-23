package java包.a_util.a_array;

import java.awt.List;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
//java 中一切皆为对象 array 也是对象放在堆区
public class a_Myarray {
	// 数组声明
	static int[] a = { 1, 2, 3, 4, 5 };
	static int[] aa = { 1, 2, 3, 4, 5 };
	int[][] b = { { 1, 2, 33 }, { 2, 1 } };
	int[][] c = new int[1000][1000];
	// 当数组成员不是基本数据类型的时候传入的引用类型
	//多维数组 其实就是 多个一维数组使用 低维使用 数据进行 记录参数位置
	String d[][] = new String[100][100];// 两种写法
	int[][][] e = new int[3][][];// 变长数组必能省略 第一维

	public static void main() {
		List list = (List) Arrays.asList(a);// 讲 数组变成list
		long[] byteArr = { 10, 20, 15, 22, 35 };
		int retVal = Arrays.binarySearch(byteArr, 32);// 使用二分搜索搜索一个值
		retVal = Arrays.binarySearch(byteArr, 0, 100, 32);// 使用二分搜索搜索一个值 指定from和
															// to
		int[] arr2 = Arrays.copyOf(a, 5);// 此方法返回原始数组，截取或用零填充的副本取决于第二个函数表示的数组长度。
		arr2 = Arrays.copyOfRange(a, 2, 6);// 将数组从 2-6进行复制
		// boolean bbb=Arrays.deepEquals(a,aa);---判断两个object 数组书否相等
		boolean b = a.equals(aa);// 数组相等比较函数
		Arrays.fill(a, 10);// 数组使用10进行全局初始化
		Arrays.fill(a, 0, a.length, 10);// 指定长度进行初始化
		Comparator<Integer> comp = Collections.reverseOrder();
		Integer[] aaa= new Integer[]{123,123,123,123};
		//集合也有soft方法  Collections.sort
		Arrays.sort(aaa, 0, 2, comp);//指定 的位置进行排序  或者不传入 comp 使用默认的 实现接口自动排序
		Arrays.toString(a);//返回数组的字符串表示形式
	}
	//这个排序器用在array 中
	class myComparator implements Comparator<Integer>{
		//实现一个构造器将会进行动态的加载构造器
		//return o1小于、等于或大于o2，分别返回负整数、零或正整数。 
		@Override
		public int compare(Integer o1, Integer o2) {
			//这个方法用来判断当出传入的两个参数要进行什么样子的排序
			// TODO Auto-generated method stub
			return 0;
		}
	}
	//Comparable  这个可以直接让 类具有上面的构造器的属性   然后直接使用Collections.sort或Arrays.sort进行自动排序
	class User implements Comparable<User>{
		//原理同上实现这个方法将会动态的实现排序功能
		@Override
		public int compareTo(User o) {
			// TODO Auto-generated method stub
			//this>0 正数
			//this<o 附属
			//this=o  相等
			return 0;
		}
		
	}
}