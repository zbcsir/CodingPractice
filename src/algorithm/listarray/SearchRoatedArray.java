package algorithm.listarray;

/**
 * Leetcode 33 ������ת��������
 * ���谴�����������������Ԥ��δ֪��ĳ�����Ͻ�������ת
 * ����һ��������Ŀ��ֵ����������д������Ŀ��ֵ���򷵻��������������򷵻� -1
 *
 * ˼·�����ҵ���תλ�ý�ԭ���鿴�������֣����жϴ�����������λ���������е���һ���֣�
 *      Ȼ���ڿ��ܴ��ڵĲ���ִ�ж��ֲ���
 */
public class SearchRoatedArray {
    private static int search(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return -1;
        }
        if (len == 1) {
            if (nums[0] == target) {
                return 0;
            }
            else {
                return -1;
            }
        }
        if (nums[0] < nums[len-1]) {
            return binarySearch(nums, 0, len-1, target);
        } else {
            int rotateIdx = -1;
            for (int i = 0; i < len-1; i++) {
                if (nums[i] == target) {
                    return i;
                }
                if (nums[i] > nums[i+1]) {
                    rotateIdx = i;
                    break;
                }
            }
            if (target < nums[0] && target > nums[len-1]) {
                return binarySearch(nums, 0, rotateIdx, target);
            } else {
                return binarySearch(nums, rotateIdx+1, len-1, target);
            }
        }
    }

    private static int binarySearch(int[] nums, int low, int high, int x) {
        if (low == high) {
            return nums[low] == x ? low : -1;
        }
        while (low <= high) {
            int mid = low + ((high - low) >>> 1);
            if (nums[mid] == x) {
                return mid;
            } else if (nums[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums1 = {4,5,6,7,0,1,2};
        int[] nums = {3,1};
        System.out.println(search(nums, 0));
        System.out.println(search(nums, 3));
    }
}
