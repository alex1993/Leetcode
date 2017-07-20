package solution500_599.solution547;

/**
 * Script Created by daidai on 2017/6/6.
 */
public class Solution {
    public int findCircleNum(int[][] M) {
        if (M == null || M.length == 0 || M[0].length == 0) {
            return 0;
        }
        UnionFind unionFind = new UnionFind(M.length);
        for (int i = 0; i < M.length; i++) {
            for (int j = i + 1; j < M[i].length; j++) {
                if (M[i][j] == 1) {
                    unionFind.union(i, j);
                }
            }
        }
        return unionFind.circle;
    }

    class UnionFind {
        int[] father;
        int circle;

        UnionFind(int n) {
            father = new int[n];
            for (int i = 0; i < father.length; i++) {
                father[i] = i;
            }
            circle = n;
        }

        int find(int n) {
            if (father[n] == n) {
                return n;
            }
            return find(father[n]);
        }

        void union(int n1, int n2) {
            int father1 = find(n1);
            int father2 = find(n2);
            if (father1 != father2) {
                father[father1] = father2;
                circle -= 1;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findCircleNum(new int[][]{
            {1, 1, 1},
            {1, 1, 1},
            {1, 1, 1}
        }));
    }
}
