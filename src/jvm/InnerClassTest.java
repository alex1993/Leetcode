package jvm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * Script Created by daidai on 2017/6/15.
 */
public class InnerClassTest {

    public static void main(String[] args) {
        int a = 10;
        Test test = new Test() {
            @Override
            public void test() {
                System.out.println(a);
            }
        };

    }

    class IIII {

    }

    interface Test {
        void test();
    }
}
