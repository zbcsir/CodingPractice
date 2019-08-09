package test;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * HashSet一般来说是无序的，但是也存在一种情况是可能有序的：
 * 当HashSet存放的值是整型，且存放的值个数不超过HashSet的初始容量时，HashSet是有序的
 */
public class TestHashset {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>(100);
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            set.add(random.nextInt(100));
        }
        for (int i : set) {
            System.out.print(i + "\t");
        }
    }
}
