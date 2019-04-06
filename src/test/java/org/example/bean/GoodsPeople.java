package org.example.bean;

public class GoodsPeople extends People{
    Double money;
    int helpPeopleNumber;
    ConEnum contury;

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public int getHelpPeopleNumber() {
        return helpPeopleNumber;
    }

    public void setHelpPeopleNumber(int helpPeopleNumber) {
        this.helpPeopleNumber = helpPeopleNumber;
    }

    public ConEnum getContury() {
        return contury;
    }

    public void setContury(ConEnum contury) {
        this.contury = contury;
    }

    @Override
    public String whatDoYouThink(People people) {
        System.out.println("very goods");
        return super.whatDoYouThink(people);
    }
}
