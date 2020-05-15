package com.finitestatemachine;
import com.finitestatemachine.WeightedNode;

public class WeightedConnection extends Connection{
    Double weight;
    WeightedNode node;

    WeightedConnection(Double weight, WeightedNode node){
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
