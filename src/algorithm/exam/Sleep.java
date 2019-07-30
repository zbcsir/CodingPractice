package algorithm.exam;

import java.util.Scanner;

/**
 * ����У�б����-�˯
 * <p>
 *     С�׾��ø�����̫�����ˣ�����˯�����������Կ��ϵ�һЩ����ͦ����Ȥ��
 *     ����ϣ��������ʦ������Ȥ�Ĳ��ֵ�ʱ�������һ�¡���֪����С�׶�һ�ÿ�ÿ����֪ʶ��ĸ���Ȥ�̶ȣ�
 *     ���Է����������Լ��������ÿ���ÿ�����Ƿ��˯�ţ�
 *     ����Խ�����һ�Σ����ʹ�����ڽ�������k�����ڱ������ѡ�����Ҫѡ��һ�ַ������С�����ÿ�������֪ʶ���ֵ��
 * </p>
 * <p>
 *     ��һ�� n, k (1 <= n, k <= 105) ����ʾ���ÿγ������ٷ��ӣ��Լ�����С��һ��ʹ���ܹ��������ѵ�ʱ�䡣
 *     �ڶ��� n ������a1, a2, ... , an(1 <= ai <= 104) ��ʾС�׶�ÿ����֪ʶ��ĸ���Ȥ���֡�
 *     ������ n ������t1, t2, ... , tn ��ʾÿ����С���Ƿ�����, 1��ʾ���ѡ�
 * </p>
 */
public class Sleep {
    private static int maxInterestScore(int[] scores, int[] awake, int k) {
        int len = scores.length;
        if (len <= k) {
            int score = 0;
            for (int i = 0; i < len; i++) {
                score += scores[i];
            }
            return score;
        }
        int noAwakeScore = 0;
        for (int i = 0; i < len; i++) {
            noAwakeScore += (scores[i] * awake[i]);
        }
        int increaseMax = 0;
        for (int i = 0; i < len; i++) {
            if (awake[i] == 0) {
                int end = (i + k < len ? (i+k-1) : (len - 1));
                int sum = 0;
                for (int j = i; j <= end; j++) {
                    sum += (scores[j] - scores[j] * awake[j]);
                }
                increaseMax = sum > increaseMax ? sum : increaseMax;
            }
        }
        return (noAwakeScore + increaseMax);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line1 = scanner.nextLine();
        String line2 = scanner.nextLine();
        String line3 = scanner.nextLine();
        String[] line1Arr = line1.split(" ");
        String[] line2Arr = line2.split(" ");
        String[] line3Arr = line3.split(" ");
        int n = Integer.parseInt(line1Arr[0]);
        int k = Integer.parseInt(line1Arr[1]);
        int[] scores = new int[n];
        int[] awake = new int[n];
        for (int i = 0; i < n; i++) {
            scores[i] = Integer.parseInt(line2Arr[i]);
        }
        for (int i = 0; i < n; i++) {
            awake[i] = Integer.parseInt(line3Arr[i]);
        }
        System.out.println(maxInterestScore(scores, awake, k));
    }
}
