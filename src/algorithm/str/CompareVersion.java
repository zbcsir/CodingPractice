package algorithm.str;

/**
 * Leetcode 比较两个版本号 version1 和 version2
 * 如果 version1 > version2 返回 1，如果 version1 < version2 返回 -1， 除此之外返回 0
 * 假设版本字符串非空，并且只包含数字和 . 字符
 */
public class CompareVersion {
    private static int compareVersion(String version1, String version2) {
        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");
        int len1 = arr1.length;
        int len2 = arr2.length;
        int minLen = len1 <= len2 ? len1 : len2;
        for (int i = 0; i < minLen; i++) {
            int v1 = Integer.parseInt(arr1[i]);
            int v2 = Integer.parseInt(arr2[i]);
            if (v1 == v2) {
                continue;
            }
            if (v1 > v2) {
                return 1;
            } else {
                return -1;
            }
        }
        if (len1 > len2) {
            for (int i = len2; i < len1; i++) {
                int v = Integer.parseInt(arr1[i]);
                if (v != 0) {
                    return 1;
                }
            }
            return 0;
        } else if (len1 < len2) {
            for (int i = len1; i < len2; i++) {
                int v = Integer.parseInt(arr2[i]);
                if (v != 0) {
                    return -1;
                }
            }
            return 0;
        }
        return 0;
    }

    public static void main(String[] args) {
        String version11 = "0.1", version12 = "1.1";
        String version21 = "1.0.1", version22 = "1";
        String version31 = "7.5.2.4", version32 = "7.5.3";
        String version41 = "1.01", version42 = "1.001";
        String version51 = "1.0", version52 = "1.0.0";
        System.out.println(compareVersion(version11, version12));
        System.out.println(compareVersion(version21, version22));
        System.out.println(compareVersion(version31, version32));
        System.out.println(compareVersion(version41, version42));
        System.out.println(compareVersion(version51, version52));
    }
}
