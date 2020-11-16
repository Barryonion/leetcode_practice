package array;

import java.util.HashMap;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int me = 0;
        for (int i = 0; i < nums.length; i++) {
            if (map.getOrDefault(nums[i], 0) + 1 > nums.length / 2) {
                me = nums[i];
                break;
            }
            map.put(nums[i], map.getOrDefault(nums[i],0) + 1);
        }
        return me;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        MajorityElement majorityElement = new MajorityElement();
        int result = majorityElement.majorityElement(nums);
        System.out.println(result);
    }

}
