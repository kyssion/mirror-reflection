package org.example;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Type;
import java.util.List;

public class Test3 {
    public static void main(String[] args) throws NoSuchMethodException {
        Class t = HTest.class;
        Method getList = t.getDeclaredMethod("getList",new Class[]{List.class});
        Class<?>[] param = getList.getParameterTypes();
        Type[] paramType = getList.getGenericParameterTypes();
        Parameter[] parameter = getList.getParameters();
    }
}
class HTest{
    private String name;

    public String getList(List<String> name){
        return this.name;
    }
}
