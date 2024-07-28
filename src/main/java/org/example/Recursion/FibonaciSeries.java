package org.example.Recursion;

public class FibonaciSeries {
    private static void fibo(int i, int j, int k){
        if(i>k){
            return;
        }
        System.out.print(i + " ");
        fibo(j, i+j, k);
    }

    public static void main(String[] args) {
        fibo(13, 21 ,100);
    }
}
