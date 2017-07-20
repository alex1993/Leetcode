package solution;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Script Created by daidai on 2017/3/15.
 */
public class Solution084 {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int max = -1;
        for (int i = 1; i <= heights.length; i++) {
            int area = largestForLengthI(heights, i);
            if (area > max) {
                max = area;
            }
        }
        return max;
    }

    private int largestForLengthI(int[] heights, int rectLength) {
        int max = -1;
        for (int fromIndex = 0; fromIndex <= (heights.length - rectLength); fromIndex++) {
            int min = minimum(heights, rectLength, fromIndex);
            if (min * rectLength > max) {
                max = min * rectLength;
            }
        }
        return max;
    }

    private int minimum(int[] heights, int length, int from) {
        int minHeight = Integer.MAX_VALUE;
        for (int i = 0; i < length; i++) {
            if (heights[from + i] < minHeight) {
                minHeight = heights[from + i];
            }
        }
        return minHeight;
    }

    public int largestRectangle(int[] heights) {
        int level = (int) (Math.log(heights.length) / Math.log(2));
        int maxSize = 2 * (int) (Math.pow(2, level)) - 1;
        TreeNode tree = buildSegTree(heights);
        return divideConquer(heights, 0, heights.length - 1, tree);
    }

    private int divideConquer(int[] heights, int start, int end, TreeNode tree) {
        if (start == end) {
            return heights[start];
        }
        if (start >= end) {
            return 0;
        }
//        int[] min = getMinIndex(heights, start, end);
        int minIndex = query(tree, heights, start, end);
        return max(divideConquer(heights, start, minIndex - 1, tree), divideConquer(heights, minIndex + 1, end, tree), (end - start + 1) * heights[minIndex]);
    }

    private int max(int a, int b, int c) {
        return Math.max(Math.max(a, b), c);
    }

    private TreeNode buildSegTree(int[] heights) {
        int level = (int) (Math.ceil(Math.log(heights.length) / Math.log(2)));
        int maxSize = 2 * (int) (Math.pow(2, level)) - 1;
        return buildSegTreeUtil(heights, 0, heights.length - 1);
    }

    private TreeNode buildSegTreeUtil(int[] heights, int start, int end) {
        if (start > end) {
            return null;
        }
        if (start == end) {
            TreeNode node = new TreeNode(start);
            node.start = start;
            node.end = end;
            return node;
        }
        int mid = start + (end - start) / 2;
        TreeNode left = buildSegTreeUtil(heights, start, mid);
        TreeNode right = buildSegTreeUtil(heights, mid + 1, end);
        int val = Math.min(left.min, right.min);
        TreeNode treeNode = new TreeNode(heights[left.min] < heights[right.min] ? left.min : right.min);
        treeNode.left = left;
        treeNode.right = right;
        treeNode.start = start;
        treeNode.end = end;
        return treeNode;
    }

    private int query(TreeNode root, int[] heights, int start, int end) {
        if (root == null || root.start > end || root.end < start) {
            return -1;
        }
        if (start <= root.start && end > root.end) {
            return root.min;
        }
        int leftMin = query(root.left, heights, start, end);
        int rightMin = query(root.right, heights, start, end);
        if (leftMin == -1) {
            return rightMin;
        }
        if (rightMin == -1) {
            return leftMin;
        }
        return heights[leftMin] < heights[rightMin] ? leftMin : rightMin;

    }

    public int maxArea(int[] heights) {
        int len = heights.length;
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        int maxArea = 0;
        while (i < len) {
            if (stack.empty() || heights[stack.peek()] <= heights[i]) {
                stack.push(i);
                i++;
            } else {
                int top = stack.pop();
                int area = heights[top] * (stack.empty() ? i : i - stack.peek() - 1);
                if (area > maxArea) {
                    maxArea = area;
                }
            }
        }
        while (!stack.empty()) {
            int top = stack.pop();
            int area = heights[top] * (stack.empty() ? i : i - stack.peek() - 1);
            if (area > maxArea) {
                maxArea = area;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        Solution084 solution084 = new Solution084();
        System.out.println(solution084.maxArea(new int[]{2, 1, 5, 6, 2, 3, 7}));
        System.out.println(solution084.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3, 7}));

        TreeNode treeNode = solution084.buildSegTree(new int[]{2, 1, 5, 6, 2, 3, 7});
        System.out.println(preOrder(treeNode));
    }

    private static List<Integer> preOrder(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        res.add(root.min);
        res.addAll(preOrder(root.left));
        res.addAll(preOrder(root.right));
        return res;
    }

    class TreeNode {
        int min;
        int start;
        int end;
        TreeNode left;
        TreeNode right;

        TreeNode(int min) {
            this.min = min;
        }
    }

}
