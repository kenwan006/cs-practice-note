package creation;

import java.util.concurrent.FutureTask;

/**
 * couple of ways of creating thread
 */
public class Demo {
    public static void main(String[] args) {
        // extend the Thread class
        MyThread thread1 = new MyThread();
        thread1.setName("Thread1");

        // Anonymous method
        Thread thread11 = new Thread(
                () -> {
                    for (int i = 0; i < 5 ; i++) {
                        System.out.println("The thread " + Thread.currentThread().getName() + " is printing: " + i);
                    }
                }
        );
        thread11.setName("Thread11");

        //implement the Runnable interface
        MyRunnable myRunnable = new MyRunnable();
        Thread thread2 = new Thread(myRunnable);
        thread2.setName("Thread2");

        //implement the Callable interface
        MyCallable myCallable = new MyCallable();
        FutureTask task = new FutureTask(myCallable);
        Thread thread3 = new Thread(task);
        thread3.setName("Thread3");

        //start all threads concurrently
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
