package org.example;

import org.mirror.reflection.mirror.MirrorObject;

import java.util.HashMap;
import java.util.Map;

public class Test222 {
    public static void main(String[] args) {
        Ssss ssss = new Ssss();
        XXX xxx = new XXX();
        ssss.name = "123";
        Map<String, XXX> map = new HashMap<>();
        map.put("xxxxx", xxx);
        ssss.f = map;
        xxx.age = "222";
        MirrorObject mirrorObject = MirrorObject.forObject(ssss);
        System.out.println(mirrorObject.getValue("f[xxxxx].age", String.class));
        System.out.println(mirrorObject.invoke("f.[xxxxx].getMap", XXX.class, "sdfsdf").age);
    }
}

class Ssss {
    String name;
    Map<String, XXX> f;
}

class XXX {
    String age;

    public XXX getMap(String name) {
        System.out.println(name);
        return this;
    }
}