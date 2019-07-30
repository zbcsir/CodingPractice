package algorithm.exam;

import java.util.Scanner;

/**
 * 网易校招编程题-瞌睡
 * <p>
 *     小易觉得高数课太无聊了，决定睡觉。不过他对课上的一些内容挺感兴趣，
 *     所以希望你在老师讲到有趣的部分的时候叫醒他一下。你知道了小易对一堂课每分钟知识点的感兴趣程度，
 *     并以分数量化，以及他在这堂课上每分钟是否会睡着，
 *     你可以叫醒他一次，这会使得他在接下来的k分钟内保持清醒。你需要选择一种方案最大化小易这堂课听到的知识点分值。
 * </p>
 * <p>
 *     第一行 n, k (1 <= n, k <= 105) ，表示这堂课持续多少分钟，以及叫醒小易一次使他能够保持清醒的时间。
 *     第二行 n 个数，a1, a2, ... , an(1 <= ai <= 104) 表示小易对每分钟知识点的感兴趣评分。
 *     第三行 n 个数，t1, t2, ... , tn 表示每分钟小易是否清醒, 1表示清醒。
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
