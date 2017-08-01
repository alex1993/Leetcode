package solution300_399.solution383;

/**
 * Script Created by daidai on 2017/7/31.
 */
public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] hash = new int[128];
        for (char c : magazine.toCharArray()) {
            hash[c]++;
        }
        for (char c : ransomNote.toCharArray()) {
            hash[c]--;
            if (hash[c] < 0) {
                return false;
            }
        }
        return true;
    }
    

}
