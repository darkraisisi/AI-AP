package com.company;

import java.util.ArrayList;

public class Garden {
    private double longitude;
    private double latitude;
    private double length;
    private double width;
    private double moistness = 0;
    private double nutrients = 10;

    private ArrayList<Plant> plantedCrops = new ArrayList<>();

    public Garden(double longitude, double latitude, float length, float width) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.length = length;
        this.width = width;
    }

    @Override
    public String toString() {
        return "Garden{" +
                "longitude=" + longitude +
                ", latitude=" + latitude +
                ", length=" + length +
                ", width=" + width +
                ", moistness=" + moistness +
                ", nutrients=" + nutrients +
                ", plantedCrops=" + plantedCrops +
                '}';
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public double getMoistness() {
        return moistness;
    }

    public void setMoistness(float moistness) {
        this.moistness = moistness;
    }

    public double getNutrients() {
        return nutrients;
    }

    public void setNutrients(double nutrients) {
        this.nutrients = nutrients;
    }

    public void addPlantedCrops(Plant plant){
        this.plantedCrops.add(plant);
    }

    public ArrayList<Plant> getPlantedCrops(){
        return this.plantedCrops;
    }

    public Plant getPlant(int i) {
        return this.plantedCrops.get(i);
    }
}
