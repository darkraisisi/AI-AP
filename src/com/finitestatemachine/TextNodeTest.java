package com.finitestatemachine;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

class TextNodeTest {

    @org.junit.jupiter.api.Test
    public void testNode() {
        Node node = new TextNode("Text");
        assertEquals("Text",node.getName());
    }

    @org.junit.jupiter.api.Test
    void testAddConnection() throws Exception {
        TextNode node = new TextNode("Text");
        node.addConnection(new ArrayList<TextConnection>(){{
            add(0,new TextConnection("a",node));
        }});

        assertEquals(new ArrayList<TextConnection>(){{
            add(0,new TextConnection("a",node));
        }}.toString(),node.connections.toString());
    }

    @org.junit.jupiter.api.Test
    void testNext() throws Exception {
        TextNode second = new TextNode("Final");
        TextNode node = new TextNode("Text");

        node.addConnection(new ArrayList<TextConnection>(){{
            add(0,new TextConnection("a",node));
            add(0,new TextConnection("b",second));
        }});
        assertEquals(node,node.next("a").next("a").next("a"));
        assertEquals(second,node.next("b"));
    }
}