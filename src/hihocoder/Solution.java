package hihocoder;

/**
 * Script Created by daidai on 2017/3/31.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        while (scanner.hasNext()) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            System.out.println(a + b);
        }
    }

    private static int readInt(InputStream in) throws IOException {
        int result = 0;
        boolean dig = false;

        while (true) {
            int c = in.read();
            if (c == -1) {
                break;
            }
            if (c >= '0' && c <= '9') {
                result = result * 10 + (c - '0');
                dig = true;
            } else if (dig) {
                break;
            }
        }
        return result;
    }

}
