package org.example.Singleton;

public class ThreadSafeSingleton {
    private static volatile ThreadSafeSingleton threadSafeSingleton;

    private ThreadSafeSingleton(){}

    public static synchronized ThreadSafeSingleton getInstance(){
        if(threadSafeSingleton == null) return new ThreadSafeSingleton();
        else return threadSafeSingleton;
    }
}

