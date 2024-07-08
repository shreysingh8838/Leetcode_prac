package org.example;

public class MedianOfSortedArrays {
    public static void main(String[] args) {
        
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;

        int [] res = new int[l1 + l2];

        int j = 0;
        int k = 0;
        for(int i = 0; i<l1+l2; i++){
            if(nums1[j] <= nums2[k]){
                res[i++] = nums1[j++];
            }
            else{
                res[i++] = nums2[k++];
            }
        }

        for(int i : res){
            System.out.println(i);
        }

        double fval = 0.0;
        int lsum = l1+l2;
        if( lsum % 2 == 0) {
            int rem = lsum / 2;
            int sum = res[rem] + res[rem-1];
            fval = sum / 2;
        } else {
            fval = res[(lsum+1)/2];
        }
        return fval;
    }
}