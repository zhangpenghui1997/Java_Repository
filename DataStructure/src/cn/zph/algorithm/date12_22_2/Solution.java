package cn.zph.algorithm.date12_22_2;

public class Solution {
    public int removeDuplicates(int[] nums) {
        int totalLength = nums.length;
        int start = 0;
        int end = nums.length - 1;
        for (int i = 0; i < totalLength; ++i) {
            if (i < totalLength - 1) {
                if (nums[i] == nums[i + 1]) {
                    start = i + 1;
                    for (int j = start; j <= end; ++j) {
                        nums[j - 1] = nums[j];
                    }
                    end--;
                    totalLength--;
                    i--;
                }
            }
        }
        for (int i = 0; i < totalLength; ++i) {
            System.out.println(nums[i]);
        }

        return totalLength;
    }

    public static void main(String[] args) {
        int[] a = {0,0,1,1,1,2,2,3,3,4};

        int l =new Solution().removeDuplicates(a);
        //System.out.println(l);

    }
}
