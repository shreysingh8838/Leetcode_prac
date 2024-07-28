package org.example.StreamApi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Basics {
    public static void main(String[] args) {
        List<Integer> l = Arrays.asList(1, 2, 3, 4, 5 ,6, 7, 8);
        int sum = l.parallelStream().filter(a->a%2==0).mapToInt(a->a).sum();
        System.out.println(sum);

//        int sum2 = l.parallelStream().filter(a->a%2!=0).

        int sum1 = l.parallelStream().filter(a->a%2==0).reduce(0,Integer::sum);
        System.out.println(sum1);


        // Creating a stream from a collection
        Stream<Integer> stream = l.stream();

        // creating a stream from an array

                // Creating an int array stream
                int [] a = {1, 2, 3, 4, 5};
                IntStream stream1 = Arrays.stream(a);

                // creating a string array stream, so we wont use Intstream
                String [] b = {"SA", "BA", "TA", "GA"};
                Stream<String> stream2 = Arrays.stream(b);


                // creating a stream using stream.of operator
                Stream<Integer> stream3 = Stream.of(1, 2, 3 , 4, 5);
                stream3.map(i->i+3).forEach(i-> System.out.println(i));





    }
}
