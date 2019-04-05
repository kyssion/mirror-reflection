package test;

public class ItemTestB {
    private String nameB;
    private int ageB;

    public String getNameB() {
        return nameB;
    }

    public void setNameB(String nameB) {
        this.nameB = nameB;
    }

    public int getAgeB() {
        return ageB;
    }

    public void setAgeB(int ageB) {
        this.ageB = ageB;
    }

    public ItemTestB testB(int aaa,String bbb){
        System.out.println(aaa+""+bbb);
        return new ItemTestB();
    }
}
