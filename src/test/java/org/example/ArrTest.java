package org.example;

import org.mirror.reflection.mirror.MirrorObject;
import org.mirror.reflection.property.TypeParameterProcessor;

import java.lang.reflect.Method;
import java.lang.reflect.Type;

public class ArrTest {
    public static void main(String[] args) throws NoSuchMethodException {

        ItemArr itemArr = new ItemArr();
        Item[] items = new Item[10];
        for (int a=0;a<items.length;a++){
            items[a]=new Item(""+a+"name",""+a+"age");
        }
        itemArr.items=items;
        MirrorObject mirrorObject = MirrorObject.forObject(itemArr);
        System.out.println(mirrorObject.getValue("items[0]",Item.class).age);
        Class<?> i = items.getClass();
        System.out.println(i==Item.class);
        Class T = TestT.class;
        Method method = T.getDeclaredMethod("hhh",new Class[]{});

        Type type = TypeParameterProcessor.processorReturnType(method);
        Class ttt = (Class) type;

    }
}
class ItemArr{
    Item[] items;
}
class Item{
    String name;
    String age;
    public Item(String name,String age){
        this.name = name;
        this.age = age;
    }
}

class TestT{
    String hhh(){
        return "";
    }
}