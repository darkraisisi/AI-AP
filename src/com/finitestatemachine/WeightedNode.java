package com.finitestatemachine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class WeightedNode extends Node {
    private HashMap<Double, WeightedNode> connections = new HashMap<>();
    private boolean endpoint;

    WeightedNode(String name, boolean endpoint){
        super(name);
        this.endpoint = endpoint;
    }

    @Override
    public void addConnection(ArrayList<WeightedConnection> array) throws Exception {
        double tempTotal = 0;
        for ( WeightedConnection connection:array) {
            tempTotal += connection.weight;
            this.connections.put(tempTotal,connection.node);
        }
        if(!(tempTotal == 1 || tempTotal == 0.9999999999999999)){
            System.out.println(tempTotal);
            throw new Exception("TotalNodeweights is not equal to 1");
        }
    }

    @Override
    public boolean isEndpoint() {
        return this.endpoint;
    }

    @Override
    public WeightedNode next(Double number) {
        WeightedNode n = null;
        for (Map.Entry<Double, WeightedNode> connection : this.connections.entrySet()) {
            n = connection.getValue();
            if(number <= connection.getKey()){
                return connection.getValue();
            }
        }
        return n;
    }

    @Override
    public Node generateNetwork(Integer amountOfNodes) throws Exception {
        Double weight = 1.0 / amountOfNodes;
        ArrayList<WeightedConnection> connections = new ArrayList<>();

        for (int i = 1; i <= amountOfNodes; i++) {
            WeightedNode node = new WeightedNode(Integer.toString(i),true);
            connections.add(new WeightedConnection(weight,node));
        }
        this.addConnection(connections);
        return this;
    }



    @Override
    public String toString() {
        return "WeightedNode{" +
                "connections=" + connections +
                ", name=" + name +
                ", endpoint=" + endpoint +
                '}';
    }
}
