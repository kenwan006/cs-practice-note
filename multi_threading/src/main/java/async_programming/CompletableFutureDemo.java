package async_programming;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureDemo {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        String file = "myFile";

        //main thread
        System.out.println(Thread.currentThread().getName() + " - this is the main thead running task 1..");

        //separate thread to run the async task
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + " - running in the background for task 2");

            String res = "loading the file from the disk... " + file;
            try {
                Thread.sleep(2000); //simulate the process of async task
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return res;
        }, executor)
                .thenApply((res) -> res + " - the data in the file has been deserialized");


        //main thread
        System.out.println(Thread.currentThread().getName() + " - finish the main task");

        //accept the result from the async task
        future.thenAccept((res) -> {
            System.out.println(Thread.currentThread().getName() + " is receiving the result of the async task...");
            System.out.println("This is the result: " + res);
        });
    }
}
