import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemo {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3); //create a thread pool of size 3

        //let's creat 10 threads, and see how thread pool manage them
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                try {
                    Thread.sleep(200);
                    System.out.println(Thread.currentThread().getName() + " is running.");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
            executorService.execute(thread);
        }
        executorService.shutdown();
    }
}
