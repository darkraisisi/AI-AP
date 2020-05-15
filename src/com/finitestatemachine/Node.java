package com.finitestatemachine;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Node {
//    abstract class to help handle the 2 different type of nodes
    protected String name;

    public Node(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    };

    public abstract boolean isEndpoint();
    public abstract Node next(String number);
    public abstract void generateNetwork(HashMap<String,HashMap<String,String>> connectionMap) throws Exception;
}
