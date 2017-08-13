package solution100_199.solution117;

/**
 * Script Created by daidai on 2017/8/2.
 */
class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;

    TreeLinkNode(int x) {
        val = x;
    }
}

public class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode head = root;
        TreeLinkNode prev = null;
        TreeLinkNode cur = null;
        while (head != null) {
            //当前访问的节点，下一层的previous点，下一层的头节点
            cur = head;
            prev = null;
            head = null;
            while (cur != null) {
                if (cur.left != null) {
                    if (prev != null) {
                        prev.next = cur.left;
                    } else {
                        head = cur.left;
                    }
                    prev = cur.left;
                }
                if (cur.right != null) {
                    if (prev != null) {
                        prev.next = cur.right;
                    } else {
                        head = cur.right;
                    }
                    prev = cur.right;
                }
                cur = cur.next;
            }
        }
    }
}
