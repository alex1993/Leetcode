package solution;

/**
 * Script Created by daidai on 2017/3/15.
 */
public class Solution434 {
    public int countSegments(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }
        String[] strings = s.split(" ");
        int count = 0;
        for (String string : strings) {
            if (!"".equals(string)) {
                count++;
            }
        }
        return count;
    }

    public int count(String s) {
        int segs = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != ' ') segs++;
            while (i < chars.length && chars[i] != ' ') i++;
        }
        return segs;
    }

    public static void main(String[] args) {
        Solution434 solution434 = new Solution434();
        System.out.println(solution434.count(", , , , er, ege"));
    }
}
