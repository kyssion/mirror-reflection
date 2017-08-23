package java包.b_lang.string;

import java.io.UnsupportedEncodingException;
import java.util.StringTokenizer;

public class Mystring {
	String string = "123";
	// 上面一句等效于下面一句
	char[] aaa = { '1', '2', '3' };
	String string2 = new String(aaa, 0, aaa.length);
	// 字符串连接
	String bb = aaa + "123";

	public void heh() {
		"aaa".length();// 返回指定的长度
		
		//--字符串处理转化类
		String mString = "asdfasdf".trim(); 				// 返回字符串的副本，忽略前导空白和尾部空白。
		char[] chars = "aaa".toCharArray(); 				// 将此字符串转换为一个新的字符数组。
		String iString = "sss".toLowerCase(); 				// 使用默认语言环境的规则将此 String中的所有字符都转换为小写。
		String oString = "bbb".toUpperCase(); 				// 使用默认语言环境的规则将此 String中的所有字符都转换为大写。
		String bbbbbb = "aaa".substring(0, 10);				// 返回一个新字符串，它是此字符串的一个子字符串。
		String qString = "sss".replace("sss", "bbb"); 		// 用bbb 替换所有的sss
		String zString = "sss".replaceAll("正则", "vvvv"); 	// 使用给定的 replacement替换此字符串所有匹配给定的正则表达式的子字符串。
		String wString = "sss".replaceFirst("正则", "vvvv");	// 使用给定的 replacement替换此字符串匹配给定的正则表达式的第一个子字符串。
		
		
		//字符串操作函數
		//-----字符串解析
		byte[] charset = null;
		try {
			// 遇见了再说
			String aString = new String(charset, 0, charset.length, "UTF-8");// 方法将指定的字节码按照指定的方式进行解码
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			byte[] uio = "dsfsdf".getBytes("UTF-8");		// 使用指定的字符集将此 String 编码为
															// byte 序列，并将结果存储到一个新的 byte
															// 数组中。
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String.valueOf(123);// 返回一个基本类型的字符串类型
		
		//------字符串比较函数
		int b = "aaa".compareTo("bbb");						// 将两个字符串按照字典序进行比较不考虑大小写 >0 <0 =0
		b = "aaa".compareToIgnoreCase("str"); 				// 按字典顺序比较两个字符串，不考虑大小写。
		boolean bbn = "ccc".contentEquals("ggg"); 			// 将此字符串与指定的 CharSequence 比较。 这个方法还能和stringBuffer 进行比较 --- 使用char的值
		bbn = "ccc".equals("aaa"); // 字符串对象比较
		bbn = "ddd".equalsIgnoreCase("lll"); 				// 将此 String 与另一个 String 比较，不考虑大小写。

		//------字符串处理函数
		bbn = "sdf".endsWith(".sdf"); 						// 测试此字符串是否以指定的后缀结束。
		bbn = "sss".startsWith("heh", 0); 					// 测试此字符串从指定索引开始的子字符串是否以指定前缀开始。
		
		//------字符串生成函数
		char[] cha = { 'a', 'b', 'c' };
		String aaa = String.copyValueOf(cha, 0, 3); 		// 返回指定数组中表示该字符序列的 String。
		String ccc = "aaa".concat(string);					// 将指定字符串连接到此字符串的结尾。
		//------字符串查找函数
		int aaaa = "u".indexOf("dddd", 0); 					// 返回指定子字符串在此字符串中第一次出现处的索引，从指定的索引开始。第二个字符可省略
		aaaa = "dddd".lastIndexOf("dddd", 0); 				// 返回指定子字符串在此字符串中最后一次出现处的索引，从指定的索引开始反向搜索。
		CharSequence charSequence = "heheh";				// 是一个接口 String 实现了这个接口
		// 这是一个接口，代表的是一个有序字符集合，这个接口包含的方法有：charAt(int
		// index)，toString(),length(),subSequence(int start,int end).
		boolean bb = "bbb".contains(charSequence);			// 当且仅当此字符串包含指定的 char 值序列时，返回 true。
		bb = string.matches("正则"); 						// 告知此字符串是否匹配给定的正则表达式。

	}
	//StringTokenizer 的用法
	public  void method2(){
		StringTokenizer stringTokenizer = new StringTokenizer("123123", ",;");//声明形成一个可以进行分割和动态处理字符串的工具类可以指定多个字符为分割符号
		int count=stringTokenizer.countTokens();//返回分割了几个字符串
		boolean b = stringTokenizer.hasMoreTokens();//返回是否还有字符串没有被分割
		String string =stringTokenizer.nextToken(";");//返回字符串中的下一个标记 如果是空 就返回默认的字符串
		
	}
}