package org.example;

public class trial {

    public static void main(String[] args) {


        test t = new test();

        face r = test::display;
        r.display1();

    }

}

class test {

    public static void display(){
        System.out.println("testing");
    }
}

interface face {
    abstract void display1();

}