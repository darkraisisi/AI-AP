package com.summatieve3;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Flight A = new Flight("A",0.1);
        Flight B = new Flight("B",0.1);
        Flight C = new Flight("C",0.1);
        Flight D = new Flight("D",0.1);
        Flight E = new Flight("E",0.1);
        Flight F = new Flight("F",0.1);

        A.addConnections(B,1000);
        A.addConnections(C,1500);
        B.addConnections(D,1200);
        B.addConnections(F,1500);
        C.addConnections(E,1000);
        D.addConnections(E,200);
        D.addConnections(F,100);
        F.addConnections(E,500);

        Domain myMap = new Domain("A");

        myMap.addNode(A);
        myMap.addNode(B);
        myMap.addNode(C);
        myMap.addNode(D);
        myMap.addNode(E);
        myMap.addNode(F);

        System.out.println(myMap);

        ArrayList<Step>  ret = myMap.dijkstra();

        System.out.println(ret);

//        int distance = A.getDistance();
//        System.out.println(distance);
//        Map myMap = new Map();
//        myMap.dijkstra()
    }
}
