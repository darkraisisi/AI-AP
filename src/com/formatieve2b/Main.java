package com.formatieve2b;

import jdk.internal.util.xml.impl.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Declare some workers
        Random random = new Random();
        Scanner in = new Scanner(System.in);

//        Looping mechanism to run as many throws in one run
        System.out.println("Please type the amount in of times you want to throw the dice");
        Integer loops = Integer.parseInt(in.nextLine());
        Integer i = 0;

//        Define all the base nodes
        Node n0 = new Node("0",false);
        Node n1 = new Node("1",false);
        Node n2 = new Node("2",false);
        Node n3 = new Node("3",false);
        Node n4 = new Node("4",false);
        Node n5 = new Node("5",false);
        Node n6 = new Node("6",false);

// Define all the endpoints
        Node d1 = new Node("Dice:1",true);
        Node d2 = new Node("Dice:2",true);
        Node d3 = new Node("Dice:3",true);
        Node d4 = new Node("Dice:4",true);
        Node d5 = new Node("Dice:5",true);
        Node d6 = new Node("Dice:6",true);

        Node currentNode;

//        A map to remember the amount thrown a specific dice
        HashMap<String,Integer> hits = new HashMap<String,Integer>(){{
            put(d1.getName(),0);
            put(d2.getName(),0);
            put(d3.getName(),0);
            put(d4.getName(),0);
            put(d5.getName(),0);
            put(d6.getName(),0);
        }};

        try {
//            add all the connections to the nodes
            n0.addConnection(new ArrayList<WeightedConnection>(){{
                add(new WeightedConnection(0.5,n1));
                add(new WeightedConnection(0.5,n2));
            }} );

            n1.addConnection(new ArrayList<WeightedConnection>(){{
                add(new WeightedConnection(0.5,n3));
                add(new WeightedConnection(0.5,n4));
            }} );

            n2.addConnection(new ArrayList<WeightedConnection>(){{
                add(new WeightedConnection(0.5,n5));
                add(new WeightedConnection(0.5,n6));
            }} );

            n3.addConnection(new ArrayList<WeightedConnection>(){{
                add(new WeightedConnection(0.5,d1));
                add(new WeightedConnection(0.5,n1));
            }} );

            n4.addConnection(new ArrayList<WeightedConnection>(){{
                add(new WeightedConnection(0.5,d2));
                add(new WeightedConnection(0.5,d3));
            }} );

            n5.addConnection(new ArrayList<WeightedConnection>(){{
                add(new WeightedConnection(0.5,d4));
                add(new WeightedConnection(0.5,d5));
            }} );

            n6.addConnection(new ArrayList<WeightedConnection>(){{
                add(new WeightedConnection(0.5,n2));
                add(new WeightedConnection(0.4,d6));
            }} );
        }catch (Exception ex){
//            There is a possibility the total weight is not equal to 1 return an error
            System.out.println(ex);
        }

        while(loops > i){
            currentNode = n0;
//            Try a path until you reach an end node
            while(!currentNode.isEndpoint()){
                Double number = random.nextDouble();
                currentNode = currentNode.next(number);
                if (currentNode.isEndpoint()){
//              If an endpoint has been reached print the loopnumber and add it to the hits map
                    System.out.println(i+1);
                    hits.put(currentNode.getName(),hits.get(currentNode.getName())+1);
                }
            }
            i+=1;
        }
//Show the final result
        System.out.println(hits.toString());
    }
}
