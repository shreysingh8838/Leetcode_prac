package org.example.StreamApi;

import java.util.*;
import java.util.stream.Collectors;

public class ReverseSortHashmap {

//    Question
//    Write all the values based on the decreasing order of their frequencies
    //  2 2 2 2 4 4 3 3 1 1 7 6 5
    public static void main(String[] args) {
        int [] arr= {4, 4, 2, 2, 2, 2, 3, 3, 1, 1, 6, 7, 5};

        // create a hashmap, and fill the values of integers with their frequencies
        TreeMap<Integer, Integer> t = new TreeMap<>();
        for(int i: arr){
            t.put(i, t.getOrDefault(i,0)+1);
        }


        // reverse sort the treemap based on the values
        HashMap<Integer, Integer> h = t.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(
                        Collectors.toMap(
                                Map.Entry::getKey, Map.Entry::getValue, (e1, e2)->e1 ,LinkedHashMap::new));

        StringBuilder sb = new StringBuilder();

        for(Map.Entry<Integer, Integer> i : h.entrySet()){
            int l = i.getValue();
            while(l>0) {
                sb.append(i.getKey()+" ");
                l--;
            }
        }
        System.out.println(sb.reverse());
    }
}
