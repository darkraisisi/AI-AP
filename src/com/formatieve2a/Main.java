package com.formatieve2a;

import com.sun.deploy.net.MessageHeader;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<String> visited = new ArrayList<>();
    private static boolean running = true;

    public static void appendName(Node node){
        visited.add(node.getStateName());
    }

    public static void quit(){
        System.out.println(visited.toString());
        running = false;
    }

    public static void main(String[] args) {
//    finite state machine, machine with text input
        Node s0 = new Node("s0");
        Node s1 = new Node("s1");
        Node s2 = new Node("s2");
        Node s3 = new Node("s3");
        Node current = s0;
        appendName(current);

        s0.setConA(s2);
        s0.setConB(s1);

        s1.setConA(s1);
        s1.setConB(s2);

        s2.setConB(s3);

        s3.setConA(s3);
        s3.setConB(s0);

        Scanner in = new Scanner(System.in);
        while (running){
            System.out.println("\nType A/B\n(quit):");
            String input = in.nextLine().toUpperCase();
            Node newNode;
            switch (input){
                case "A":
                    System.out.println("Case A:"+input);
                    newNode = current.getA();
                    if(newNode != null){
                        appendName(newNode);
                    }else{
                        System.out.println("\n Invalid connection beeing called,"+current.getStateName()+" does not have a connection called:"+input);
                        quit();
                    }
                    current = newNode;
                    break;
                case "B":
                    System.out.println("Case B:"+input);
                    newNode = current.getB();
                    if(newNode != null){
                        appendName(newNode);
                    }else{
                        System.out.println("\n Invalid connection beeing called,"+current.getStateName()+" does not have a connection called:"+input);
                        quit();
                    }
                    current = newNode;
                    break;
                case "QUIT":
                    quit();
                    break;
                default:
                    System.out.println("Input a valid option");
            }
        }
    }


}
