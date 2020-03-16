package sortandsearch;

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */
abstract class VersionControl{
    public abstract boolean isBadVersion(int version);
}

public class Solution extends VersionControl{
    public int[] IntArray;
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left < right){
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid))
                right = mid;
            else 
                left = mid + 1;
        }
        return left;
    }
    @Override
    public boolean isBadVersion(int version) {
        if (IntArray[version-1] == 0)
            return true;
        return false;
    }
    public void initIntArray(int ArrayLength ,int version){//注意版本号和下标值的对应关系。
        IntArray = new int[ArrayLength];//遗忘如何初始化指定大小的int类型数组。
        for (int i = 0; i < ArrayLength; i ++){
            if (i < version - 1)//若当前下标小于异常版本下标，则赋值1。
                IntArray[i] = 1;//1为正常版本，0为异常版本。
            else
                IntArray[i] = 0;//初始化赋值时未正确设置判断条件。
            System.out.println(IntArray[i]);
        }
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        s.initIntArray(5,5);//version值要小于ArrayLength值
        System.out.println(s.firstBadVersion(s.IntArray.length));
    }
}
//Java abstract class 用法。