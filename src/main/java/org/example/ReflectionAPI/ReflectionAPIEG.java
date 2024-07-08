package org.example.ReflectionAPI;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ReflectionAPIEG {
    private String pv = "HI";

    public static void main(String ... args){

        try{
            ReflectionAPIEG api = new ReflectionAPIEG();

            Class<?> clazz = api.getClass();

            Field field = clazz.getDeclaredField("pv");

        } catch (Exception e){
            System.out.println(e);
        }




        CompletableFuture<String> s1 = CompletableFuture.supplyAsync(()->printThis("hey") );
        CompletableFuture<String> s2 = CompletableFuture.supplyAsync(()->printThis("there") );

        CompletableFuture<String> res = s1.thenCombine(s2, (res1, res2)-> res1 + " " + res2);
        res.thenAccept(System.out::println);

    }

    public static String printThis(String nowThis){
        return nowThis;
    }


}
