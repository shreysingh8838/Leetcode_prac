package org.example.tryCatch;

public class tryCatch {

    public static void checkthis() throws ArithmeticException{
        System.out.println("Hello 1");
        System.out.println(1/0);
    }
    public static void main(String ... args){
//        try{
//            System.out.println("Hello 1");
//            System.out.println(1/0);
//        }catch (Exception e){
//            System.out.println(e);
//        }

        checkthis();
    }
}
