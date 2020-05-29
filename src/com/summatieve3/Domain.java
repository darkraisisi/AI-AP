package com.summatieve3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Domain {
// Source https://www.baeldung.com/java-dijkstra
    Domain(String sourceName){
        this.sourceName = sourceName;
    }
    String sourceName;
    HashMap<String,Step> allNodes = new HashMap<>();

    public ArrayList<Step> dijkstra(){
        ArrayList<Step> settledSteps = new ArrayList<>();
        ArrayList<Step> unsettledSteps = new ArrayList<>();

        PriorityQueue<Step> route = new PriorityQueue<>();

        unsettledSteps.add(allNodes.get(sourceName));
        while (unsettledSteps.size() > 0) {
            Step currentStep = unsettledSteps.get(0);
            for(Map.Entry<String,Integer> conn: currentStep.connections.entrySet()) {
                System.out.println(conn);
                Integer edgeWeight = conn.getValue();
                if (!settledSteps.contains(allNodes.get(conn.getKey()))) {
//                    calculateMinimumDistance(adjacentNode, edgeWeight, currentNode);
                    unsettledSteps.add(allNodes.get(conn.getKey()));
                }
            };
            settledSteps.add(currentStep);
            unsettledSteps.remove(0);
        }
        return settledSteps;
    }

    public void addNodes(ArrayList<Step> list){
        for(Step step: list){
            this.allNodes.put(step.getName(),step);
        }
    }

    public void addNode(Step step){
        this.allNodes.put(step.getName(),step);
    }

    @Override
    public String toString() {
        return "Map{" +
                "allNodes=" + allNodes +
                '}';
    }
}
