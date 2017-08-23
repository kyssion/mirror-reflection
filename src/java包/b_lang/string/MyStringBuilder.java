package java包.b_lang.string;

public class MyStringBuilder {
		// 一个可变的字符序列。此类提供一个与 StringBuffer 兼容的 API，但不保证同步
		// 的字符串缓冲区，但不能修改。虽然在任意时间点上它都包含某种特定的字符序列，
		// 但通过某些方法调用可以改变该序列的长度和内容。
		StringBuilder stringBuffer = new StringBuilder("sdfsdfsdf");	// 构造函数可以选择友参数string或者没有参数或者指定缓冲区大小的默认没有大小
		public void method() {
			stringBuffer.append("sdfsdf");							// 此方法可以将任意的基本数据类型加进末尾CharSequencestringBuffer
			stringBuffer.insert(0, 123);							//将參數插入指定位置。		
			// indexof lastindexof---搜索方法
			stringBuffer = stringBuffer.delete(0, 10); 				// 移除此序列的子字符串中的字符。
			stringBuffer = stringBuffer.deleteCharAt(4); 			// 移除此序列指定位置的 char。
			char[] ch = null;
			stringBuffer.getChars(0, 10, ch, 2);					// 将stringbuffer 0-10 拷进从ch的=第2位开始的地方
			stringBuffer = stringBuffer.replace(0, 12, "23");		// 使用给定 String 中的字符替换此序列的子字符串中的字符。
			stringBuffer = stringBuffer.reverse(); 					// 将此字符序列用其反转形式取代。
			
		}
}