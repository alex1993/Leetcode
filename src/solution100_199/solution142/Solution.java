package solution100_199.solution142;

/**
 * Script Created by daidai on 2017/8/10.
 */

import structure.ListNode;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    //假设slow走了 k 步，两者相遇，则 fast 走了 2k
    // 2k - k = a * m (m是环的大小) --   k = am
    //slow 总共走的 k 步，又可以转换成 k = t + bm
    //t 是从起始点走向相遇点的长度，因而得到 t = (a - b)m
    //如果相遇点距离环的起点为 n，则 s = t - n = (a - b)m - n
    //因此如果再有一个点从起始点开始走 s，另一个点从相遇点开始走
    //有 (a - b)m - n = s，走到了相遇点，另一个点有 n + (a - b)m - n正好走完若干圈
    //因此两者又在交点相遇
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                ListNode slow2 = head;
                while (slow != slow2) {
                    slow = slow.next;
                    slow2 = slow2.next;
                }
                return slow2;
            }
        }
        return null;
    }

}
