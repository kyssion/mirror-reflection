package test;

public class ItemBean {
    private String name;
    private int age ;

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

    public ItemTestB testC(ItemTestB c){
        c.testB(123,"2333");
        System.out.println("this is itemTest");
        return c;
    }
}
