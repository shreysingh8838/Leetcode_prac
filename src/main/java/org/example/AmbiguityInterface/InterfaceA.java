package org.example.AmbiguityInterface;

public interface InterfaceA {
    default void runthis(){
        System.out.println("Interface A");
    }
}
