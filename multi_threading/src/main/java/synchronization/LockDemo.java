package synchronization;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {
    int count = 0;
    Lock lock = new ReentrantLock();

    public void run() {
        lock.lock();
        try {
            count++;
            System.out.println(Thread.currentThread().getName() + " increment the count to: " + count);
        }finally {
            lock.unlock();
        }

    }
    public static void main(String[] args) {
        LockDemo demo = new LockDemo();
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                demo.run();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                demo.run();
            }
        });

        thread1.start();
        thread2.start();
    }
}
