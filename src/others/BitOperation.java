package others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 位运算练习
public class BitOperation {
    // 使用位运算交换两个数
    private static void swap(int a, int b) {
        System.out.println("======before swapping======");
        System.out.println("a = " + a + "\t" + "b = " + b);
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("======after swapping======");
        System.out.println("a = " + a + "\t" + "b = " + b);
    }

    // 找出只出现一次的数
    private static void findOnceNum(int[] nums) {
        if (nums.length < 1)
            return ;
        int t = nums[0];
        for (int i = 1; i < nums.length; i++) {
            t = t ^ nums[i];
        }
        System.out.println(t);
    }

    // 求解m的n次方
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

    // 判断一个元素是否出现在一组数中（基于位图）
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

    // 移位练习
    // flag： true表示左移，false表示右移
    private static int moveBit(int num, int nbit, boolean flag) {
        if (flag)
            return num << nbit;
        return num >> nbit;
    }

    // 把给定数二进制第一个1后面的数都变为1
    private static int toOne(int num) {
        num |= num >> 1;
        num |= num >> 2;
        num |= num >> 4;
        return num;
    }

    // 找出不大于n的2的指数
    private static int findN(int n) {
        int num = toOne(n);
        num |= num >> 8; // 针对n正好为2的大于8的整数次幂的情况起作用
        num = (num >> 1) + 1;
        System.out.println(num);
        int exp = 0;
        while (num > 0) {
            num = num >> 1;
            if (num > 0)
                exp++;
        }
        return exp;
    }

    public static void main(String[] args) {
        swap(3,5);
        int[] nums = {1, 2, 3, 4, 5, 1, 2, 3, 4};
        findOnceNum(nums);
        powMN(2, 10);
        Integer[] arr = generateNums(1000000);
        System.out.println(isFound(arr, 300));
        System.out.println(isFound(arr, 3100));
        System.out.println(findN(64));
        System.out.println(findN(2048));
    }
}
