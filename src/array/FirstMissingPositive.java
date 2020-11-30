package array;

import java.util.Arrays;

public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            int num = Math.abs(nums[i]);//取绝对值是为了在遍历前部数组元素的过程中，避免可能出现标记的操作造成对后部元素的造成影响（即，把值标记成了负数）。
            if (num <= n) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return n + 1;
    }

    public static void main(String[] args) {
        int[] nums1 = {1};
        int[] nums2 = {3, 4, -1, 1};
        int[] nums3 = {7, 8, 9, 11, 12};
        FirstMissingPositive fmpObject = new FirstMissingPositive();
        int result1 = fmpObject.firstMissingPositive(nums1);
        System.out.println(Arrays.toString(nums1) + "first missing positive number is :" + result1);
        int result2 = fmpObject.firstMissingPositive(nums2);
        System.out.println(Arrays.toString(nums2) + "first missing positive number is :" + result2);
        int result3 = fmpObject.firstMissingPositive(nums3);
        System.out.println(Arrays.toString(nums3) + "first missing positive number is :" + result3);

    }
}
