package c_java设计模式.d_factory模式.抽象工厂和抽象实例;

import c_java设计模式.d_factory模式.接口实现类.IDCard;

public abstract class Factory {
	public final Product create(String string){
		//可以方便在生成的时候对它进行处理
		Product product = createProduct(string);
		registerProduct(product);
		return product;
	}
	protected abstract Product createProduct(String own);
	protected abstract void registerProduct(Product product);
}
