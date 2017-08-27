package b_面向对象;

//内部类
public class e_内部类 {
	public static void main(String[] arg) {
		Inclass.myMain(arg);
	}
}

class Inclass {
	private String name = "hehe";
	private int age = 123;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	// 在类中定义的类就是内部类 声明可以是 public的等权限 其实就相当于一个 变量而已
	// 类名可以声明位static
	// 其实当内部类加上一个 static的时候就已将相当于一个独立的类了 没有staic 的时候相当与一个功能强大的变量而已
	// 但是注意 内部类声明位 static的时候就不能调用父类的非 static方法和参数了
	class thisIs implements hhe {// 可以继承接口或者相关的继承类
		// 使用内部类最吸引人的原因是：每个内部类都能独立地继承一个（接口的）实现，
		// 所以无论外围类是否已经继承了某个（接口的）实现，对于内部类都没有影响。
		// 接口只是解决了部分问题，而内部类使得多重继承的解决方案变得更加完整。
		// 1、内部类可以用多个实例，每个实例都有自己的状态信息，并且与其他外围对象的信息相互独立。
		// 2、在单个外围类中，可以让多个内部类以不同的方式实现同一个接口，或者继承同一个类。
		// 3、创建内部类对象的时刻并不依赖于外围类对象的创建。
		// 4、内部类并没有令人迷惑的“is-a”关系，他就是一个独立的实体。
		// 5、内部类提供了更好的封装，除了该外围类，其他类都不能访问。
		private String name;
		// 参数也能声明 static 但是在内部类不是static的时候必须是常量是static finial == 常量 因为常量是可以直接进行访问的但是对内部类来说如果父类没有加上static 内部类就
		// static private final int age=12;
		private int age = 112;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public thisIs() {
			// TODO Auto-generated constructor stub
			this.name = "zhahzah";
			this.age = 222;
		}

		// 方法可以声明为 static 但是要求内部类是 static(权限的嵌套问题)
		// 原因 内部类方法使用static 是没有意义的 当外部的类是 内部类生成只能需要外部类的实例 当外部类生成实例的时候 不必要使用类名了
		public void say() {
			// 内部类的参数作用域和继承类似 参数都是从内部进行查找如果找到了就进行执行 内部类可以访问外部类的所有变量
			System.out.println("name:" + this.getName() + "   age:" + this.getAge());
			// 通过作用域的显示声明改变可以动态的使用外部或者内部的方法
			System.out.println("name:" + Inclass.this.getName() + "   age:" + Inclass.this.getAge());
		}

		@Override
		public void hehe() {
			// TODO Auto-generated method stub
		}
	}

	@SuppressWarnings("unused")
	public static void myMain(String[] age) {
		Inclass inclass = new Inclass();
		// 成员内部类是依附于外围类的，所以只有先创建了外围类才能够创建内部类。
		Inclass.thisIs mythis = inclass.new thisIs();
		// 当内部类声明位static的时候就能使用这个方法了
		// Inclass.thisIs mythis= new Inclass.thisIs();//静态方法通过类名访问变量
		if (12 > 14) {
			class Inmathod {
				// 内部类还可以方法 方法或者成员函数中使用
				public void pepe() {
					pepe();
				}
			}
			Inmathod i = new Inmathod();
			i.pepe();
		}
		// 注意了在static 方法中调用的方法一定是 static类型
		gogo(inclass.new thisIs() {
			// 使用匿名内部类的时候外部变量必须使用 final进行定义--因为生成的范围不同
			// 使用匿名内部类的时候相当于次匿名类实行了继承(接口,类,或者抽象类)
			// 匿名内部类只是为了动态的生成一个可以运行的类而已 所以不能也没必要重写构造函数 匿名内部类中不能存在任何的静态成员变量和静态方法。
			// 匿名内部类为局部内部类，所以局部内部类的所有限制同样对匿名内部类生效。
		});
		mythis.say();
		Object oo=new hhe() {//相当于先继承或者实现接口然后进行相关的数据使用
			
			@Override
			public void hehe() {
				// TODO Auto-generated method stub
				
			}
		};
	}

	// 注意在使用内部类的时候要注意将 包含类也加上--作用域的问题 本程序不用
	public static void gogo(Inclass.thisIs heh) {
	}
}

interface hhe {
	public void hehe();
}
