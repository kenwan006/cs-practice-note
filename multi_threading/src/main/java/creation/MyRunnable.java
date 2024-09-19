package creation;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 5 ; i++) {
            System.out.println("Runnable interface " + Thread.currentThread().getName() + ", printing: " + i);
        }

    }
}
