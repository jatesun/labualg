package zero.twopointer;

import base.ListNode;

/**
 * 给你单链表的头结点 head ，请你找出并返回链表的中间结点。
 * <p>
 * 如果有两个中间结点，则返回第二个中间结点。
 * <p>
 * 示例 1：
 * 输入：head = [1,2,3,4,5]
 * 输出：[3,4,5]
 * 解释：链表只有一个中间结点，值为 3 。
 * <p>
 * 示例 2：
 * 输入：head = [1,2,3,4,5,6]
 * 输出：[4,5,6]
 * 解释：该链表有两个中间结点，值分别为 3 和 4 ，返回第二个结点。
 * <p>
 * 提示：
 * <p>
 * 链表的结点数范围是 [1, 100]
 * 1 <= Node.val <= 100
 */
public class MiddleNode_876 {
    /**
     * 链表中间节点，可以使用快慢指针实现，快指针走两步，慢指针走一步。
     * 快指针结束了返回慢指针即可。
     */
    public ListNode middleNode(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {//快指针为主，因为快指针走两步，所以要看两个
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
