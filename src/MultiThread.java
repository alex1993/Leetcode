/**
 * Script Created by daidai on 2017/3/13.
 */
public class MultiThread {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println("hello from new thread");
        });
        thread.start();
        Thread.sleep(1);
        System.out.println("main");
        thread.join();
    }
}
