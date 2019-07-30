package algorithm.exam;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 网易编程题-俄罗斯方块
 * <p>
 *     小易有一个古老的游戏机，上面有着经典的游戏俄罗斯方块。因为它比较古老，所以规则和一般的俄罗斯方块不同。
 *     荧幕上一共有 n 列，每次都会有一个 1 x 1 的方块随机落下，在同一列中，后落下的方块会叠在先前的方块之上，
 *     当一整行方块都被占满时，这一行会被消去，并得到1分。有一天，小易又开了一局游戏，当玩到第 m 个方块落下
 *     时他觉得太无聊就关掉了，小易希望你告诉他这局游戏他获得的分数。
 * </p>
 * <p>
 *     第一行两个数 n, m
 *     第二行 m 个数，c1, c2, ... , cm ， ci 表示第 i 个方块落在第几列
 *     其中 1 <= n, m <= 1000, 1 <= ci <= n
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
