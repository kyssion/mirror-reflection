package test;

public class ItemBeanA extends ItemBean {
    private String name;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public int ATtestMethod(String name,int aa){
        return 1+2;
    }

    public ItemTestB testC(ItemTestC c) {
        System.out.println("this is ccccc");
        return super.testC(c);
    }
}