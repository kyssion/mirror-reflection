package test;


import com.kyssion.mirror.reflection.mirror.MirrorObject;

public class ReflectorMethodTest {
    public static void main(String[] args) {
        new ReflectorMethodTest().test1();
    }


    public void test1(){

        ItemTestC itemTestC = new ItemTestC();
        itemTestC.setC(true);
        itemTestC.setAgeB(4433);
        itemTestC.setNameB("this is test 345");
        MirrorObject mirrorObject = MirrorObject.forObject(itemTestC);

        System.out.println(mirrorObject.getValue("isC",Boolean.class));
        System.out.println(mirrorObject.invoke("testB",ItemTestB.class,123,"dddd",123.92));
    }
}
