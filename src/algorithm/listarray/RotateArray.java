package algorithm.listarray;

// Leetcode ��ת����
// ����һ�����飬�������е�Ԫ�������ƶ� k ��λ�ã����� k �ǷǸ���
public class RotateArray {

    // �ռ临�Ӷ� O(n)
    // �¿���һ������
    private int[] rotateV1(int[] nums, int k) {
        int len = nums.length;
        if ((k == 0) || (len <= 1))
            return nums;
        int[] newNums = new int[len];
        for (int i = 0; i < len; i++) {
            int newIdx = (i + k) % len;
            newNums[newIdx] = nums[i];
        }
        return newNums;
    }

    // �ռ临�Ӷ� O(1)
    // ԭ���޸�
    private void rotateV2(int[] nums, int k) {
        int len = nums.length;
        if ((k == 0) || (len <= 1))
            return;
        int pre;
        int cur = nums[0];
        int idx = 0;
        int start = 0;
        for (int i = 0; i < len; i++) {
            pre = cur;
            idx = (idx + k) % len;
            cur = nums[idx];
            nums[idx] = pre;
            if ((idx == start) && (start < len-1)) {
                idx = ++start;
                cur = nums[idx];
            }
        }
    }

    // �ݹ�  ʱ�临�Ӷ� O(n)���ռ临�Ӷ� O(1)
    // ������ǰn-k��Ԫ�أ������ú�k��Ԫ�أ����������������
    private void rotate(int[] nums, int k) {
        int len = nums.length;
        if ((k == 0) || (len <= 1))
            return;
        k = k % len;
        reverse(nums, 0, len-k-1);
        reverse(nums, len-k, len - 1);
        reverse(nums, 0, len-1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = tmp;
        }
    }

    public static void main(String[] args) {
        RotateArray ra = new RotateArray();
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        ra.rotateV1(nums, 3);
        ra.rotateV2(nums, 3);
        ra.rotate(nums, 3);
    }
}
