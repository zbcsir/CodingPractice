package algorithm;

import java.util.PriorityQueue;
import java.util.Scanner;

// 阿里实习生笔试第一题
public class Alo1 {

    static String calculate(int m, int k) {
        return "test";
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String[] line = in.nextLine().split(",");
        int m = Integer.valueOf(line[0]);
        int k = Integer.valueOf(line[1]);
        int no = fun(m);
        int year = getYear(m);
        System.out.println(no + "," + (2019 + year) + "," + getAwardId(m, k));
    }

    // 计算在哪一年出生
    static private int getYear(int m) {
        int i = 1;
        int a1 = 2;
        int a2 = 3;
        int a3 = 4;
        int sum = 0;
        for (;sum <= m; i++) {
            sum = a1 + a2;
            a1 = a2;
            a2 = a3;
            a3 = sum;
        }
        return i - 2;
    }

    static private int reverseNu(int nu) {
        String str = String.valueOf(nu);
        return Integer.valueOf(new StringBuffer(str).reverse().toString());
    }

    // 计算获奖鸡id
    static private int getAwardId(int m, int k) {
        int[] arr = new int[m];
        for (int i=0; i<m; i++) {
            arr[i] = fun(i+1);
        }
        for (int i=0; i<m; i++) {
            arr[i] = reverseNu(arr[i]);
        }

        return biSearch(arr, findKthLargest(arr, k));
    }

    private static int biSearch(int []array,int a){
        int lo=0;
        int hi=array.length-1;
        int mid;
        while(lo<=hi){
            mid=(lo+hi)/2;
            if(array[mid]==a){
                return mid+1;
            }else if(array[mid]<a){
                lo=mid+1;
            }else{
                hi=mid-1;
            }
        }
        return -1;
    }

    private static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>(k);
        for (int i : nums) {
            q.offer(i);
            if (q.size() > k) {
                q.poll();
            }
        }
        return q.peek();
    }

    static private int fun(int m) {
        if (m == 1)
            return 2;
        else if (m == 2)
            return 3;
        else if (m == 3)
            return 4;
        else if (m < 0)
            return 0;
        else
            return fun(m-2) + fun(m-3);
    }
}
