package org.example;

public class FibonachiSeries {

    private static void fibonaci(int i, int j){
        if(i >= 100){
            return ;
        }
        System.out.print(i + ", ");
        fibonaci(j, j+i);
    }

    private static void fibonaciAtCount(int i, int j, int counter){
        if(counter == 10){
            System.out.println(i);
            return;
        }
        fibonaciAtCount(j, j+i, ++counter);
    }
    public static void main(String[] args) {
        System.out.println("Fibonaci series till 100");
        fibonaci(0, 1);
        System.out.println("");
        System.out.println("Fibonaci series element at 10th place");
        fibonaciAtCount(0, 1, 0);
    }
}
