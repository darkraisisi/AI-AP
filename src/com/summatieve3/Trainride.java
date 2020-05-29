package com.summatieve3;

import java.util.ArrayList;

public class Trainride extends Step implements Comparable<Trainride> {
    public int minutes;
    public Trainride(String name, int minutes){
        super(name);
        this.minutes = minutes;
    }

    @Override
    public int compareTo(Trainride trainride) {
        if(trainride.equals(this)){
            return 0;
        }else if(trainride.minutes > trainride.minutes){
            return (int)(trainride.minutes - trainride.minutes);
        }else{
            return (int)(trainride.minutes - trainride.minutes);
        }
    }


    @Override
    public void addConnections(Step toAdd, Number number) {

    }

    @Override
    public int getDistance(Step step) {
        return 0;
    }
}
