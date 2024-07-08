package org.example.Singleton;

public class LazySingleton {

    private static LazySingleton lazySingleton;

    private LazySingleton(){}

    public static LazySingleton getInstance(){
        if(lazySingleton == null) return new LazySingleton();
        else return lazySingleton;
    }
}
