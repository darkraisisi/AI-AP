package com.finitestatemachine;

public class TextConnection extends Connection{
    String key;
    TextNode node;

    TextConnection(String key, TextNode node){
        this.key = key;
        this.node = node;
    }

    @Override
    public String toString() {
        return "TextConnection{" +
                "key=" + this.key +
                ", node=" + this.node.getName() +
                '}';
    }
}
