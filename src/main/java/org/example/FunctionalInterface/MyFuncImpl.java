package org.example.FunctionalInterface;

public class MyFuncImpl {
    public static void main(String[] args) {
        MyFuncInterface myFuncInterface = new MyFuncInterface(){
          @Override
          public void myMethod(){
              System.out.println("Hi anonymous class");
          }
        };

        MyFuncInterface myFuncInterface1 = ()->{
            System.out.println("Hi lambda expression");
        };
        myFuncInterface.myMethod();
        myFuncInterface1.myMethod();
    }
}
