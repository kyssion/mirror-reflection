package c_java设计模式.f_prototype模式.b_调用复制的类;

import java.util.HashMap;

import c_java设计模式.f_prototype模式.a_接口.Product;


public class Manager {
	private static HashMap<String, Product> hashMap = new HashMap<>();
	public static void register(String name,Product product){
		hashMap.put(name, product);
	}
	public static Product create(String name){
		Product product =  hashMap.get(name);
		return product.createClone();
	}
}
