package com.summatieve3;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Step{
    public String name;
    public HashMap<String, Integer> connections = new HashMap<>();

    public Step(String name){
        this.name = name;
    }

    public abstract void addConnections(com.summatieve3.Step toAdd,Number number);

    public abstract int getDistance(com.summatieve3.Step step);

    public HashMap<String,Integer> getConnections(){
        return this.connections;
    }

    public String getName(){
        return this.name;
    }

    @Override
    public String toString() {
        return "Step{" +
                "name='" + name + '\'' +
                ", connections=" + connections +
                '}';
    }
}
