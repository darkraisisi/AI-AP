package com.finitestatemachine;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

class WeightedNodeTest {

    @org.junit.jupiter.api.Test
    public void testNode() {
        Node node = new WeightedNode("start",false);
        assertEquals("start",node.getName());
    }

    @org.junit.jupiter.api.Test
    void testAddConnection() throws Exception {
        WeightedNode node = new WeightedNode("start",false);
        node.addConnection(new ArrayList<WeightedConnection>(){{
            add(0,new WeightedConnection(0.5,node));
        }});

        assertEquals(new ArrayList<WeightedConnection>(){{
            add(0,new WeightedConnection(0.5,node));
        }}.toString(),node.connections.toString());
    }

    @org.junit.jupiter.api.Test
    void testNext() throws Exception {
        WeightedNode second = new WeightedNode("Final",true);
        WeightedNode node = new WeightedNode("start",false);

        node.addConnection(new ArrayList<WeightedConnection>(){{
            add(0,new WeightedConnection(0.5,node));
            add(0,new WeightedConnection(0.5,second));
        }});
        assertEquals(node,node.next("0.4").next("0.4"));
        assertEquals(second,node.next("0.4").next("0.4").next("0.5"));
    }
}