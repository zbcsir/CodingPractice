package algorithm.listarray;

public class AddTwoNumbers {
    /**
     * Leetcode 2 两数相加
     * 题目描述：给出两个非空的链表用来表示两个非负的整数。其中，它们各自的位数是按照
     * 逆序的方式存储的，并且它们的每个节点只能存储一位数字。
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     *
     * @param l1  存储第一个数的链表
     * @param l2  存储第二个数的链表
     * @return  表示两数和的链表
     */
    private ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1, p2 = l2;
        if ((l1 == null) && (l2 == null)) {
            return null;
        }
        if ((l1 == null) || (l2 == null)) {
            return l1 == null ? l2 : l1;
        }
        ListNode L = new ListNode(-1);
        ListNode p = L;
        boolean needPlus = false;
        while ((p1 !=  null) && (p2 != null)) {
            int addedVal = p1.val + p2.val;
            if (needPlus) {
                ++ addedVal;
            }
            ListNode tmp;
            if (addedVal < 10) {
                tmp = new ListNode(addedVal);
                needPlus = false;
            } else {
                tmp = new ListNode(addedVal % 10);
                needPlus = true;
            }
            p.next = tmp;
            p1 = p1.next;
            p2 = p2.next;
            p = p.next;
        }
        while (p1 != null) {
            int val = p1.val;
            if (needPlus) {
                val += 1;
            }
            ListNode tmp;
            if (val < 10) {
                tmp = new ListNode(val);
                needPlus = false;
            } else {
                tmp = new ListNode(val % 10);
                needPlus = true;
            }
            p.next = tmp;
            p1 = p1.next;
            p = p.next;
        }
        while (p2 != null) {
            int val = p2.val;
            if (needPlus) {
                val += 1;
            }
            ListNode tmp;
            if (val < 10) {
                tmp = new ListNode(val);
                needPlus = false;
            } else {
                tmp = new ListNode(val % 10);
                needPlus = true;
            }
            p.next = tmp;
            p2 = p2.next;
            p = p.next;
        }
        if (needPlus) {
            p.next = new ListNode(1);
        }
        return L.next;
    }

    public static void main(String[] args) {
        AddTwoNumbers atn = new AddTwoNumbers();
        int[] nums1 = { 4};
        int[] nums2 = {6};
        ListNode list1 = ListUtil.getList(nums1);
        ListNode list2 = ListUtil.getList(nums2);
        ListNode list = atn.addTwoNumbers(list1, list2);
        ListUtil.printList(list);
    }
}
