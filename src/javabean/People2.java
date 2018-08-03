package javabean;

import java.util.Date;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class People2 {
	private String name;
	private String id;
	//面向接口编程
	private List<String> friend;
	public List<String> getFriend() {
		return friend;
	}
	public void setFriend(List<String> friend) {
		this.friend = friend;
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
