package com.finitestatemachine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random random = new Random();
        Double number = random.nextDouble();

        System.out.println("How many sides does your dice have(number)\n");
        int diceSides = Integer.parseInt(in.nextLine());


        try {
            Node dice = new WeightedNode("Start",false);
            dice.generateNetwork(diceSides);
            System.out.println(dice);
            System.out.println(dice.next(number));

        }catch (Exception e){
            System.out.println(e);
        }


    }
}
