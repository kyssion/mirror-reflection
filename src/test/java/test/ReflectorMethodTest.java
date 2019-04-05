package test;


import org.prims.reflection.meta.MetaObject;

public class ReflectorMethodTest {
    public static void main(String[] args) {
        new ReflectorMethodTest().test1();
    }

    public void test1(){

        ItemTestC itemTestC = new ItemTestC();
        itemTestC.setC(true);
        itemTestC.setAgeB(4433);
        itemTestC.setNameB("this is test 345");
        MetaObject metaObject2 = MetaObject.forObject(itemTestC);

        System.out.println(metaObject2.getValue("isC",Boolean.class));
    }
}
