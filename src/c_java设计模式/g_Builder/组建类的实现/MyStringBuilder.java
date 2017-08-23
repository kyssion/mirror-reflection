package c_java设计模式.g_Builder.组建类的实现;

import c_java设计模式.g_Builder.抽象类声明组件.Builder;

public class MyStringBuilder extends Builder{
	private StringBuffer stringbuffer=new StringBuffer();
	@Override
	public void makeTitile(String title) {
		// TODO Auto-generated method stub
		stringbuffer.append("--------------------------\n");
		stringbuffer.append("<<"+title+">>\n");
		stringbuffer.append("\n");
	}

	@Override
	public void makeString(String str) {
		// TODO Auto-generated method stub
		stringbuffer.append("*"+str+"\n");
		stringbuffer.append("\n");
	}

	@Override
	public void makeItem(String[] items) {
		// TODO Auto-generated method stub
		for (int i=0;i<items.length;i++){
			stringbuffer.append("**"+items[i]+"\n");
		}
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		stringbuffer.append("=====================\n");
	}
	@Override
	//返回拼装好的组件
	public String getResult(){
		return stringbuffer.toString();
	}
}
