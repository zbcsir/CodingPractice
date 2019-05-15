package algorithm.listarray;

import java.util.Random;

public class ShuffleArray {

    private int[] nums;
    private Random random;
    private ShuffleArray(int[] nums) {
        this.nums = nums;
        this.random = new Random();
    }

    /** Resets the array to its original configuration and return it. */
    private int[] reset() {
        return nums;
    }

    /** Returns a random shuffling of the array. */
    private int[] shuffle() {
        int[] numsCopy = nums.clone();
        for (int i = numsCopy.length-1; i > 0; i--) {
            int idToSwap = random.nextInt(i+1);
            int tmp = numsCopy[i];
            numsCopy[i] = numsCopy[idToSwap];
            numsCopy[idToSwap] = tmp;
        }
        return numsCopy;
    }

    private void printArray(int[] nums) {
        for (int num : nums) {
            System.out.print(num + "\t");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        ShuffleArray sha = new ShuffleArray(nums);
        int[] shuffled = sha.shuffle();
        sha.printArray(shuffled);
        int[] reset = sha.reset();
        sha.printArray(reset);
    }
}
