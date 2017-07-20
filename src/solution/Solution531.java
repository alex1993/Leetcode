package solution;

/**
 * Script Created by daidai on 2017/3/5.
 */
public class Solution531 {
    public int findLonelyPixel(char[][] picture) {
        int[] rowCount = new int[picture.length];
        int[] colCount = new int[picture[0].length];
        for (int i = 0; i < picture.length; i++) {
            for (int j = 0; j < picture[i].length; j++) {
                if (picture[i][j] == 'B') {
                    rowCount[i]++;
                    colCount[j]++;
                }
            }
        }
        int result = 0;
        for (int i = 0; i < picture.length; i++) {
            for (int j = 0; j < picture[i].length; j++) {
                if (picture[i][j] == 'B') {
                    if (rowCount[i] == 1 && colCount[j] == 1) {
                        result++;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        char[][] picture = new char[3][3];
        picture[0] = new char[] {'W', 'W', 'B'};
        picture[1] = new char[] {'W', 'B', 'W'};
        picture[2] = new char[] {'B', 'W', 'W'};
        Solution531 solution531 = new Solution531();
        System.out.println(solution531.findLonelyPixel(picture));
    }
}
