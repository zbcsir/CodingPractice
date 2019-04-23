package algorithm.listarray;

import java.util.PriorityQueue;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class MergeKList {

//   Definition for singly-linked list.

    private static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queen = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (int i = 0; i < lists.length; i++) {
            queen.offer(lists[i]);
//            lists[i] = lists[i].next;
        }
        if (queen.equals(null) || queen.size() == 0)
            return null;
        ListNode mergedHead = queen.peek();
        ListNode merged = mergedHead;
        while (!queen.isEmpty()) {
            ListNode minNode = queen.poll();
            if (minNode != null) {
                merged.next = minNode;
                merged = merged.next;
            }
            if (minNode.next != null) {
                queen.offer(minNode.next);
            }
            merged = merged.next;
        }
        return mergedHead;
    }

    public ListNode[] buildKLists(int[][] a) {
        ListNode[] heads = new ListNode[a.length];
        for (int i = 0; i < a.length; i++) {
            if (a[i].length == 0)
                continue;
            ListNode head = new ListNode(a[i][0]);
            if (a[i].length > 1) {
                for (int j = 0; j < a[i].length; j++) {
                    head.next = new ListNode(a[i][j]);
                }
            }
            heads[i] = head;
        }
        return heads;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ListNode list11 = new ListNode(1);
        ListNode list12 = new ListNode(4);
        list11.next = list12;
        ListNode list13 = new ListNode(5);
        list12.next = list13;
        list13.next = null;

        ListNode list21 = new ListNode(1);
        ListNode list22 = new ListNode(3);
        list21.next = list22;
        ListNode list23 = new ListNode(4);
        list22.next = list23;
        list23.next = null;

        ListNode list31 = new ListNode(2);
        ListNode list32 = new ListNode(6);
        list31.next = list32;
        list32.next = null;

        ListNode[] lists = new ListNode[3];
        lists[0] = list11;
        lists[1] = list21;
        lists[2] = list31;
        ListNode mergedList = mergeKLists(lists);
        while (mergedList != null) {
            System.out.print(mergedList.val + "\t");
            mergedList = mergedList.next;
        }
        System.out.println();
//        System.out.println(mergedList.val);
    }

}
