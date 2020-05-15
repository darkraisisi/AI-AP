package com.finitestatemachine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Instantiate some basic things
        Scanner in = new Scanner(System.in);
        Random random = new Random();
        Double number = random.nextDouble();

        System.out.println("How many sides does your dice have(number)\n");
        int diceSides = Integer.parseInt(in.nextLine());


        try {
// Make a starting node
            Node dice = new WeightedNode("Start",false);
// Generate the amount of final dice heads that you desire
            dice.generateNetwork(new HashMap<String, HashMap<String, String>>(){{
                for (int i = 0; i < diceSides ; i++) {
                    put("d"+i,null);
                }
            }});
            System.out.println(dice);
// Get a randome final throw from the dice
            System.out.println(dice.next(number.toString()));

        }catch (Exception e){
            System.out.println(e);
        }

        try{
// Make a starting node
            TextNode startNode = new TextNode("s0");
// Generate a network based on the node names (with ability to keep a circular path by using the startNode as s0)
            startNode.generateNetwork(new HashMap<String, HashMap<String, String>>(){{
                put("s0",new HashMap<String, String>(){{
                    put("s1","b");
                    put("s2","a");
                }});
// Define the nodes and in them the connections("s1") and the corresponding keys("a")
                put("s1",new HashMap<String, String>(){{
                    put("s2","b");
                    put("s1","a");
                }});
                put("s2",new HashMap<String, String>(){{
                    put("s3","b");
                }});
                put("s3",new HashMap<String, String>(){{
                    put("s0","b");
                    put("s3","a");
                }});
            }});

            System.out.println(startNode);
            Node currentNode = startNode;
            currentNode = currentNode.next("a");
            currentNode = currentNode.next("b");
            System.out.println(currentNode);
        }catch (Exception e){
            System.out.println(e);
        }

    }
}
