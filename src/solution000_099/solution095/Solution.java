package solution000_099.solution095;

import structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Script Created by daidai on 2017/3/23.
 */
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        return genTrees(1, n);
    }

    private List<TreeNode> genTrees(int s, int e) {
        List<TreeNode> list = new ArrayList<>();
        if (s > e) {
            list.add(null);
            return list;
        }
        if (s == e) {
            list.add(new TreeNode(s));
            return list;
        }

        for (int i = s; i <= e; i++) {
            List<TreeNode> leftTree = genTrees(s, i - 1);
            List<TreeNode> rightTree = genTrees(i + 1, e);
            for (TreeNode lNode : leftTree) {
                for (TreeNode rNode : rightTree) {
                    TreeNode node = new TreeNode(i);
                    node.left = lNode;
                    node.right = rNode;
                    list.add(node);
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.generateTrees(0));
    }

}
