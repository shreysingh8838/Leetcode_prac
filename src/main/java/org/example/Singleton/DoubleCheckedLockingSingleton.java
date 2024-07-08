package org.example.Singleton;

public class DoubleCheckedLockingSingleton {

    private static volatile DoubleCheckedLockingSingleton doubleCheckedLockingSingleton;

    private DoubleCheckedLockingSingleton(){}

    public static DoubleCheckedLockingSingleton getInstance(){
        if(doubleCheckedLockingSingleton == null){
            synchronized (DoubleCheckedLockingSingleton.class){
                if(doubleCheckedLockingSingleton == null){
                    return new DoubleCheckedLockingSingleton();
                }
                else return doubleCheckedLockingSingleton;
            }
        }
        return doubleCheckedLockingSingleton;
    }
}
