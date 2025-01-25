package zero.twopointer;

import base.ListNode;

/**
 * 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
 * 示例 1：
 * 输入：head = [1,2,3,3,4,4,5]
 * 输出：[1,2,5]
 * <p>
 * 示例 2：
 * 输入：head = [1,1,1,2,3]
 * 输出：[2,3]
 * <p>
 * 提示：
 * 链表中节点数目在范围 [0, 300] 内
 * -100 <= Node.val <= 100
 * 题目数据保证链表已经按升序 排列
 */
public class DeleteDuplicates_82 {
    /**
     * 思路
     * 1.拆解为两个链表，一个重复，一个不重复，返回不重复的链表
     */
    public ListNode deleteDuplicates(ListNode head) {
        // 将原链表分解为两条链表
        // 一条链表存放不重复的节点，另一条链表存放重复的节点
        // 运用虚拟头结点技巧，题目说了 node.val <= 100，所以用 101 作为虚拟头结点
        ListNode dummyUniq = new ListNode(-1);
        ListNode dummyDup = new ListNode(-1);

        ListNode pUniq = dummyUniq, pDup = dummyDup;
        ListNode p = head;

        while (p != null) {
            if ((p.next != null && p.val == p.next.val) || p.val == pDup.val) {
                // 发现重复节点，接到重复链表后面
                pDup.next = new ListNode(p.val);
                pDup = pDup.next;
            } else {
                // 不是重复节点，接到不重复链表后面
                pUniq.next = new ListNode(p.val);
                pUniq = pUniq.next;
            }
            p = p.next;
        }
        return dummyUniq.next;
    }
}
