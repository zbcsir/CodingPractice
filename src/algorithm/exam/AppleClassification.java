package algorithm.exam;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 网易编程题-丰收
 * <p>
 *     又到了丰收的季节，恰逢小易去牛牛的果园里游玩。
 *     牛牛常说他对整个果园的每个地方都了如指掌，小易不太相信，所以他想考考牛牛。
 *     在果园里有N堆苹果，每堆苹果的数量为ai，小易希望知道从左往右数第x个苹果是属于哪一堆的。
 * </p>
 * <p>
 *     输入：
 *     第一行一个数n(1 <= n <= 105)。
 *     第二行n个数ai(1 <= ai <= 1000)，表示从左往右数第i堆有多少苹果
 *     第三行一个数m(1 <= m <= 105)，表示有m次询问。
 *     第四行m个数qi，表示小易希望知道第qi个苹果属于哪一堆。
 *
 *     输出：
 *     m行，第i行输出第qi个苹果属于哪一堆。
 * </p>
 */
public class AppleClassification {
    private static void appleClass(int[] a, int[] q) {
        HashMap<Integer, Integer> appleClass = new HashMap<>();
        int idx = 1;
        int cate = 1;
        for (int i : a) {
            for (int j = idx; j < idx + i; j++) {
                appleClass.put(j, cate);
            }
            idx += i;
            ++ cate;
        }
        for (int i : q) {
            System.out.println(appleClass.get(i));
        }
    }

    private static void appleClass2(int[] a, int[] q) {
        HashMap<Integer, Integer> appleClass = new HashMap<>();
        int cate = 1;
        int sumApple = 0;
        for (int i : a) {
            sumApple += i;
            appleClass.put(cate, sumApple);
            ++ cate;
        }
        int numClass = a.length;
        for (int i : q) {
            for (int j = 1; j <= numClass; j++) {
                if (i <= appleClass.get(j)) {
                    System.out.println(j);
                    break;
                }
            }
        }
    }

    private static void appleClass3(int[] a, int[] q) {
        int sumApple = 0;
        for (int i : a) {
            sumApple += i;
        }
        HashMap<Integer, Integer> appleClass = new HashMap<>(sumApple);
        int appleCur = 0;
        for (int i = 1, c = 0; i <= sumApple; i++) {
            if (i > a[c] + appleCur) {
                appleCur += a[c];
                ++ c;
            }
            appleClass.put(i, c+1);
        }
        for (int i : q) {
            System.out.println(appleClass.get(i));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line1 = scanner.nextLine();
        String line2 = scanner.nextLine();
        String line3 = scanner.nextLine();
        String line4 = scanner.nextLine();
        String[] line1Arr = line1.split(" ");
        String[] line2Arr = line2.split(" ");
        String[] line3Arr = line3.split(" ");
        String[] line4Arr = line4.split(" ");
        int n = Integer.parseInt(line1Arr[0]);
        int m = Integer.parseInt(line3Arr[0]);
        int[] a = new int[n];
        int[] q = new int[m];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(line2Arr[i]);
        }
        for (int i = 0; i < m; i++) {
            q[i] = Integer.parseInt(line4Arr[i]);
        }
        appleClass3(a, q);
    }
}
