package com.finitestatemachine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TextNode extends Node{
    public ArrayList<TextConnection> connections = new ArrayList<>();

    public TextNode(String name) {
        super(name);
    }

    public void addConnection(ArrayList<TextConnection> array) throws Exception {
//        Add all connections to the current node
        for ( TextConnection input:array) {
            this.connections.add(input);
        }
    }

    @Override
    public boolean isEndpoint() {
        return false;
    }

    @Override
    public Node next(String input) {
//        check if the current input matches one of the keys if so return the new node
        for ( TextConnection connection:this.connections) {
            if (connection.key == input){
                return connection.node;
            }
        }
        return null;
    }

    @Override
    public void generateNetwork(HashMap<String,HashMap<String,String>> connectionMap) throws Exception {
        HashMap<String,TextNode> allNodes = new HashMap<>();
// Generate all the initial needed nodes
        for (Map.Entry<String,HashMap<String,String>> node : connectionMap.entrySet()) {
// dont make a new node that is already defined somewhere else, this is necessary for the way connection generation is done
            if (node.getKey() == this.name){
                allNodes.put(this.name,this);
            }else{
                allNodes.put(node.getKey(),new TextNode(node.getKey()));
            }
        }
// Go through the the nodes again and add the connections needed.
        for (Map.Entry<String,HashMap<String,String>> node : connectionMap.entrySet()) {
// Select one of the now instantiated nodes and make an empty connection list
            TextNode nodeToConnect = allNodes.get(node.getKey());
            ArrayList<TextConnection> connections = new ArrayList<>();

            for ( Map.Entry<String,String> connection : node.getValue().entrySet()) {
// get all the node names from the input list and the 'key' values for function next(),
// add them to connections and call add connections on a different node
                connections.add(new TextConnection(connection.getValue(),allNodes.get(connection.getKey())));
            }
            nodeToConnect.addConnection(connections);
        }

    }

    @Override
    public String toString() {
        return "TextNode{" +
                "connections=" + connections +
                ", name=" + name +
                '}';
    }
}
