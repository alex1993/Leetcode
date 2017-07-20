package huawei;

import java.util.Scanner;

/**
 * Script Created by daidai on 2017/6/28.
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            String[] strings = s.trim().split(" ");
            StringBuilder sb = new StringBuilder();
            boolean first = true;
            for (int i = strings.length - 1; i >= 0; i--) {
                if ("".equals(strings[i])) {
                    continue;
                }
                if (first) {
                    sb.append(strings[i]);
                    first = false;
                } else {
                    sb.append(" ").append(strings[i]);
                }
            }

            System.out.println(sb.toString());
        }
    }

}