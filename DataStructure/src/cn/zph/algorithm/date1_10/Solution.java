package cn.zph.algorithm.date1_10;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        } else if (nums.length == 1) {
            result.add(Integer.toString(nums[0]));
            return result;
        }
        int start = 0;
        for (int i = 0; i < nums.length - 1; ++i) {

            if (nums[i + 1] != nums[i] + 1) {
                if (i + 1 - start > 1) {
                    result.add(Integer.toString(nums[start]) + "->" + nums[i]);
                } else {
                    result.add(Integer.toString(nums[start]));
                }
                start = i + 1;
            } else if (nums[i + 1] == nums[i] + 1 && i + 1 == nums.length - 1) {
                if (i + 1 > start) {
                    result.add(Integer.toString(nums[start]) + "->" + nums[i + 1]);
                } else {
                    result.add(Integer.toString(nums[start]));
                }
            }
        }
        if (nums[nums.length - 1] != nums[nums.length - 2] + 1) {
            result.add(Integer.toString(nums[nums.length - 1]));
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(summaryRanges(new int[]{}));
    }
}
