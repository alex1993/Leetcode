package jvm;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Script Created by daidai on 2017/6/15.
 */
public class GenericTest {
    static void print(int x) {
        System.out.println("Int: " + x);
    }

    static void print(String x) {
        System.out.println("String: " + x);
    }

    static void print(Object x) {
        System.out.println("Object: " + x);
    }

    static <T> void printWithClass(T t) {
        print(t);
    }

    static void copyList(List<? extends Apple> list, List<? super Apple> copy) {
        copy = new ArrayList<>();
        copy.addAll(list);
        copy.add(new Apple());
        copy.add(new AsiaApple());
    }

    public static void main(String args[]) {
        printWithClass("abc");

        List<Apple> list = new ArrayList<>();

        List<Apple> list2 = new ArrayList<>();
        copyList(list, list2);

        new AsiaApple().printTest();
        List<Apple> apples = new ArrayList<>();
        Object[] objects = new Apple[10];
        List<Fruit> fruits = new ArrayList<>();
        foo(apples, fruits);
        List<? super Apple> ap = fruits;
        ap.add(new AsiaApple());
        List<? extends Fruit> f = apples;
    }

    private static void foo(List<? extends Fruit> fruits, List<? super Fruit> bar) {
        for (Fruit fruit : fruits) {
            bar.add(fruit);
        }
    }

    static class Fruit {

        Fruit() {
            System.out.println("Fruit Constructor");
        }
        public void printTest() {
            System.out.println("in Fruit");
        }

    }

    static class Apple extends Fruit {

        Apple() {
            System.out.println("Apple Constructor");
        }

        @Override
        public void printTest() {
            System.out.println("in Apple");
        }
    }

    static class AsiaApple extends Apple {
        AsiaApple() {
            System.out.println("Asia Apple Constructor");
        }
    }

}
