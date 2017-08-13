package nowcoder;

import java.util.Scanner;

/**
 * Script Created by daidai on 2017/8/9.
 */
public class Main5 {
    public static void main(String[] args) {
        int mod = 1_000_000_000 + 9;
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            long ans = 1;
            boolean[] visited = new boolean[num + 1];
            for (int i = 2; i <= num; i++) {
                if (visited[i]) {
                    continue;
                }
                //用于统计素数的幂的个数
                int count = 0;
                for (int j = i + i; j <= num; j += i) {
                    visited[j] = true;
                }
                long mi = i;
                while (mi <= num) {
                    count++;
                    mi *= i;
                }

                ans = ans * (count + 1) % mod;
            }
            System.out.println(ans);
        }
    }
}
