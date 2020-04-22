package com.company;

public interface Animal {
    String name = null;
    String kingdome = "Zoogdier";
    Number age = 0;
    Boolean gender = false;
    Boolean flying = true;

    void settle();
    double eat(Double avaiableNutrients);
    void die();
    String toString();
}
