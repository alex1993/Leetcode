package jvm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Script Created by daidai on 2017/6/15.
 */
public class CopyOnWriteTest {

    static class Thread1 extends Thread {
        private List<Integer> list;
        Thread1(List<Integer> list) {
            this.list = list;
        }

        @Override
        public void run() {
            for (int i = 0; i < list.size(); i++) {
                list.remove(i);
            }
        }
    }

    static class Thread2 extends Thread {
        private List<Integer> list;

        Thread2(List<Integer> list) {
            this.list = list;
        }

        @Override
        public void run() {
            for (Integer integer : list) {
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 100000; i++) {
            list.add(i);
        }

        Thread1 thread1 = new Thread1(list);
        Thread2 thread2 = new Thread2(list);
//        thread1.start();
//        thread2.start();
//
        ExecutorService executorService = Executors.newCachedThreadPool();
//        executorService.submit(thread1);
//        executorService.submit(thread2);
        executorService.execute(thread1);
        executorService.execute(thread2);
        executorService.shutdown();
    }
}
