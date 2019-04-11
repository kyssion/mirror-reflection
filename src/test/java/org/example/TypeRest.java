package org.example;

import org.mirror.reflection.property.TypeParameterResolver;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class TypeRest {
    public static void main(String[] args) throws NoSuchMethodException {
        Class<?> itemClass = TypeRef.class;
        Method test1 = itemClass.getDeclaredMethod("test1",new Class[]{Object.class});
//        Method testList = itemClass.getMethod("testList",new Class[]{Object.class});
//        Method testArr = itemClass.getMethod("testArr",new Class[]{Object.class});

        Type test1Return = test1.getReturnType();
        Type type  = TypeParameterResolver.resolveReturnType(test1,test1Return);
    }
}

class TypeRef<T> {
    T test1(T t){
        return t;
    }

    List<T> testList(T t){
        List<T> list = new ArrayList<>();
        list.add(t);
        return list;
    }

    T[] testArr(T[] t){
        return t;
    }
}
