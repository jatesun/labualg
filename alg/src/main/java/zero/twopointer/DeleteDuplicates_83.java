package zero.twopointer;

import base.ListNode;

import java.util.Arrays;

/**
 * 给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
 * 示例 1：
 * 输入：head = [1,1,2]
 * 输出：[1,2]
 * <p>
 * 示例 2：
 * 输入：head = [1,1,2,3,3]
 * 输出：[1,2,3]
 * <p>
 * 提示：
 * <p>
 * 链表中节点数目在范围 [0, 300] 内
 * -100 <= Node.val <= 100
 * 题目数据保证链表已经按升序 排列
 */
public class DeleteDuplicates_83 {
    public static void main(String[] args) {
        ListNode source = PointerUtils.generate(Arrays.asList(1, 1, 2));
        DeleteDuplicates_83 deleteDuplicates83 = new DeleteDuplicates_83();
        PointerUtils.print(deleteDuplicates83.deleteDuplicates(source));
    }

    /**
     * 思路
     * head与head.next对比即可，相同，删除head.next.不同移位。
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;

    }
}












