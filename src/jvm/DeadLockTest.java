package jvm;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Script Created by daidai on 2017/6/18.
 */
public class DeadLockTest {

    final Object obj1;
    final Object obj2;

    public DeadLockTest(Object obj1, Object obj2) {
        this.obj1 = obj1;
        this.obj2 = obj2;
    }

    private void test1() throws InterruptedException {
        synchronized (obj1) {
            System.out.println("1 obtained obj2");
            Thread.sleep(1000);
            obj1.notify();
            System.out.println("out 1");
        }
        System.out.println(obj2);
    }

    private void test2() throws InterruptedException {
        Thread.sleep(10);
        synchronized (obj1) {
            System.out.println("1 obtained obj1");
            Thread.sleep(10);
            obj1.wait();
            System.out.println("in 2");
            System.out.println("out 2");
        }
        System.out.println(obj1);
    }

    public static void main(String[] args) throws InterruptedException {
        DeadLockTest deadLockTest = new DeadLockTest("string1", "string2");
        Runnable runnable = () -> {
            try {
                deadLockTest.test1();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Runnable runnable1 = () -> {
            try {
                deadLockTest.test2();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        ExecutorService service = Executors.newFixedThreadPool(2);
        service.execute(runnable);
        service.execute(runnable1);
        Thread.sleep(2000);
        service.shutdown();
    }
}
