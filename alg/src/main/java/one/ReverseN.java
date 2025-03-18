package one;

import base.ListNode;

/**
 * 反转链表前 N 个节点
 */
public class ReverseN {
    public ListNode reverseList(ListNode head, int n) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre, cur, nxt;
        pre = null;
        cur = head;
        nxt = head.next;
        while (n > 0) {
            cur.next = pre;
            pre = cur;
            cur = nxt;
            if (nxt != null) {
                nxt = nxt.next;
            }
            n--;
        }
        // 此时的 cur 是第 n + 1 个节点，head 是反转后的尾结点
        head.next = cur;

        // 此时的 pre 是反转后的头结点
        return pre;
    }
}
