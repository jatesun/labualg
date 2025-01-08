package zero.twopointer;

import base.ListNode;

/**
 * 21.合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 * 示例 2：
 * <p>
 * 输入：l1 = [], l2 = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：l1 = [], l2 = [0]
 * 输出：[0]
 * <p>
 * 提示：
 * <p>
 * 两个链表的节点数目范围是 [0, 50]
 * -100 <= Node.val <= 100
 * l1 和 l2 均按 非递减顺序 排列
 */
public class mergeTwoLists_21 {
    /**
     * 整体的思路，维护两个指针，比较大小，知道两个链表都结束。
     * 考虑的四种情况：
     * 1.两个链表都为null，直接返回
     * 2.有一个为Null，结果节点next为非空节点
     * 3.都不为空，while循环
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode virtual = new ListNode(-1);//定义虚拟节点，这是链表算法经常用到的手段
        ListNode p = virtual;//运算节点，因为链表需要不断增加，需要头节点。ps：不直接用virtual因为最后需要返回结果
        ListNode p1 = list1;//两个链表都重新改名，没有什么特殊含义，习惯
        ListNode p2 = list2;
        while (p1 != null && p2 != null) {//先考虑大部分的情况，两个都不为空。不会优先处理特殊情况
            // 比较 p1 和 p2 两个指针
            // 将值较小的的节点接到 p 指针
            if (p1.val > p2.val) {
                p.next = p2;
                p2 = p2.next;
            } else {
                p.next = p1;
                p1 = p1.next;
            }
            // p 指针不断前进
            p = p.next;
        }
        if (p1 != null) {
            p.next = p1;
        }

        if (p2 != null) {
            p.next = p2;
        }
        return virtual.next;//返回虚拟节点的下一个节点才是结果节点
    }
}
















