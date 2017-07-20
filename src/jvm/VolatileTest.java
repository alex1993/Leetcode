package jvm;

/**
 * Script Created by daidai on 2017/6/17.
 */
public class VolatileTest {

    public volatile int race = 0;

    public void increment() {
        synchronized (this) {
            race++;
        }
    }

    private static final int THREAD_COUNT = 20;

    public static void main(String[] args) throws InterruptedException {
        VolatileTest volatileTest = new VolatileTest();
        Thread[] threads = new Thread[THREAD_COUNT];
        for (int i = 0; i < THREAD_COUNT; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    volatileTest.increment();
                }
            });
            threads[i].start();
        }

        Thread.sleep(1000);
        System.out.println(volatileTest.race);

    }
}
