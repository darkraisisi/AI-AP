package com.summatieve3;

import java.util.ArrayList;

public class Drive extends Step implements Comparable<Drive> {
    public double kilometer;
    public Drive(String name, double kilometer){
        super(name);
        this.kilometer = kilometer;
    }

    @Override
    public int compareTo(Drive drive){
        if(drive.equals(this)){
            return 0;
        }else if(drive.kilometer > this.kilometer){
            return (int)(this.kilometer - drive.kilometer);
        }else{
            return (int)(drive.kilometer - this.kilometer);
        }
    }

    @Override
    public void addConnections(Step toAdd, Number number) {

    }

    @Override
    public int getDistance(Step step) {
        return 0;
    }
}
