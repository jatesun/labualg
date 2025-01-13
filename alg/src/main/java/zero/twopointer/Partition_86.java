package zero.twopointer;

import base.ListNode;

/**
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * <p>
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,4,3,2,5,2], x = 3
 * 输出：[1,2,2,4,3,5]
 * 示例 2：
 * <p>
 * 输入：head = [2,1], x = 2
 * 输出：[1,2]
 * <p>
 * 提示：
 * <p>
 * 链表中节点的数目在范围 [0, 200] 内
 * -100 <= Node.val <= 100
 * -200 <= x <= 200
 */
public class Partition_86 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(2);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        Partition_86 partition86 = new Partition_86();
        ListNode result = partition86.partition(node1, 3);
        partition86.print(result);
    }

    public void print(ListNode node) {
        ListNode node1 = node;
        while (node1 != null) {
            System.out.println(node1.val);
            node1 = node1.next;
        }
    }

    /**
     * 思路
     * 分析：需要注意的一点是，题目要求只要求小于目标x的排在x前，而且需要保留原有顺序，而不是排序。
     * 解体思路：
     * 我们可以采用两个链表，一个链表存小于x的，另一个存大于等于x，最后合并即可。
     */
    public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(-1);//存放小于x的链表
        ListNode dum = dummy;
        ListNode tmp = new ListNode(-1);//存放大于等于x的链表
        ListNode tm = tmp;
        while (head != null) {
            if (head.val < x) {
                dum.next = new ListNode(head.val);//构造小于x的链表
                dum = dum.next;
                head = head.next;
            } else {
                tm.next = new ListNode(head.val);//构造大于等于x的链表
                tm = tm.next;
                head = head.next;
            }
        }
        dum.next = tmp.next;//将大于等于x的链表合并到小于x的链表即可。
        return dummy.next;//返回结果
    }
}
































