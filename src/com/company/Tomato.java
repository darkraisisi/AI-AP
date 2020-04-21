package com.company;

public class Tomato implements Plant{
    Double length = 0.0;
    Number id;
    String name = "Tomato";
    Boolean edible = true;
    String color = "Red";
    String type = "Romano";
    Double consumtionRate = 0.3;
    Double growSpeed = 0.2;

    Tomato(Number _id){
        this.id = _id;
    }

    @Override
    public double grow(Double avaiableNutrients) {
        this.length = (consumtionRate * growSpeed) * 10;
        return avaiableNutrients - this.consumtionRate;
    }

    @Override
    public String toString() {
        return "Tomato{" +
                "id=" + this.id +
                ", edible=" + this.edible +
                ", type=" + this.type +
                ", consumtionRate=" + this.consumtionRate +
                ", growSpeed=" + this.growSpeed +
                ", length=" + this.length +
                '}';
    }
}
