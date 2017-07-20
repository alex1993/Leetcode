import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

/**
 * Script Created by daidai on 2017/3/10.
 */
public class GenericClass {

    public static <E> List<? super E> reduce(List<? extends E> list, Function<E, E> function, E initValue) {
        List<? super E> result = new ArrayList<E>();
        result.add(initValue);
        return result;
    }

    public static <E extends Comparable<E>> E max(List<? extends E> list) {
        E max = list.get(0);
        for (E e : list) {
            if (e.compareTo(max) > 0) {
                max = e;
            }
        }
        return max;
    }

    public static <E extends Comparable<? super E>> E maxVal(List<? extends E> list, List<? super E> list2) {
        Iterator<? extends E> iterator = list.iterator();
        E next = iterator.next();
        return next;
    }

    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        Function<Integer, Integer> identical = (number) -> number;
        List<? super Integer> reducer = reduce(nums, identical, 0);
        reducer.forEach(System.out::println);
        System.out.println(max(Arrays.asList(1, 2, 3, 4, 3)));

        List<Number> numbers = new ArrayList<>();
        maxVal(nums, numbers);
    }
}
