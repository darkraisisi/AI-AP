package com.finitestatemachine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class WeightedNode extends Node {
    public HashMap<Double, WeightedNode> connections = new HashMap<>();
    public boolean endpoint;

    WeightedNode(String name, boolean endpoint){
        super(name);
        this.endpoint = endpoint;
    }
//get an array of weighted connections and asses the weights, add the weights to a total and store them in order for easy checking
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
    public WeightedNode next(String _number) {
        Double number = Double.valueOf(_number);
        WeightedNode n = null;
        // go through all the connections in order of key size(amount of chance)
        for (Map.Entry<Double, WeightedNode> connection : this.connections.entrySet()) {
            n = connection.getValue();
// if the current value is lower then the key in question, attatched node is corrosponding chance
            if(number <= connection.getKey()){
                return connection.getValue();
            }
        }
        return n;
    }

    @Override
    public void generateNetwork(HashMap<String,HashMap<String,String>> connectionMap) throws Exception {
//Put a networktogether by looking connecting all the needed nodes to this current node
        Double weight = 1.0 / connectionMap.size();
//The hashmap is a limitation of using the abstractsuperclass, get the size from it(the amount of needed new nodes)
        ArrayList<WeightedConnection> connections = new ArrayList<>();
        for (Map.Entry<String,HashMap<String,String>> _node : connectionMap.entrySet()) {
//            run through the names and weights given in the call and assign them to a WeightedConnection and put those in an array for this.addConneciton
            WeightedNode node = new WeightedNode(_node.getKey(),true);
            connections.add(new WeightedConnection(weight,node));
        }
        this.addConnection(connections);
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
