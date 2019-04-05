package test;


import org.prims.reflection.meta.MetaObject;

import java.util.HashMap;
import java.util.Map;

public class RouterTest {
    public static void main(String[] args) {
        Supper base = new Supper();
        base.setIsup(false);
        base.setNumber(123);
        Test test = new Test();
        test.setSupper(base);
        TestTTT testTTT = new TestTTT();
        testTTT.setTest(test);
        MetaObject metaObject = MetaObject.forObject(testTTT);
        String[] name = metaObject.getGetterNames();
        for (String string : name) {
            System.out.println(string);
        }
        Number number = metaObject.getValue("test.supper.number", Number.class);
        System.out.println(number);
        Object one = new String("123");
        Object two = new String("333");
        Map<Class<?>,Object> classObjectMap = new HashMap<>();
        classObjectMap.put(one.getClass(),one);
        classObjectMap.put(two.getClass(),two);
        System.out.println(classObjectMap.size());
        System.out.println(classObjectMap.get(one.getClass()));
        System.out.println(one.getClass()==String.class);
    }
}

class Base {
    private Number number;
    private boolean isup;

    public boolean isIsup() {
        return isup;
    }

    public void setIsup(boolean isup) {
        this.isup = isup;
    }

    public Number getNumber() {
        return number;
    }

    public void setNumber(Number number) {
        this.number = number;
    }
}

class Supper extends Base {
    public Integer getNumber() {
        return (Integer) super.getNumber();
    }
}

class Test {
    private Supper supper;

    public Supper getSupper() {
        return supper;
    }

    public void setSupper(Supper supper) {
        this.supper = supper;
    }
}

class TestTTT {
    private Test test;

    private String hhh;

    public String getHhh() {
        return hhh;
    }

    public void setHhh(String hhh) {
        this.hhh = hhh;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }
}