package org.example;

import org.example.bean.TestChildren;
import org.example.bean.TestParent;
import org.junit.Before;
import org.junit.Test;
import org.mirror.reflection.mirror.MirrorObject;

public class TestCaseMirrorObject {

    TestParent testParent;

    @Before
    public void initTest(){
        TestParent testParent = new TestParent();
        testParent.setCreateTime(System.currentTimeMillis());
        testParent.setItemP("this.testBase.itemP");


        TestChildren testChildrenC1 = new TestChildren();
        testChildrenC1.setAge(12);
        testChildrenC1.setName("c1");
        testChildrenC1.setCreateTime(System.currentTimeMillis());
        testParent.setItemP("this.testBase.c1");

        TestChildren testChildrenC2 = new TestChildren();
        testChildrenC2.setAge(12);
        testChildrenC2.setName("c1");
        testChildrenC2.setCreateTime(System.currentTimeMillis());
        testParent.setItemP("this.testBase.c2");

        TestChildren testChildrenC3 = new TestChildren();
        testChildrenC3.setAge(12);
        testChildrenC3.setName("c1");
        testChildrenC3.setCreateTime(System.currentTimeMillis());
        testParent.setItemP("this.testBase.3");

        TestChildren[] friend = new TestChildren[]{
                testChildrenC1,testChildrenC2,testChildrenC3
        };
        testChildrenC1.setFriend(friend);
        testChildrenC2.setFriend(friend);
        testChildrenC3.setFriend(friend);

        testParent.setChildren(friend);

        this.testParent = testParent;
    }

    @Test
    public void testMirror(){
        MirrorObject mirrorObject = MirrorObject.forObject(this.testParent);
        String[] setNames = mirrorObject.getSetterNames();
        System.out.println(setNames);
        String[] getNames = mirrorObject.getGetterNames();
        System.out.println(getNames);
    }
}
