package org.example;

import org.example.bean.ConEnum;
import org.example.bean.GoodsPeople;
import org.example.bean.People;
import org.mirror.reflection.DefaultReflectorFactory;
import org.mirror.reflection.Reflector;
import org.mirror.reflection.mirror.MirrorClass;
import org.mirror.reflection.mirror.MirrorObject;

import java.lang.reflect.InvocationTargetException;

public class Example1 {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        People one = new People();
        one.setAge(12);
        one.setName("one");
        one.setOtherPeopleThingk("bad one");

        People two = new People();
        two.setAge(13);
        two.setName("two");
        two.setOtherPeopleThingk("goods one");

        GoodsPeople goodsPeople = new GoodsPeople();
        goodsPeople.setContury(ConEnum.CHINA);
        goodsPeople.setHelpPeopleNumber(1000);
        goodsPeople.setMoney(123432.22);
        goodsPeople.setFrinds(new People[]{one, two});

//        Reflector reflector = new Reflector(goodsPeople.getClass());
//        Agent agent = reflector.getGetAgent("money");
//        Agent agent1 = reflector.getMethod("whatDoYouThink").get(0);
//        System.out.println(agent.invoke(goodsPeople, null));
//        System.out.println(agent1.invoke(goodsPeople, one));

        Reflector reflector = new DefaultReflectorFactory().findForClass(People.class);
    }
}


