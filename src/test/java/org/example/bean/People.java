package org.example.bean;

public class People {
    String name;
    int age;
    People[] frinds;
    String otherPeopleThingk;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public People[] getFrinds() {
        return frinds;
    }

    public void setFrinds(People[] frinds) {
        this.frinds = frinds;
    }

    public String getOtherPeopleThingk() {
        return otherPeopleThingk;
    }

    public void setOtherPeopleThingk(String otherPeopleThingk) {
        this.otherPeopleThingk = otherPeopleThingk;
    }

    public void doSay() {
        System.out.println("my name is " + this.name + " : my age is" + this.age);
    }

    public String whatDoYouThink(People people) {
        for (People people1 : this.frinds) {
            if (people.getName().equals(people1.getName())) {
                return people1.getOtherPeopleThingk();
            }
        }
        return "I don't no the people";
    }
}
