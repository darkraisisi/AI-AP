package com.summatieve3;

import java.util.ArrayList;

public class Flight extends Step implements Comparable<Flight>{
    public int price;
    public double baggageChance;
    public Flight(String name, double baggageChance){
        super(name);
        this.baggageChance = baggageChance;
    }

    public int flightScore(){
        return (int)(this.price*this.baggageChance);
    }

    @Override
    public int compareTo(Flight flight){
//      baggageChance is a number between 1 and 0.1 you multiply the chance of disappearing by the price to get the score of a flight
//      price 1200 and the disappearing chance is 0.5 = 600 but a different flight is more expensive but is also more reliable(I chose this is more important)
//      lets say price of 1300 but the chance is 0.4 that means the score is 520, that score is lower(better) than the previous cheaper option.
        if(flight.equals(this)){
            return 0;
        }else if(flight.flightScore() > this.flightScore()){
            return this.flightScore() - flight.flightScore();
        }else{
            return flight.flightScore() - this.flightScore();
        }
    }

    @Override
    public int getDistance(Step step) {
        return (int) this.connections.get(step.getName());
    }

    @Override
    public void addConnections(Step toAdd,Number price) {
        this.connections.put(toAdd.getName(),(int)price);
    }
}
