package com.company;

public class Bug implements Animal{
    boolean benefitial;
    boolean pest;

    public Bug(String name, boolean benefitial, boolean pest){
        this.benefitial = benefitial;
        this.pest = pest;
    }

    @Override
    public void settle() {

    }

    @Override
    public double eat(Double avaiableNutrients) {
        return avaiableNutrients - 0.01;
    }

    @Override
    public void die() {
//        how do you uninstantiate a java class?
    }

    @Override
    public String toString() {
       return "Bug{" +
                    "Name" + this.name +
                   ", pest=" + this.pest +
                    ", benefitial=" + this.benefitial +
                    ", kingdome=" + this.kingdome +
                    ", age=" + this.age +
                    ", gender=" + this.gender +
                    ", flying=" + this.flying +
                    '}';
    }
}
