package sort;

public class Sort {
    public static void main(String[] args) {
        Sort sort = new Sort();
//        int[] nums = {23,45,1,45,75,37,38,86,234,33,75,8,45,657,5,6,97,45,8};
//        int[] nums = {3,8,9,6};
        int[] nums = {8,5,6,3,4,1,7};
        long startTime = System.nanoTime();
//        sort.mergeSort(nums, 0, nums.length - 1);
//        sort.quickSort(nums,0,nums.length-1);
//        sort.insertSort(nums);
//        sort.bubbleSort(nums);
//        sort.selectSort(nums);
        System.out.println(sort.KthElement(nums,4));

//        long endTime = System.nanoTime();
//        System.out.println("排序执行时长：" + (endTime - startTime));
//        for (int i = 0; i < nums.length; i++) {
//            /*if (i == nums.length - 1) {
//                System.out.print(nums[i]);
//            }*/
//            System.out.print(nums[i]+",");
//        }
    }

    private int KthElement(int[] nums, int k) {
        if (nums == null || nums.length < k) {
            return -1;
        }
        int patitionIndex = patitionIndex(nums, 0, nums.length - 1);
        while (patitionIndex + 1 != k) {
            if (patitionIndex + 1 < k) {
                patitionIndex = patitionIndex(nums, patitionIndex + 1, nums.length - 1);
            } else {
                patitionIndex = patitionIndex(nums, 0, patitionIndex - 1);
            }
        }
        return nums[patitionIndex];
    }

    private int patitionIndex(int[] nums, int p, int r) {
        int pivot = nums[r];
        int i = p;
        for (int j = p; j < r; j++) {
            if (nums[j] <= pivot) {
                swap(nums,i, j);
                i++;
            }
        }
        swap(nums, i, r);
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void selectSort(int[] nums) {
        for (int i = 0; i < nums.length-1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[minIndex] > nums[j]) {
                    minIndex = j;
                }
            }
            int tmp = nums[minIndex];
            nums[minIndex] = nums[i];
            nums[i] = tmp;
        }
    }

    private void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {//冒泡趟数
            boolean flag = false;
            for (int j = 0; j < nums.length - 1; j++) {//两两比较
                if (nums[j] > nums[j + 1]) {
                    int tmp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = tmp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
    }



    private void insertSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int tempVal = nums[i];
            int index = i - 1;
            while (index >= 0 && nums[index] > tempVal) {
                nums[index + 1] = nums[index];
                index--;
            }
            nums[index + 1] = tempVal;
        }
    }


    private void quickSort(int[] nums, int lowIndex, int hignIndex) {
        if (lowIndex >= hignIndex) {
            return;
        }
        int patitionPoint = patitionPoint(nums, lowIndex, hignIndex);
        quickSort(nums, lowIndex, patitionPoint - 1);
        quickSort(nums, patitionPoint + 1, hignIndex);

    }

    private int patitionPoint(int[] nums, int lowIndex, int hignIndex) {
        int pivot = nums[hignIndex];
        int i = lowIndex;
        for (int j = lowIndex; j < hignIndex; j++) {
            if (nums[j] < pivot) {//交换
                if (i == j) {//特殊情况
                    i++;
                } else {
                    int tmp = nums[i];
                    nums[i++] = nums[j];//注意i++
                    nums[j] = tmp;
                }
            }
        }
        int tmp = nums[i];
        nums[i] = pivot;
        nums[hignIndex] = tmp;
        return i;
    }



    private void mergeSort(int[] nums, int lowIndex, int highIndex) {
        if (lowIndex == highIndex) {
            return ;
        }
        int middleIndex = lowIndex + (highIndex - lowIndex) / 2;
        mergeSort(nums, lowIndex, middleIndex);
        mergeSort(nums, middleIndex+1, highIndex);

        mergeFunction(nums,lowIndex,middleIndex,highIndex);
    }
    private void mergeFunction(int[] nums, int lowIndex,int middleIndex,int highIndex) {
        int i = lowIndex;
        int j = middleIndex+1;
        int r = 0;
        int[] tempIntNums = new int[highIndex - lowIndex + 1];
        while (i <= middleIndex && j <= highIndex) {
            if (nums[i] <= nums[j]) {
                tempIntNums[r++] = nums[i++];
            } else {
                tempIntNums[r++] = nums[j++];
            }
        }

        /*判断哪个子数组中有剩余的数据*/
        int start = i;
        int end = middleIndex;
        if (j <= highIndex) {
            start = j;
            end = highIndex;
        }
        /*将剩余的数据拷贝到临时数组*/
        while (start <= end) {
            tempIntNums[r++] = nums[start++];
        }


        /*将tempIntNums中的数据拷回nums*/
        for (int k = 0; k <= highIndex - lowIndex; k++) {
            nums[lowIndex + k] = tempIntNums[k];
        }
    }
}
