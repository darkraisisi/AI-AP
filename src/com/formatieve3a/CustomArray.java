package com.formatieve3a;

import java.util.ArrayList;
import java.util.List;

public class CustomArray<T> implements Comparable<T>{

    ArrayList<T> list = new ArrayList<T>();

    public CustomArray(){
        new CustomArray(0);
    }

    public CustomArray(int size){
        for (int i = 0; i < size; i++) {
            add(null);
        }
    }

    public void add(T input){
        if(input == null){
            list.add(input);

        }else{
//            if(list.get(0).compareTo(input) > 0){
//                list.add(0,input);
//            }else{
//                list.add(1,input);
//            }
        }

    }

    @Override
    public int compareTo(T o) {
        if(o == null){
            return 1;
        }
        return 1;
    }
}
