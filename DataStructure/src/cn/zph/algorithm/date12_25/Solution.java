package cn.zph.algorithm.date12_25;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static int findContentChildren(int[] g, int[] s) {
        if(g.length==0||s.length==0){
            return 0;
        }
        List<Integer> gList = new ArrayList<>();
        List<Integer> sList = new ArrayList<>();
        for (int i = 0; i < g.length; ++i) {
            gList.add(g[i]);
        }
        for (int i = 0; i < s.length; ++i) {
            sList.add(s[i]);
        }
        int count = 0;
        int index = -1;
        long maxValue;
        if(sList.size()==1){
            maxValue=sList.get(0)+1;
        }else{
            maxValue=Collections.max(sList)+1;
        }
        long sValue;
        for (int i = 0; i < gList.size(); ++i) {
            index = -1;
            sValue = maxValue;
            for (int j = 0; j < sList.size(); ++j) {
                if (sList.get(j) >= gList.get(i) && sValue > sList.get(j)) {
                    index = j;
                    sValue = sList.get(j);
                }
            }
            if (index != -1) {
                sList.remove(index);
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] g = {1,2,3};
        int[] s = {3};
        System.out.println(findContentChildren(g, s));
    }
}
