/**
 * ThreadLocal allows each thread to maintain their own specific data
 * eg, thread1 can output its own 0 -> 1 -> 2 -> 3, the thread2 can output its own 0 -> 1 -> 2 -> 3
 * Imagine if we don't use thread-local, but just some synchronization approach, the output would be like:
 * 0 -> 1 -> 2 -> 3 -> 4 -> 5 -> 6
 */
public class ThreadLocalDemo {
    public static void main(String[] args) {
        ThreadLocal<Integer> threadLocalVar = ThreadLocal.withInitial(() -> 0);

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " has the local variable: " + threadLocalVar.get());
                for (int i = 0; i < 3; i++) {
                    threadLocalVar.set(threadLocalVar.get() + 1);
                    System.out.println(Thread.currentThread().getName() + " increments the local variable: " + threadLocalVar.get());
                }
            }
        };

        Thread thread1 = new Thread(runnable, "thread-1");
        Thread thread2 = new Thread(runnable, "thread-2");

        thread1.start();
        thread2.start();
    }
}

