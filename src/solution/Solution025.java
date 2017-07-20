package solution;

import structure.ListNode;

/**
 * Script Created by daidai on 2017/2/18.
 */
public class Solution025 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur = head;
        int count = 0;
        while (cur != null && count != k) {
            count += 1;
            cur = cur.next;
        }
        if (count == k) {
            cur = reverseKGroup(cur, k);
            while (count > 0) {
                ListNode tmp = head.next;
                head.next = cur;
                cur = head;
                head = tmp;
                count--;
            }
            head = cur;
        }
        return head;
    }

    public ListNode reverse(ListNode head, int k) {
        if (head == null || head.next == null || k < 2)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode tail = dummy, prev = dummy, temp;
        int count;
        while (true) {
            count = k;
            while (count > 0 && tail != null) {
                count--;
                tail = tail.next;
            }
            if (tail == null) {
                break;
            }

            head = prev.next;
            while (prev.next != tail) {
                temp = prev.next;
                prev.next = temp.next;

                temp.next = tail.next;
                tail.next = temp;
            }
            tail = head;
            prev = head;
        }
        return dummy.next;
    }

    public ListNode countK(final ListNode tmpHead, int k) {
        ListNode cur = tmpHead;
        int count = 0;
        while (cur != null) {
            count += 1;
            cur = cur.next;
            if (count >= k) {
                break;
            }
        }
        if (count == k) {
            return cur;
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        Solution025 solution025 = new Solution025();
        int[] nums = new int[]{1, 2, 3, 4, 5};
        ListNode listNode = ListNode.parse(nums);
        ListNode result = solution025.reverse(listNode, 2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
