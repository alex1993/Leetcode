package solution000_099.solution065;

/**
 * Script Created by daidai on 2017/5/28.
 */
public class Solution {
    public boolean isNumber(String s) {
        try {
            double v = Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isNumber("1e10"));
    }
}
