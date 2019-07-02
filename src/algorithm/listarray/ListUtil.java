package algorithm.listarray;

/**
 * �������࣬���һЩ����Ĺ�������
 */

public class ListUtil {

    /**
     * ����������������
     * @param nums  ����value��ɵ�����
     * @return �����һ��Ԫ��
     */
    public static ListNode getList(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        ListNode listHead = new ListNode(-1);
        ListNode cur = listHead;
        for (int num : nums) {
            cur.next = new ListNode(num);
            cur = cur.next;
        }
        return listHead.next;
    }

    public static void printList(ListNode L) {
        ListNode cur = L;
        StringBuilder res = new StringBuilder();
        while (cur != null) {
            res.append(cur.val);
            res.append(" -> ");
            cur = cur.next;
        }
        System.out.println(res.toString());
    }
}
