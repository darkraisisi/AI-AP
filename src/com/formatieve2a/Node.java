package com.formatieve2a;

public class Node {
    public String stateName;
    public Node A = null;
    public Node B = null;

    public Node(String stateName){
        this.stateName = stateName;
    }

    public String getStateName(){
        return this.stateName;
    }

    public void setConA(Node A){
        this.A = A;
    }

    public void setConB(Node B){
        this.B = B;
    }

    public Node getA(){
        return this.A;
    }

    public Node getB(){
        return this.B;
    }
}
