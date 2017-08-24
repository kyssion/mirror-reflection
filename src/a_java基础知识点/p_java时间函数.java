package a_java基础知识点;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.Format;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class p_java时间函数 {
	public static void main(String[] args) {
		Date date = new Date();
		date.getTime();
		//比较时间
		date.before(new Date());
		date.after(new Date());
		date.getTime();//返回毫秒数
		
		//date一般和simpleDateFormat连用
		
		Calendar calendar =Calendar.getInstance();//获取当前的系统时间
		calendar.add(Calendar.YEAR, 1000);//设置calendar的时间变量
		calendar.getTimeInMillis();//获得毫秒
		calendar.get(Calendar.AM_PM);//获得指定时刻的类型
		calendar.getActualMaximum(Calendar.YEAR);//获得到指定时刻的毫秒数
		calendar.compareTo(calendar);//返回相差毫秒数
		calendar.before(calendar);
		calendar.after(calendar);
		
		
	}
}
class A extends Format{

	@Override
	public StringBuffer format(Object obj, StringBuffer toAppendTo, FieldPosition pos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object parseObject(String source, ParsePosition pos) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
class B extends DateFormat{

	@Override
	public StringBuffer format(Date date, StringBuffer toAppendTo, FieldPosition fieldPosition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Date parse(String source, ParsePosition pos) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
class C extends SimpleDateFormat{

	@Override
	public StringBuffer format(Date date, StringBuffer toAppendTo, FieldPosition pos) {
		// TODO Auto-generated method stub
		return super.format(date, toAppendTo, pos);
	}

	@Override
	public Date parse(String text, ParsePosition pos) {
		// TODO Auto-generated method stub
		return super.parse(text, pos);
	}
//字符基本格式
//yyyy：年
//MM：月
//dd：日
//hh：1~12小时制(1-12)
//HH：24小时制(0-23)
//mm：分
//ss：秒
//S：毫秒
//E：星期几
//D：一年中的第几天
//F：一月中的第几个星期(会把这个月总共过的天数除以7)
//w：一年中的第几个星期
//W：一月中的第几星期(会根据实际情况来算)
//a：上下午标识
//k：和HH差不多，表示一天24小时制(1-24)。
//K：和hh差不多，表示一天12小时制(0-11)。
//z：表示时区  
	
}
