package com.formatieve3a;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        int leftLimit = 65;
        int rightLimit = 122;
        int listLength = 100;
        ArrayList<String> strLst = new ArrayList<>(100);

        // Make a list of 100 random string of 10 characters
        for (int i = 0; i < listLength; i++) {
            String string = random.ints(leftLimit, rightLimit + 1)
                    .filter(number -> (number <= 90 || number >= 97))
                    .limit(10)
                    .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                    .toString();
            strLst.add(string);
        }
        Algorithm algo = new Algorithm();
        strLst = algo.bubbleSort(strLst);
        System.out.println(strLst);

        CustomArray myArray = new CustomArray();
    }
}
//65/90 97/122