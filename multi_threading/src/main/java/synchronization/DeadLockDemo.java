package synchronization;

public class DeadLockDemo {
    SharedResource resource1 = new SharedResource("rs1", "shanghai");
    SharedResource resource2 = new SharedResource("rs2", "beijing");

    //dead-lock scenario
    public void run1() {
        Thread thread1 = new Thread(() -> {
            synchronized (resource1) {
                String s = Thread.currentThread().getName();
                System.out.println(s + " is in the city: " + resource1.getCity());
                synchronized (resource2) {
                    System.out.println(s + " want go to the city: " + resource2.getCity());
                }
            }
        });
        thread1.setName("thread-1");

        Thread thread2 = new Thread(() -> {
            synchronized (resource2) {
                String s = Thread.currentThread().getName();
                System.out.println(s + " is in the city: " + resource2.getCity());
                synchronized (resource1) {
                    System.out.println(s + " want go to the city: " + resource1.getCity());
                }
            }
        });
        thread2.setName("thread-2");

        thread1.start();
        thread2.start();
    }

    //avoid dead lock by consuming the shared resources in the same order
    public void run2() {
        Thread thread1 = new Thread(() -> {
            synchronized (resource1) {
                String s = Thread.currentThread().getName();
                System.out.println(s + " is in the city: " + resource1.getCity());
                synchronized (resource2) {
                    System.out.println(s + " want go to the city: " + resource2.getCity());
                }
            }
        });
        thread1.setName("thread-1");

        Thread thread2 = new Thread(() -> {
            synchronized (resource1) {
                String s = Thread.currentThread().getName();
                System.out.println(s + " is in the city: " + resource2.getCity());
                synchronized (resource2) {
                    System.out.println(s + " want go to the city: " + resource2.getCity());
                }
            }
        });
        thread2.setName("thread-2");

        thread1.start();
        thread2.start();
    }

    public static void main(String[] args) {
        DeadLockDemo demo = new DeadLockDemo();
        demo.run1();
        //demo.run2();
    }


}
