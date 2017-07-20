package structure;

/**
 * Script Created by daidai on 2017/2/18.
 */
//Definition for singly-linked list.
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "structure.ListNode{" +
                       "val=" + val +
                       '}';
    }

    public static ListNode parse(int[] ints) {
        ListNode head = null;
        ListNode tmp = null;
        for (int i = 0; i < ints.length; i++) {
            if (i == 0) {
                head = new ListNode(ints[i]);
                tmp = head;
            } else {
                tmp.next = new ListNode(ints[i]);
                tmp = tmp.next;
            }
        }
        return head;
    }

    public static void print(ListNode listNode) {
        if (listNode == null) {
            return;
        }
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1};
        ListNode listNode = ListNode.parse(nums);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
