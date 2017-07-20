package solution400_499.solution419;

/**
 * Script Created by daidai on 2017/4/16.
 */
public class Solution {
    public int countBattleships(char[][] board) {
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'X') {
                    for (int k = i + 1; k < board.length; k++) {
                        if (board[k][j] != 'X') {
                            break;
                        } else {
                            board[k][j] = '.';
                        }
                    }
                    for (int k = j + 1; k < board[0].length; k++) {
                        if (board[i][k] != 'X') {
                            break;
                        } else {
                            board[i][k] = '.';
                        }
                    }
                    count++;
                }
            }
        }

        return count;
    }

    public int countShips(char[][] board) {
        int res = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (i > 0 && board[i - 1][j] == 'X') {
                    continue;
                }
                if (j > 0 && board[i][j - 1] == 'X') {
                    continue;
                }
                res++;
            }
        }
        return res;
    }

    private char[][] parseString(String string) {
        String[] strings = string.split("\n");
        char[][] res = new char[strings.length][strings[0].length()];
        for (int i = 0; i < strings.length; i++) {
            String string1 = strings[i];
            res[i] = string1.toCharArray();
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countShips(solution.parseString("X..X\n" +
                                                                                  "...X\n" +
                                                                                  "...X")));
    }
}
