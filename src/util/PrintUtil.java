package util;

/**
 * Script Created by daidai on 2017/6/24.
 */
public class PrintUtil {
    public static void printMatrix(String s) {
        String[] strings = s.substring(1, s.length() - 1).split(",");
        for (String string : strings) {
            string = string.substring(1, string.length() - 1);
            System.out.println(string);
        }
    }
}
