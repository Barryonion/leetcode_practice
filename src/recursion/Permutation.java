package recursion;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    public static void main(String[] args) {

        int[] nums = {1,2,3};
        Permutation permutation = new Permutation();
        List<List<Integer>> listList = permutation.permute(nums);
        for (int i = 0; i < listList.size(); i++) {
            List<Integer> integers = listList.get(i);
            String s = integers.toString();
            System.out.println(s);
        }


    }

    private List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> listList = new ArrayList<>();
        backtrace(listList, new ArrayList<>(), nums);
        return listList;
    }

    private void backtrace(List<List<Integer>> listList, ArrayList<Integer> tempList, int[] nums) {
        if (tempList.size() == nums.length) {
            listList.add(new ArrayList<>(tempList));//必须new 一个tempList对象保存当前排列，否则会被后续操作改变
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (tempList.contains(nums[i])) continue;
                tempList.add(nums[i]);
                backtrace(listList, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}