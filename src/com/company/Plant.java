package com.company;

public interface Plant {
    String name = null;
    Boolean edible = false;
    String color = null;
    String type = null;
    String growthPeriod = "Spring";
    Double consumtionRate = 0.1;
    Double growSpeed = 0.1;

    double grow(Double avaiableNutrients);
    String toString();
}
