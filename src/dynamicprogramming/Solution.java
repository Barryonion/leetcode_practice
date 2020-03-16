package dynamicprogramming;

class Solution {
    public int rob(int[] nums) {
        int preMax = 0;
        int curMax = 0;
        for (int x:nums) {
            int temp = curMax;
            curMax = Math.max(preMax + x,curMax);
            preMax = temp;
        }
        return curMax;
    }

    public static void main(String[] args) {
        int [] nums = {3,1,2,4};
        Solution s = new Solution();
        System.out.println(s.rob(nums));

    }
}