package cn.zph.algorithm.date12_23;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public static int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }
        int totalLength = nums.length;
        int start = 0;
        int end = nums.length - 1;
        for (int i = 0; i <= end; ++i) {
            if (i < end) {
                if (val == nums[i]) {
                    for (int j = i + 1; j <= end; ++j) {
                        nums[j - 1] = nums[j];
                    }
                    i--;
                    totalLength--;
                    end--;
                }
            } else {
                if (nums[i] == val) {
                    totalLength--;
                }
            }
        }
        for (int i = 0; i < totalLength; ++i) {
            System.out.println(nums[i]);
        }
        return totalLength;
    }

    public static int firstUniqChar(String s) {
        int i, j;
        for (i = 0; i < s.length() - 1; ++i) {
            int flag = 0;
            for (j = i + 1; j < s.length(); ++j) {
                if (s.charAt(i) == s.charAt(j)) {
                    flag = 1;
                    break;
                } else if (s.charAt(i) != s.charAt(j) && j == s.length() - 1) {
                    return i;
                }
            }
            if (j == s.length() && flag == 0) {
                return i;
            }
        }
        if (i == s.length() - 1) {
            return i;
        }
        return -1;
    }

    public static int firstUniqChar2(String s) {
        Map<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();++i){
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), map.get(s.charAt(i))+1);
            }else{
                map.put(s.charAt(i), 1);
            }
        }

        for(Map.Entry<Character,Integer> entry:map.entrySet()){
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
        return -1;

    }

    public static int firstUniqChar3(String s) {
        if (s==null){
            return -1;
        }
        List<Character> key =new ArrayList<>();
        Map<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();++i){
           if( key.contains(s.charAt(i))){
               map.put(s.charAt(i), map.get(s.charAt(i))+1);
           }else{
               key.add(s.charAt(i));
               map.put(s.charAt(i),1);
           }
        }
        for(int i=0;i<key.size();++i){
            System.out.println(key.get(i));
        }
        for(Map.Entry<Character,Integer> entry:map.entrySet()){
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
       for(int i=0;i<key.size();++i){
            if(map.get(key.get(i))==1){
                for(int j=0;j<s.length();++j){
                    if(s.charAt(j)==key.get(i)){
                        return j;
                    }
                }
            }
       }

       return  -1;
    }
    public static void main(String[] args) {
        int a[] = {0, 1, 2, 2, 3, 0, 4, 2};
        //removeElement(a,2);
        System.out.println(firstUniqChar3("ccca"));
    }
}
