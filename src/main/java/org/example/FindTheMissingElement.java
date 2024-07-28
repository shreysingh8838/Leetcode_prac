package org.example;

import java.util.Arrays;

public class FindTheMissingElement {
    public static void main(String[] args) {
        int n = 10;
        int [] nums = {1,2,8,10,3,4,5,6,7};

//        Arrays.sort(nums);
//        for(int i =1; i<=n; i++){
//            if(i!=nums[i-1]){
//                System.out.println(i);
//                break;
//            }
//        }

        int sum = (n * (n+1))/2;
        int sumi = 0;
        for(int i=0; i<n-1; i++){
            sumi += nums[i];
        }
        System.out.println(sum - sumi);
    }
}
