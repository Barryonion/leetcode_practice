package sortandsearch;

public class mergetwosortedarray {
    public void merge(int[] nums1, int m, int[] nums2, int n){
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (i >= 0 && j >= 0){
            if (nums1[i] > nums2[j])
                nums1[k--] = nums1[i--];
            else
//                System.out.println(k);
//                System.out.println(j);
                nums1[k--] = nums2[j--];
        }
        while (j >= 0){
            nums1[k--] = nums2[j--];
        }



    }

    public static void main(String[] args) {
        int[] nums1 = {2,5,6,0,0,0};
        int[] nums2 = {1,2,3};
        mergetwosortedarray me = new mergetwosortedarray();
        me.merge(nums1,3,nums2,3);
        for (int i = 0; i < nums1.length; i++){
            System.out.println(nums1[i]);
        }
    }
}
