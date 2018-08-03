package java包.NIO;

import java.nio.charset.Charset;

public class e_charset {
	public void method(){
		Charset charset = Charset.defaultCharset();//返回默认字符集的charset
		charset=Charset.forName("UTF-8");//返回指定字符集的charset
		boolean b=Charset.isSupported("UTF-8");//查看是否支持这个字符集
		
	}
}
