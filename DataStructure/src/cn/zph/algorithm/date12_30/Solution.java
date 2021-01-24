package cn.zph.algorithm.date12_30;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static int lastStoneWeight(int[] stones) {
        if (stones.length == 0) {
            return 0;
        }
        List<Integer> stonesList = new ArrayList<Integer>();
        for (int i = 0; i < stones.length; ++i) {
            stonesList.add(stones[i]);
        }
        while (stonesList.size() > 1) {
            int first = 0;
            int firstIndex = 0;
            int second = 0;
            int secondIndex = 0;
            for (int i = 0; i < stonesList.size(); ++i) {
                if (stonesList.get(i) > first) {
                    firstIndex = i;
                    first = stonesList.get(i);
                }
            }
            stonesList.remove(firstIndex);

            for (int i = 0; i < stonesList.size(); ++i) {
                if (stonesList.get(i) > second) {
                    secondIndex = i;
                    second = stonesList.get(i);
                }
            }


            stonesList.remove(secondIndex);

            if (first - second > 0) {
                stonesList.add(first - second);
            }
        }
        if(stonesList.size()==1){
            return stonesList.get(0);
        }
        return 0;

    }

    public static void main(String[] args) {
        lastStoneWeight(new int[]{3, 1});
    }
}
