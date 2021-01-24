package cn.zph.algorithm.date12_13;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public boolean containsDuplicate(int[] nums) {
        Map<Integer,Integer>map =new HashMap<>();
        int length=nums.length;
        if(length==0){
            return false;
        }else {
            for(int i=0;i<length;++i){
                if(!map.containsKey(nums[i])){
                    map.put(nums[i],1);
                }else{
                    map.put(nums[i],map.get(nums[i])+1);
                }
            }


            for(Map.Entry<Integer,Integer> entry:map.entrySet()){
                if(entry.getValue()>1){
                    return true;
                }
            }


            return false;
        }
    }

    public static void main(String[] args) {
        int nums[]={1,2,3,1};
        System.out.println(new Solution().containsDuplicate(nums));
    }
}
