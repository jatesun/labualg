package zero.twopointer;

import base.ListNode;

/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * <p>
 * 示例 1：
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * <p>
 * 示例 2：
 * 输入：head = [1], n = 1
 * 输出：[]
 * <p>
 * 示例 3：
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 * <p>
 * 提示：
 * <p>
 * 链表中结点的数目为 sz
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 * <p>
 * <p>
 * 进阶：你能尝试使用一趟扫描实现吗？
 */
public class RemoveNthFromEnd_19 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
//        ListNode node2 = new ListNode(2);
//        ListNode node3 = new ListNode(3);
//        ListNode node4 = new ListNode(4);
//        ListNode node5 = new ListNode(5);
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;

        RemoveNthFromEnd_19 removeNthFromEnd19 = new RemoveNthFromEnd_19();
        ListNode node = removeNthFromEnd19.removeNthFromEnd(node1, 1);
        removeNthFromEnd19.print(node);
    }

    /**
     * 本题其实也是快慢指针问题，也可以认为是滑动窗口问题
     * 1.快指针先移动n个位置，然后两个指针同时移动
     * 2.当快指针到最后一个位置，进行操作。
     * ps:这里也用到了虚拟头节点的技巧。更加方便的判断边界情况
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 虚拟头结点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        // 删除倒数第 n 个，要先找倒数第 n + 1 个节点
        ListNode x = findFromEnd(dummy, n + 1);
        // 删掉倒数第 n 个节点
        x.next = x.next.next;
        return dummy.next;
    }

    // 返回链表的倒数第 k 个节点
    ListNode findFromEnd(ListNode head, int k) {
        ListNode p1 = head;
        // p1 先走 k 步
        for (int i = 0; i < k; i++) {
            p1 = p1.next;
        }
        ListNode p2 = head;
        // p1 和 p2 同时走 n - k 步
        while (p1 != null) {
            p2 = p2.next;
            p1 = p1.next;
        }
        // p2 现在指向第 n - k + 1 个节点，即倒数第 k 个节点
        return p2;
    }

//    public ListNode removeNthFromEnd(ListNode head, int n) {
//        ListNode fast = head;
//        for (int i = 0; i < n; i++) {
//            if (fast == null) {
//                return head;
//            }
//            fast = fast.next;
//        }
//        ListNode slow = head;
//        while (fast != null) {
//            fast = fast.next;
//            if (fast != null) {
//                slow = slow.next;
//            }
//        }
//        if(slow.next == null){
//
//        }
//        slow.next = slow.next.next;
//        return head;
//    }

    public void print(ListNode node) {
        ListNode node1 = node;
        while (node1 != null) {
            System.out.println(node1.val);
            node1 = node1.next;
        }
    }
}



























