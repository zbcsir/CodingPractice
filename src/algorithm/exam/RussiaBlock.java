package algorithm.exam;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * ���ױ����-����˹����
 * <p>
 *     С����һ�����ϵ���Ϸ�����������ž������Ϸ����˹���顣��Ϊ���ȽϹ��ϣ����Թ����һ��Ķ���˹���鲻ͬ��
 *     ӫĻ��һ���� n �У�ÿ�ζ�����һ�� 1 x 1 �ķ���������£���ͬһ���У������µķ���������ǰ�ķ���֮�ϣ�
 *     ��һ���з��鶼��ռ��ʱ����һ�лᱻ��ȥ�����õ�1�֡���һ�죬С���ֿ���һ����Ϸ�����浽�� m ����������
 *     ʱ������̫���ľ͹ص��ˣ�С��ϣ��������������Ϸ����õķ�����
 * </p>
 * <p>
 *     ��һ�������� n, m
 *     �ڶ��� m ������c1, c2, ... , cm �� ci ��ʾ�� i ���������ڵڼ���
 *     ���� 1 <= n, m <= 1000, 1 <= ci <= n
 * </p>
 */
public class RussiaBlock {
    private static int getScore(int[] blocks, int n) {
        Map<Integer, Integer> numPerCol = new HashMap<>(n);
        int minNum = Integer.MAX_VALUE;
        for (int b : blocks) {
            if (numPerCol.containsKey(b)) {
                int num = numPerCol.get(b);
                ++ num;
                numPerCol.put(b, num);
            } else {
                numPerCol.put(b, 1);
            }
        }
        for (int i = 1; i <= n; i++) {
            if (!numPerCol.containsKey(i)) {
                return 0;
            } else {
                int num = numPerCol.get(i);
                if (num < minNum) {
                    minNum = num;
                }
            }

        }
        return minNum;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line1 = scanner.nextLine();
        String line2 = scanner.nextLine();
        String[] line1Arr = line1.split(" ");
        String[] line2Arr = line2.split(" ");
        int n = Integer.parseInt(line1Arr[0]);
        int m = Integer.parseInt(line1Arr[1]);
        int[] blocks = new int[m];
        for (int i = 0; i < m; i++) {
            blocks[i] = Integer.parseInt(line2Arr[i]);
        }
        System.out.println(getScore(blocks, n));
    }
}
