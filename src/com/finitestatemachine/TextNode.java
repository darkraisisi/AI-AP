package com.finitestatemachine;

import java.util.ArrayList;

public class TextNode extends Node{
    public TextNode(String name) {
        super(name);
    }

    @Override
    public void addConnection(ArrayList<WeightedConnection> array) throws Exception {

    }

    @Override
    public boolean isEndpoint() {
        return false;
    }

    @Override
    public Node next(Double number) {
        return null;
    }

    @Override
    public Node generateNetwork(Integer amountOfNodes) throws Exception {
        return null;
    }
}
