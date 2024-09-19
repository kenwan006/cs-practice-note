package synchronization;

//use the keyword `synchronized` to achieve synchronization among multiple threads
public class SynchronizedDemo {
    private Integer count = 0;

    //synchronized method
    public synchronized void run1() {
        count++;
        System.out.println(Thread.currentThread().getName() + " increment the count to: " + count);
    }

    //synchronized block
    private void run2() {
        synchronized (count) {
            count++;
            System.out.println(Thread.currentThread().getName() + " increment the count to: " + count);
        }
    }

    public static void main(String[] args) {
        SynchronizedDemo demo = new SynchronizedDemo();

        //call method run1() concurrently
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                demo.run1();
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                demo.run1();
            }
        });
        thread1.start();
        thread2.start();

        //call method run2() concurrently
        Thread thread3 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                demo.run2();
            }
        });
        Thread thread4 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                demo.run2();
            }
        });
        //thread3.start();
        //thread4.start();
    }
}
