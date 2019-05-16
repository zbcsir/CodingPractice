package algorithm.listarray;

// Leetcode 238 ��������������ĳ˻�
public class ProductExceptSelf {
    private int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        // ����ע�����鳤�ȴ��� 1���ʶ��ڸ���Ŀ���Կ��Բ��Ӵ��ж�
        if (len == 0)
            return new int[]{0};
        int[] productRes = new int[len];
        for (int i = 0; i < len; i++) {
            productRes[i] = 1;
        }
        int leftPart = 1;
        int rightPart = 1;
        for (int i = 0; i < len; i++) {
            productRes[i] *= leftPart;
            leftPart *= nums[i];
        }
        for (int i = len - 1; i >= 0; i--) {
            productRes[i] *= rightPart;
            rightPart *= nums[i];
        }
        return productRes;
    }

    // ȥ��productRes����ĳ�ʼ��ѭ��
    private int[] productExceptSelfOptimize(int[] nums) {
        int len = nums.length;
        // ����ע�����鳤�ȴ��� 1���ʶ��ڸ���Ŀ���Կ��Բ��Ӵ��ж�
        if (len == 0)
            return new int[]{0};
        int[] productRes = new int[len];
        int leftPart = 1;
        int rightPart = 1;
        for (int i = 0; i < len; i++) {
            productRes[i] = leftPart;
            leftPart *= nums[i];
        }
        for (int i = len - 1; i >= 0; i--) {
            productRes[i] *= rightPart;
            rightPart *= nums[i];
        }
        return productRes;
    }

    private void printArray(int[] nums) {
        for (int num : nums) {
            System.out.print(num + "\t");
        }
    }

    public static void main(String[] args) {
        ProductExceptSelf pes = new ProductExceptSelf();
        int[] nums = {1,2,3,4};
        int[] productRes = pes.productExceptSelfOptimize(nums);
        pes.printArray(productRes);
    }
}
