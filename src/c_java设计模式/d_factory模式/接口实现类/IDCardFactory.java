package c_java设计模式.d_factory模式.接口实现类;

import java.util.ArrayList;
import java.util.List;

import c_java设计模式.d_factory模式.抽象工厂和抽象实例.Factory;
import c_java设计模式.d_factory模式.抽象工厂和抽象实例.Product;

public class IDCardFactory extends Factory{
	List<Product> productlist= new ArrayList<>();
	@Override
	protected Product createProduct(String own) {
		// TODO Auto-generated method stub
		return new IDCard(own);
	}

	@Override
	protected void registerProduct(Product product) {
		// TODO Auto-generated method stub
		productlist.add(product);
		
	}

}
