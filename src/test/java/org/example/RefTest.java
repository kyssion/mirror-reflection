package org.example;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;

public class RefTest {
    public static void main(String[] args) throws NoSuchFieldException {
        RefItem<String, Number> refItem = new RefItem<>("test", 123,new ArrayList<>());
        Type type = refItem.getClass().getComponentType();
        //返回当前类的内部类的类型如果是匿名内部类,就无效比如new xxx 然后在这个类中使用this.getClass
        Type type1 = refItem.getClass().getDeclaringClass();
        //同上面的方法,只不过这个方法可以在匿名内部类中获取到对应的包装类
        Type type2 = refItem.getClass().getEnclosingClass();

        Type type3 = refItem.getClass().getGenericSuperclass();

        Type type4 = refItem.getClass().getSuperclass();

        Class<?> refItemClass = refItem.getClass();

        Type[] type5 = refItem.getClass().getGenericInterfaces();

        Field field = refItemClass.getDeclaredField("list");

        Type type7 = field.getDeclaringClass();
        Type type8 = field.getType();
        List<String> list = refItem.getList();
        Type type6 = list.getClass();
        if (type6 instanceof TypeVariable) {
            System.out.println("1");
        } else if (type6 instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type6;
            Type[] types = parameterizedType.getActualTypeArguments();
            System.out.println(types);
         } else if (type6 instanceof GenericArrayType) {
            System.out.println(3);
        } else {

            System.out.println(4);
        }
    }
}

class Test {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class RefItem<T, S> {
    private T ttt;
    private S s;
    private List<T> list;
    RefItem(T ttt, S s,List<T> list) {
        this.ttt = ttt;
        this.s = s;
        this.list = list;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public void setTtt(T ttt) {
        this.ttt = ttt;
    }

    public T getTtt() {
        return ttt;
    }

    public S getS() {
        return s;
    }

    public void setS(S s) {
        this.s = s;
    }
}
