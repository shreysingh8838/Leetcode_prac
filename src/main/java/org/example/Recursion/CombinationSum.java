package org.example.Recursion;

//Combination Sum: Given an array of distinct integers candidates and a target integer target,
//return a list of all unique combinations of candidates where the chosen numbers sum to target.
//You may return the combinations in any order.
//The same number may be chosen from candidates an unlimited number of times.
//Two combinations are unique if the frequency of at least one of the chosen numbers is different.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

    private static List<List<Integer>> combinationSum(int[] candidates, int target){
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }

    private static void backtrack(List<List<Integer>> res, List<Integer> hres, int[] candidates, int remain, int start){
        if(remain < 0) return;
        else if (remain == 0) res.add(new ArrayList<>(hres));
        // why we have used 'new ArrayList<>(hres)' instead of 'res.add(hres)'
//        new ArrayList<>(tempList) creates a new copy of tempList at its current state, ensuring that each combination added to the result is independent and won't be affected by further modifications to tempList.
//        Directly adding tempList or hres without making a copy would cause all references in the result list to point to the same list, leading to incorrect results as the list is modified during backtracking.
        else{
            for(int i=start; i<candidates.length; i++){
                hres.add(candidates[i]);
                backtrack(res, hres, candidates, remain-candidates[i], i);
                hres.remove(hres.size()-1);
            }
        }
    }
    public static void main(String[] args) {
//        Input: candidates = [2,3,6,7], target = 7
//        Output: [[2,2,3],[7]]
//        Explanation:
//        2 and 3 are used multiple times.
//        7 is used once.

//        Input: candidates = [2,3,5], target = 8
//        Output: [[2,2,2,2],[2,3,3],[3,5]]

        long startTime = System.nanoTime();

        int [] candidates = {2,3,5,6,7,9,10};
        int target = 50;
        System.out.println(combinationSum(candidates, target));

// Your code here...

        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000; // Convert to milliseconds

        System.out.println("Time taken: " + duration + " milliseconds");
    }
}
