package zero.twopointer;

import base.ListNode;

import java.util.Arrays;
import java.util.List;

public class PointerUtils {
    public static void main(String[] args) {
        ListNode p1 = PointerUtils.generate(Arrays.asList(1,5,6,9,4));
        PointerUtils.print(p1);
    }
    public static void print(ListNode node) {
        ListNode node1 = node;
        while (node1 != null) {
            System.out.println(node1.val);
            node1 = node1.next;
        }
    }

    public static ListNode generate(List<Integer> list) {
        ListNode first = new ListNode(list.get(0));
        ListNode cur = first;
        for (int i = 1; i < list.size(); i++) {
            cur.next = new ListNode(list.get(i));
            cur = cur.next;
        }
        return first;
    }
}
