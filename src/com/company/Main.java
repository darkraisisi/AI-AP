package com.company;

public class Main {

    public static void main(String[] args) {
        Garden myGarden = new Garden(52.200037, 5.298578,6,1);

        Tomato t1 = new Tomato(1);
        Tomato t2 = new Tomato(2);
        myGarden.addPlantedCrops(t1);
        myGarden.addPlantedCrops(t2);
        System.out.println(myGarden.toString());
        System.out.println(myGarden.getPlantedCrops().toString());

//      Grow one crop
        myGarden.setNutrients(myGarden.getPlant(0).grow(myGarden.getNutrients()));
        System.out.println(myGarden.toString());
        System.out.println(myGarden.getPlantedCrops().toString());
    }
}

