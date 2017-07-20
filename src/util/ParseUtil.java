package util;

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
}
