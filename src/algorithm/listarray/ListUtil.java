package algorithm.listarray;

/**
 * 链表工具类，存放一些链表的公共方法
 */

public class ListUtil {

    /**
     * 根据数组生成链表
     * @param nums  链表value组成的数组
     * @return 链表第一个元素
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
