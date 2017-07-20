package solution;

/**
 * Script Created by daidai on 2017/2/26.
 */
public class Solution038 {
    public String countAndSay(int n) {
        if (n <= 0) {
            return "-1";
        }
        String result = "1";
        for (int i = 1; i < n; i++) {
            result = say(result);
        }
        return result;

    }

    String say(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); ) {
            int count = 1;
            char c = s.charAt(i);
            int j = i + 1;
            for (; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    count++;
                } else {
                    break;
                }
            }
            stringBuilder.append(count);
            stringBuilder.append(c);
            i = j;
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Solution038 solution038 = new Solution038();
        System.out.println(solution038.countAndSay(2));
    }
}
