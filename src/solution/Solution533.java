package solution;

import java.util.ArrayList;
import java.util.List;

/**
 * Script Created by daidai on 2017/3/5.
 */
public class Solution533 {
    public int findBlackPixel(char[][] picture, int N) {
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
        List<Integer> rowIndex = new ArrayList<>();
        for (int i : rowCount) {
            if (i == N) {
                rowIndex.add(i);
            }
        }

        List<Integer> colIndex = new ArrayList<>();
        for (int i : colCount) {
            if (i == N) {
                colIndex.add(i);
            }
        }

        for (Integer col : colIndex) {
            char[] cmp = new char[picture[0].length];
            boolean flag = false;
            for (int i = 0; i < picture.length; i++) {
                if (picture[i][col] == 'B') {
                    if (rowIndex.contains(i) && !flag) {
                        for (char c : picture[i]) {
                            cmp[c] = c;
                        }
                        flag = true;
                    }
                }
            }
        }
        return 0;
    }
}
