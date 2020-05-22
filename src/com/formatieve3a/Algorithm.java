package com.formatieve3a;

import java.util.ArrayList;

public class Algorithm {
    public ArrayList<String> bubbleSort(ArrayList<String> list) {
        int len = list.size();
        int c = 0;
        while(true){
            boolean hits = false;
            for (int i = 0; i < len-1; i++) {
//                System.out.println(list.get(i).compareTo(list.get(i + 1)));
//                System.out.println(list.get(i)+">"+list.get(i + 1));
                if(list.get(i).compareTo(list.get(i + 1)) > 0){
                    hits = true;
                    String item1 = list.get(i);
                    String item2 = list.get(i+1);
                    list.set(i,item2);
                    list.set(i+1,item1);
                }
            }
            len -=1;
            if(!hits){
                System.out.println("Took "+c+" cycles");
                break;
            }
            c+=1;
        }
        return list;
    }
}
