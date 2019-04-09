package org.example;

import org.mirror.reflection.mirror.MirrorObject;

public class ArrTest {
    public static void main(String[] args) {

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
