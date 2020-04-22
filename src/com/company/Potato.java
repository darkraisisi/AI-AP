package com.company;

public class Potato implements Plant{
    Double length = 0.0;
    Number id;
    String name = "Potato";
    Boolean edible = true;
    String color = "Brown";
    String type = "Ruski";
    Double consumtionRate = 0.2;
    Double growSpeed = 0.1;

    Potato(Number _id){
        this.id = _id;
    }

    @Override
    public double grow(Double avaiableNutrients) {
        this.length = (consumtionRate * growSpeed) * 10;
        return avaiableNutrients - this.consumtionRate;
    }

    @Override
    public String toString() {
        return "Potato{" +
                "id=" + this.id +
                ", edible=" + this.edible +
                ", type=" + this.type +
                ", consumtionRate=" + this.consumtionRate +
                ", growSpeed=" + this.growSpeed +
                ", length=" + this.length +
                '}';
    }
}
