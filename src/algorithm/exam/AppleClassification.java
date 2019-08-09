package algorithm.exam;

import java.util.HashMap;
import java.util.Scanner;

/**
 * ���ױ����-����
 * <p>
 *     �ֵ��˷��յļ��ڣ�ǡ��С��ȥţţ�Ĺ�԰�����档
 *     ţţ��˵����������԰��ÿ���ط�������ָ�ƣ�С�ײ�̫���ţ��������뿼��ţţ��
 *     �ڹ�԰����N��ƻ����ÿ��ƻ��������Ϊai��С��ϣ��֪��������������x��ƻ����������һ�ѵġ�
 * </p>
 * <p>
 *     ���룺
 *     ��һ��һ����n(1 <= n <= 105)��
 *     �ڶ���n����ai(1 <= ai <= 1000)����ʾ������������i���ж���ƻ��
 *     ������һ����m(1 <= m <= 105)����ʾ��m��ѯ�ʡ�
 *     ������m����qi����ʾС��ϣ��֪����qi��ƻ��������һ�ѡ�
 *
 *     �����
 *     m�У���i�������qi��ƻ��������һ�ѡ�
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
