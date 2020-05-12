package com.formatieve2b;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Node {
    private String name;
    private Boolean endpoint;
    private HashMap<Double,Node> connections = new HashMap<>();

    public Node(String name,Boolean endpoint){
        this.name = name;
        this.endpoint = endpoint;
    }

    public void addConnection(ArrayList<WeightedConnection> array) throws Exception {
        double tempTotal = 0;
        for ( WeightedConnection connection:array) {
            tempTotal += connection.weight;
            this.connections.put(tempTotal,connection.node);
        }
        if(tempTotal != 1){
            throw new Exception("TotalNodeweights is not equal to 1");
        }

    }

    public String getName() {
        return this.name;
    }

    public boolean isEndpoint() {
        return this.endpoint;
    }

    @Override
    public String toString() {
        return "Node{" +
                "name='" + name + '\'' +
                ", endpoint=" + endpoint +
                ", connections=" + connections +
                '}';
    }

    public Node next(Double number) {
        Node n = null;
        for (Map.Entry<Double,Node> connection : this.connections.entrySet()) {
            n = connection.getValue();
            if(number <= connection.getKey()){
                return connection.getValue();
            }
        }
        return n;
    }
}
