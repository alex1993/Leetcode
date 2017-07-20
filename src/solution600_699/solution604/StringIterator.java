package solution600_699.solution604;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Script Created by daidai on 2017/6/11.
 */
public class StringIterator {

    class Pair {
        char c;
        int count;

        Pair(char c, int count) {
            this.c = c;
            this.count = count;
        }
    }

    private List<Pair> compressed;
    int curIndex;
    int curNum;

    public StringIterator(String compressedString) {
        compressed = new ArrayList<>();
        char[] chars = compressedString.toCharArray();
        for (int i = 0; i < chars.length; ) {
            if (Character.isAlphabetic(chars[i])) {
                char c = chars[i];
                i++;
                int num = 0;
                while (i < chars.length && Character.isDigit(chars[i])) {
                    num = num * 10 + chars[i] - '0';
                    i++;
                }
                Pair pair = new Pair(c, num);
                compressed.add(pair);
            }
        }
    }

    public char next() {
        if (curIndex == compressed.size()) {
            return ' ';
        }
        Pair pair = compressed.get(curIndex);
        char c = pair.c;
        curNum++;
        if (curNum == pair.count) {
            curIndex++;
            curNum = 0;
        }
        return c;
    }

    public boolean hasNext() {
        return curIndex != compressed.size();
    }

    public static void main(String[] args) {
        StringIterator iterator = new StringIterator("L1e2t1C1o1d1e1");
        System.out.println(iterator.next()); // return 'L'
        System.out.println(iterator.next()); // return 'e'
        System.out.println(iterator.next()); // return 'e'
        System.out.println(iterator.next()); // return 't'
        System.out.println(iterator.next()); // return 'C'
        System.out.println(iterator.next()); // return 'o'
        System.out.println(iterator.next()); // return 'd'
        System.out.println(iterator.hasNext()); // return true
        System.out.println(iterator.next()); // return 'e'
        System.out.println(iterator.hasNext()); // return false
        System.out.println(iterator.next()); // return ' '
    }
}

/**
 * Your StringIterator object will be instantiated and called as such:
 * StringIterator obj = new StringIterator(compressedString);
 * char param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
