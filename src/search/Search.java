package search;

public class Search {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int val = 6;
        Search search = new Search();
        int target = search.binarySearch(nums, val);
        System.out.println(val + "值位于下标：" + target);

    }

    private int binarySearch(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == val) {
                return mid;
            } else if (nums[mid] < val) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

}
