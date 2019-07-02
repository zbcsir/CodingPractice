package algorithm.listarray;

public class AddTwoNumbers {
    /**
     * Leetcode 2 �������
     * ��Ŀ���������������ǿյ�����������ʾ�����Ǹ������������У����Ǹ��Ե�λ���ǰ���
     * ����ķ�ʽ�洢�ģ��������ǵ�ÿ���ڵ�ֻ�ܴ洢һλ���֡�
     * ��������ǽ��������������������᷵��һ���µ���������ʾ���ǵĺ͡�
     *
     * @param l1  �洢��һ����������
     * @param l2  �洢�ڶ�����������
     * @return  ��ʾ�����͵�����
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
