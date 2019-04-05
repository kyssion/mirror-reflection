package test;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

public class ReflectorTest2 {
    public static void main(String[] args) throws NoSuchFieldException {
        ReflectorItem<String> reflectorItem =new ReflectorItem<>("sdf"){};
        ReflectorItem<String> reflectorItem2 =new ReflectorItem<>("sdf"){};
        ReflectorItem<String> reflectorItem3 =new ReflectorItem<>("sdf"){};
        ReflectorItem<String> reflectorItem4 =new ReflectorItem<>("sdf"){};
        reflectorItem.setItem("restset");
    }
}

class  ReflectorItem<T> {

    Type _type;

    ReflectorItem(T s){
        Type superClass = getClass().getGenericSuperclass();
        if (superClass instanceof Class<?>) { // sanity check, should never happen
            throw new IllegalArgumentException("Internal error: TypeReference constructed without actual type information");
        }
        _type = ((ParameterizedType) superClass).getActualTypeArguments()[0];
        TypeVariable<? extends Class<?>>[] typeParameters =s.getClass().getTypeParameters();
    }

    T item;

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }
}