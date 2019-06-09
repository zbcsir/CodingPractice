package others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// λ������ϰ
public class BitOperation {
    // ʹ��λ���㽻��������
    private static void swap(int a, int b) {
        System.out.println("======before swapping======");
        System.out.println("a = " + a + "\t" + "b = " + b);
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("======after swapping======");
        System.out.println("a = " + a + "\t" + "b = " + b);
    }

    // �ҳ�ֻ����һ�ε���
    private static void findOnceNum(int[] nums) {
        if (nums.length < 1)
            return ;
        int t = nums[0];
        for (int i = 1; i < nums.length; i++) {
            t = t ^ nums[i];
        }
        System.out.println(t);
    }

    // ���m��n�η�
    private static void powMN(int m, int n) {
        int res = 1;
        int tmp = m;
        int exp = n;
        while (n > 0) {
            if ((n & 1) == 1)
                res = res * tmp;
            tmp *= tmp;
            n = n >> 1;
        }
        System.out.println("pow(" + m + "," + exp + ") = " + res);
    }

    // �ж�һ��Ԫ���Ƿ������һ�����У�����λͼ��
    private static boolean isFound(Integer[] nums, int e) {
        Bitmap bitmap = new Bitmap(nums.length);
        for (int num : nums) {
            bitmap.addElem(num);
        }
        return bitmap.found(e);
    }

    private static Integer[] generateNums(int n) {
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i % 3 == 0) {
                nums.add(i);
            }
        }
        return nums.toArray(new Integer[nums.size()]);
    }

    public static void main(String[] args) {
        swap(3,5);
        int[] nums = {1, 2, 3, 4, 5, 1, 2, 3, 4};
        findOnceNum(nums);
        powMN(2, 10);
        Integer[] arr = generateNums(1000000);
        System.out.println(isFound(arr, 300));
        System.out.println(isFound(arr, 3100));
    }
}
