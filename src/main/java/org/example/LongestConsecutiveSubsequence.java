package org.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LongestConsecutiveSubsequence {

    public static int longestConsecutiveSequence(List<Integer> a){
        int ans = 0;
        HashMap<Integer, Integer> h = new HashMap();
        for(int i = 0; i<a.size(); i++){
            h.put(a.get(i),1);
        }
        for(int key :  h.keySet()){
            if(h.containsKey(key-1)){
                int nValue = h.get(key-1) + 1;
                h.put(key, nValue);
                if(ans < nValue) ans = nValue;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        List<Integer> a = Arrays.asList(49, 1, 3, 200, 48, 4, 70);
        System.out.println(longestConsecutiveSequence(a));
    }
}
