package solution600_699.solution649;

/**
 * Script Created by daidai on 2017/7/30.
 */
public class Solution {
    public String predictPartyVictory(String senate) {
        int countR = 0;
        for (char c : senate.toCharArray()) {
            if (c == 'R') {
                countR++;
            } else {
                countR--;
            }
        }
        return (countR > 0 || (countR == 0 && senate.startsWith("R"))) ? "Radiant" : "Dire";
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.predictPartyVictory("RD"));
    }
}
