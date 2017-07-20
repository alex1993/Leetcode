import solution.Solution010;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(4);
        Integer[] res = new Integer[list.size()];
        list.toArray(res);
        System.out.println(res[0]);

        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 2);
        Integer val = (Integer) map.get(1);
        System.out.println(val);

        List<? super Integer> integers = foo();
        integers.add(3);

        List<Solution010> integers1 = new ArrayList<>();
        integers1.add(new Int());
        bar(integers1);

        List<String> a = new ArrayList<>();
        a.add("1");
        a.add("2");
        for (String temp : a) {
            if ("2".equals(temp)) {
                a.remove(temp);
            }
        }
        System.out.println(a);

    }

    private static class Int extends Solution010 {

    }

    private static List<? super Integer> foo() {
        return new ArrayList<>();
    }

    private static void bar(List<? extends Solution010> t) {

    }



}
