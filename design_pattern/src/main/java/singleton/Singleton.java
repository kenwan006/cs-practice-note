package singleton;

import java.security.Signature;

public class Singleton {
    private static Singleton singleton;

    private Singleton(){};

    public static Singleton getInstance() {
        //use double-checked locking to ensure thread safety
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) singleton = new Singleton();
            }
        }
        return singleton;
    }

    public void message (){
        System.out.println("Hello world, this is a singleton instance obtained by thread: " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        //simulate multi-threads trying to access the singleton object concurrently
        Thread thread1 = new Thread(() -> Singleton.getInstance().message());
        Thread thread2 = new Thread(() -> Singleton.getInstance().message());
        thread1.setName("thread1");
        thread2.setName("thread2");

        thread1.start();
        thread2.start();
    }
}
