package indeed;

import java.util.*;

/**
 * Script Created by daidai on 2017/5/27.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();

        TreeNode[] root = new TreeNode[N + 1];
        root[0] = new TreeNode();
        root[0].val = 1;
        for (int i = 0; i < N; i++) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            if (l != 0) {
                int left = 2 * i + 1;
                root[left] = new TreeNode();
                root[left].val = l;
                root[i].left = root[left];
            }
            if (r != 0) {
                int right = 2 * i + 2;
                root[right] = new TreeNode();
                root[right].val = r;
                root[i].right = root[right];
            }
        }
        List<Character> res = new ArrayList<>();
        List<Character> fin = new ArrayList<>();
        backTracking(root[0], res, fin, K);
        System.out.println(fin);
    }

    public static void backTracking(TreeNode root, List<Character> res, List<Character> fin, int target) {
        if (root.val == target) {
            fin.addAll(res);
        }
        if (root.left != null) {
            res.add('L');
            backTracking(root.left, res, fin, target);
            res.remove(res.size() - 1);
        }
        if (root.right != null) {
            res.add('R');
            backTracking(root.right, res, fin, target);
            res.remove(res.size() - 1);
        }
    }


    static class TreeNode {
        public Integer val;
        public TreeNode left;
        public TreeNode right;

    }
}

