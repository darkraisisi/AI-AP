package com.formatieve2b;

public class WeightedConnection {
    Double weight;
    Node node;

    WeightedConnection(Double weight,Node node){
        this.weight = weight;
        this.node = node;
    }

    @Override
    public String toString() {
        return "WeightedConnection{" +
                "weight=" + weight +
                ", node=" + node.getName() +
                '}';
    }
}
