package jvm;

import java.io.ByteArrayInputStream;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

import static java.lang.invoke.MethodHandles.lookup;

/**
 * Script Created by daidai on 2017/6/14.
 */
public class MethodHandleTest {
    static class ClassA {
        public void println(String s) {
            System.out.println(s);
        }
    }

    public static void main(String[] args) throws Throwable {
//        Object obj = System.currentTimeMillis() % 2 == 0 ? System.out : new ClassA();
//        getPrintlnMethodHandle(obj).invokeExact("test");

        String s = "{1.2, 2.3, 3.4, 4.5, 5.6}";
        String[] split = s.substring(1, s.length() - 1).split(", ");

        s = s.replaceAll("\\{|, |}", " ").trim();
        split = s.split(" ");

        split = s.split(Pattern.quote("["));

        for (String s1 : split) {
            System.out.println(s1);
        }
//        Scanner scanner = new Scanner(new ByteArrayInputStream(s.getBytes()));
//        while (scanner.hasNext()) {
//            System.out.println(scanner.nextInt());
//        }
    }

    private static MethodHandle getPrintlnMethodHandle(Object receiver) throws Throwable {
        MethodType methodType = MethodType.methodType(void.class, String.class);
        return lookup().findVirtual(receiver.getClass(), "println", methodType).bindTo(receiver);
    }
}
