package java包.c_io;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;

//java的文件操作类和输入输出流类

public class a_文件类 {
	//File 类
	public void method(){
		//File获得文件本身的一些信息
		File file=new File("c://xxx","xxx.txt");				//通过使用 据对路径名称加上文件名称动态的获得文件
		//可以省略第一个参数表示文件在当前的运行目录下
		//----方法
		String string;
		boolean b;
		string= file.getAbsolutePath(); 						//获得文件的绝对路径
		//-----文件 可执行性操作类(文件相关的操作除了可以返回string都可以返回file类型)
		string=file.getParent();
		//返回父路径
		file.getParentFile();
		string=file.getPath();//返回绝对路径
		//返回绝对路径名称
		string = file.getAbsolutePath();
		b=file.canRead();
		b=file.canWrite();
		b=file.canExecute();
		b=file.isDirectory();
		b=file.isHidden();
		b=file.isFile();
		//返回最后一次的修改日期
		file.lastModified();
		//返回文集是否存在
		file.exists();
		//立即删除这个目录下的所有东西
		file.delete();
		//当虚拟关闭的时候才删除这个虚拟机下的东西
		file.deleteOnExit();
		//-----文件创建操作类
		//返回父路径
		file.getParentFile();
		try {
			//注意要保证文件夹的存在
			b=file.createNewFile();								//以当前file的文件目录创建一个文件
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			File file2=file.createTempFile("haha", "txt",file);	//在file 表示的目录下创建一个名字为pre.dre的文件 最后一个参数可省略表示当前目录下
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		b=file.delete();
		b=file.exists();
		
		
		//------文件目录类
		String[] liStrings;
		liStrings=file.list();
		liStrings=file.list(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {		//使用过滤器  函数执行的过程中将会动态的调用这个方法 当返回true 的时候将会返回文件
				// TODO Auto-generated method stub
				return false;
			}
		});
		File[] files;
		files=file.listFiles(new FileFilter() {					//这个函数也可以使用上面的函数名称过滤器
			@Override	
			public boolean accept(File arg0) {
				// TODO Auto-generated method stub
				return false;
			}
		});
		//创建一个目录树
		file.mkdir();									//二者区别  --  下面的东西将会自动创建没有的父目录但是这个没有父目录将会报错
		file.mkdirs();											//创建 file中的整个目录 如果 file不存在的情况下
		file.renameTo(new File("hehe.txt"));					// 该名称-- 可以事项文件移动
		file.compareTo(file);				//按照抽象的字母顺序进行相关的比较
		file.delete();//删除空的文件夹或者目录
	}
}