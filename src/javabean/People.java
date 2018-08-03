package javabean;

import java.util.Date;

import com.google.gson.annotations.SerializedName;

public class People {
	//注解变换名称
	//@SerializedName("haha")
	private String name;
	private String id;
	private String[] friend;//json 可以键入数组
	private Date date;
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String[] getFriend() {
		return friend;
	}
	public void setFriend(String[] friend) {
		this.friend = friend;
	}
	//transient 表示json生成的时候忽略 这个属性
	private transient String ingore;
	public String getIngore() {
		return ingore;
	}
	public void setIngore(String ingore) {
		this.ingore = ingore;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
}
