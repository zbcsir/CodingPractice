package algorithm.listarray;

import java.util.Comparator;
import java.util.PriorityQueue;

// leetcode 23 �ϲ�K����������
public class MergeKList {
    // �������ȶ���ʵ��
    private static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queen = new PriorityQueue<>((a, b) -> a.val - b.val);
        // ���ֱȽϷ�ʽ�����������
//        PriorityQueue<ListNode> queen = new PriorityQueue<>(Comparator.comparing(a -> a.val));
        if (lists.length == 0)
            return null;
        if (lists.length == 1)
            return lists[0];
        for (ListNode list : lists) {
            if (list == null) continue;
            queen.add(list);
        }
        ListNode mergedHead = new ListNode(0);
        ListNode merged = mergedHead;
        while (!queen.isEmpty()) {
            ListNode minNode = queen.poll();
            merged.next = minNode;
            if (minNode.next != null) {
                queen.add(minNode.next);
            }
            merged = merged.next;
        }
        return mergedHead.next;
    }

    private static ListNode[] buildKLists(int[][] a) {
        ListNode[] heads = new ListNode[a.length];
        for (int i = 0; i < a.length; i++) {
            if (a[i].length == 0)
                continue;
            ListNode head = new ListNode(a[i][0]);
            ListNode cursor = head;
            if (a[i].length > 1) {
                for (int j = 1; j < a[i].length; j++) {
                    cursor.next = new ListNode(a[i][j]);
                    cursor = cursor.next;
                }
                cursor.next = null;
            }
            heads[i] = head;
        }
        return heads;
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 4}, {5}, {1, 3, 4}, {2, 6}};
        ListNode[] lists = buildKLists(arr);
        ListNode mergedList = mergeKLists(lists);
        while (mergedList != null) {
            System.out.print(mergedList.val + " -> ");
            mergedList = mergedList.next;
        }
        System.out.print("null");
        System.out.println();
    }

}
