package solution000_099.solution042;

import java.util.Stack;

/**
 * Script Created by daidai on 2017/8/7.
 */
public class Solution {
    //分别记录左边和右边的最大值，要是左边的最大值要比右边的更小，那么可以在左边积累水
    //积累的水的高度是 leftMax - height[i]，因为可以保证当前当前的水可以被 leftMax 和 rightMax 包围
    public int trap(int[] height) {
        int leftMax = 0, rightMax = 0;
        int max = 0;
        int i = 0, j = height.length - 1;
        while (i < j) {
            if (height[i] > leftMax) {
                leftMax = height[i];
            }
            if (height[j] > rightMax) {
                rightMax = height[j];
            }
            if (leftMax < rightMax) {
                max += leftMax - height[i];
                i++;
            } else {
                max += rightMax - height[j];
                j--;
            }
        }
        return max;
    }

    public int solve(int[] height) {
        //stack用于记录 height 的 index
        //如果发现当前的值要比栈更小，那么 push，说明这根柱子可能有积水
        //如果发现当前值更大，那么把栈中比这个值要更小的都 pop 出来，记录水的高度
        Stack<Integer> stack = new Stack<>();
        int current = 0;
        int res = 0;
        while (current < height.length) {
            //栈不为空，并且当前的高度比栈顶高，有可能有积水
            while (!stack.isEmpty() && height[stack.peek()] < height[current]) {
                Integer index = stack.pop();
                //pop之后发现栈空了，其实没有积水
                if (stack.isEmpty()) {
                    break;
                }
                //长度是当前的位置和栈顶之间的距离
                int distance = current - stack.peek() - 1;
                //能够填充的水的高度是 当前和栈顶中较低的那个和当前高度的差值
                int boundedHeight = Math.min(height[current], height[stack.peek()]) - height[index];
                res += distance * boundedHeight;
            }
            //水增高，继续push
            stack.push(current++);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solve(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}
