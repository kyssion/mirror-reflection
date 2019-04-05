package test;

public class ItemTestC extends ItemTestB{

    private boolean isC;

    public boolean isC() {
        return isC;
    }

    public void setC(boolean c) {
        isC = c;
    }

    public ItemTestB testB(int aaa,String bbb){
        System.out.println(aaa+""+bbb);
        return new ItemTestB();
    }

    public ItemTestB testB(int aaa,String bbb,double iii){
        System.out.println(aaa+""+bbb+""+iii);
        return new ItemTestB();
    }


}
