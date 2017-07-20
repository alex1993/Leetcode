package solution000_099.solution099;

import structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Script Created by daidai on 2017/6/11.
 */
public class Solution {

    public void recoverTree(TreeNode root) {
        List<TreeNode> mid = new ArrayList<>();
        midOrder(root, mid);

        boolean first = true;
        TreeNode[] mistakes = new TreeNode[2];
        for (int i = 0; i < mid.size(); i++) {
            if (i + 1 < mid.size() && mid.get(i).val > mid.get(i + 1).val) {
                if (first) {
                    mistakes[0] = mid.get(i);
                    mistakes[1] = mid.get(i + 1);
                    first = false;
                } else {
                    mistakes[1] = mid.get(i + 1);
                }
            }
        }

        int tmp = mistakes[0].val;
        mistakes[0].val = mistakes[1].val;
        mistakes[1].val = tmp;
    }

    private void midOrder(TreeNode root, List<TreeNode> mid) {
        if (root == null) {
            return;
        }
        midOrder(root.left, mid);
        mid.add(root);
        midOrder(root.right, mid);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode treeNode = TreeNode.parse(new Integer[]{5, 7, 3, 1, 4, 6, 9, null, 2});
        TreeNode.levelPrint(treeNode);
        solution.recoverTree(treeNode);
        TreeNode.levelPrint(treeNode);
    }
}
