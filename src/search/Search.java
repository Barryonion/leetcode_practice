package search;

public class Search {
    public static void main(String[] args) {
        int[] nums = {1, 2, 5, 5, 6, 7, 8, 9};
        int val = 4;
        Search search = new Search();
//        int target = search.binarySearch(nums, val);
        int target = search.ambiguousBinarySearch(nums, val);
//        System.out.println(val + "值位于下标：" + target);
        System.out.println("第一个大于" + val + "的值位于下标：" + target);

    }

    /*求大于等于给定值的第一个元素*/
    private int ambiguousBinarySearch(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < val) {
                low = mid + 1;
            } else  { //nums[mid] >= val
                if (mid == 0 || nums[mid - 1] < val) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1;
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
