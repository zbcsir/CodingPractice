package algorithm.listarray;

public class SwapPairs {
    // Leetcode 24 两两交换链表中的节点
    // 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换
    private ListNode swapPairs(ListNode head) {
        ListNode a = new ListNode(-1);
        ListNode p = a;
        while (head != null) {
            if (head.next != null) {
                ListNode tmp = head.next;
                p.next = tmp;
                head.next = head.next.next;
                tmp.next = head;
                head = head.next;
                p = p.next.next;
            } else {
                p.next = head;
                head = head.next;
            }
        }
        return a.next;
    }

    // Leetcode 25 k个一组翻转链表
    // 尾插法
    private ListNode reverseKGroup(ListNode head, int k) {
        int id = 0;
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode pHead;
        ListNode pTail = dummyHead;
        ListNode prev = dummyHead;
        while (true) {
            while ((id < k) && (pTail != null)) {
                pTail = pTail.next;
                ++id;
            }
            if (pTail == null) break;
            pHead = prev.next;
            while (prev.next != pTail) {
                ListNode cur = prev.next;
                prev.next = cur.next;
                cur.next = pTail.next;
                pTail.next = cur;
            }
            prev = pHead;
            pTail = pHead;
            id = 0;
        }
        return dummyHead.next;
    }

    private void printList (ListNode head) {
        ListNode p = head;
        while (p != null) {
            System.out.print(p.val + "\t");
            p = p.next;
        }
    }

    private ListNode buildList (int[] nums) {
        ListNode head = new ListNode(-1);
        ListNode p = head;
        for (int num : nums) {
            p.next = new ListNode(num);
            p = p.next;
        }
        return head.next;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        SwapPairs sp = new SwapPairs();
        ListNode head = sp.buildList(nums);
        ListNode headSwaped = sp.swapPairs(head);
        ListNode headReversedK = sp.reverseKGroup(head, 2);
        sp.printList(headSwaped);
        sp.printList(headReversedK);
    }
}
