package org.example.AmbiguityInterface;

public interface InterfaceB {

    default void runthis(){
        System.out.println("Interface B");
    }
}
