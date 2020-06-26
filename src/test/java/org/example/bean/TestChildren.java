package org.example.bean;

public class TestChildren extends TestBase{
    private String name;
    private Integer age;
    private TestChildren[] friend;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public TestChildren[] getFriend() {
        return friend;
    }

    public void setFriend(TestChildren[] friend) {
        this.friend = friend;
    }
}
