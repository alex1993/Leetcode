package toutiao;

import java.io.StringBufferInputStream;
import java.util.*;

/**
 * Script Created by daidai on 2017/3/30.
 */
public class Solution {

    public static void solution() {

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();

        List<String> copy = new ArrayList<>();
        List<HashSet<String>> input = new ArrayList<>();
        scanner.nextLine();
        for (int i = 0; i < m; i++) {
            String string = scanner.nextLine();
            copy.add(string);
            String[] strings = string.split(" ");
            input.add(new HashSet<>(Arrays.asList(strings)));
        }

        List<HashSet<String>> query = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] strings = scanner.nextLine().split(" ");
            query.add(new HashSet<>(Arrays.asList(strings)));
        }

        List<String> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int index = -1;
            int count = Integer.MIN_VALUE;
            for (int j = 0; j < m; j++) {
                HashSet<String> q = new HashSet<>(query.get(i));
                int before = q.size();
                q.retainAll(input.get(j));
                int inter = q.size();
                if (inter > count) {
                    index = j;
                    count = inter;
                }
            }
            res.add(copy.get(index));
        }

        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }

}
