package org.example;


import org.mirror.reflection.Reflector;
import org.mirror.reflection.mirror.MirrorClass;

import java.lang.annotation.*;

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@interface Test{
    public String id();
}

class Testddd{

}
@Test(id="123")
class Testddd2 extends Testddd{

}

public class Example1 {
    public static void main(String[] args){
        Testddd testddd2 = new Testddd2();
        Reflector reflector = new Reflector(testddd2.getClass());
        MirrorClass mirrorClass = MirrorClass.forClass(testddd2.getClass());
        Test test = reflector.getAnnotation(Test.class);
        Test test1 = mirrorClass.getAnnotation(Test.class);
        System.out.println(test.id());
        System.out.println(test1.id());
    }
}