package util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Script Created by daidai on 2017/4/17.
 */
public class ParseUtil {

    public static char[][] parseString(String string) {
        String[] strings = string.split("\n");
        char[][] res = new char[strings.length][strings[0].length()];
        for (int i = 0; i < strings.length; i++) {
            String string1 = strings[i];
            res[i] = string1.toCharArray();
        }
        return res;
    }

    public static char[][] parseMatrix(String s) {
        String[] strings = s.substring(1, s.length() - 1).split(",");
        char[][] res = new char[strings.length][];
        for (int i = 0, stringsLength = strings.length; i < stringsLength; i++) {
            String string = strings[i];
            char[] chars = string.substring(1, string.length() - 1).toCharArray();
            res[i] = chars;
        }
        return res;
    }

    public static int[][] parseArrays(String string) {
        string = string.substring(1, string.length() - 1);
        List<List<Integer>> lists = new ArrayList<>();
        char[] chars = string.toCharArray();
        List<Integer> tmp = new ArrayList<>();
        int number = 0;
        int sign = 1;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '[') {
                tmp.clear();
            } else if (chars[i] == '-') {
                sign = -1;
            } else if (Character.isDigit(chars[i])) {
                while (Character.isDigit(chars[i])) {
                    number = number * 10 + (chars[i] - '0');
                    i++;
                }
                tmp.add(sign * number);
                number = 0;
                sign = 1;
                i--;
            } else if (chars[i] == ']') {
                lists.add(new ArrayList<>(tmp));
                i++;
            }
        }
        int[][] res = new int[lists.size()][];
        for (int i = 0; i < lists.size(); i++) {
            res[i] = new int[lists.get(i).size()];
            for (int j = 0; j < lists.get(i).size(); j++) {
                res[i][j] = lists.get(i).get(j);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] res = ParseUtil.parseArrays("[[1,2],[2,3],[-33,4],[4,5]]");
        System.out.println(Arrays.deepToString(res));
    }
}
