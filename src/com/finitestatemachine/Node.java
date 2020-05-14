package com.finitestatemachine;

import java.util.ArrayList;

public abstract class Node {
    protected String name;

    public Node(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    };

    public abstract void addConnection(ArrayList<WeightedConnection> array) throws Exception;

    public abstract boolean isEndpoint();
    public abstract Node next(Double number);
    public abstract Node generateNetwork(Integer amountOfNodes) throws Exception;
}
