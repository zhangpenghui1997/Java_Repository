package cn.zph.algorithm.date1_7;

class Solution {
    public static int searchInsert(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (target == nums[i] || target < nums[i]) {
                return i;
            }
            if (target > nums[i] && i == nums.length - 1) {
                return i + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int target = 4;
        System.out.println(searchInsert(nums, target));
    }
}