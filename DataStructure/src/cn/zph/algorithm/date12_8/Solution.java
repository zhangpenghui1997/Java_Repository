package cn.zph.algorithm.date12_8;

import java.util.HashMap;
import java.util.Map;

/**
 * 罗马数字转化为十进制数字
 */
class Solution {
    public int romanToInt(String s) {
        Map<Character,Integer> map=new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int sum=0;
        if(s.length()>1){
            for(int i=0;i<s.length()-1;++i){
                //System.out.println(map.get(s.charAt(i)));
                if(map.get(s.charAt(i))>=map.get(s.charAt(i+1))){

                    if(i==s.length()-2){
                        if(map.get(s.charAt(i))>=map.get(s.charAt(i+1))) {
                            sum += map.get(s.charAt(i));
                            sum += map.get(s.charAt(i+1));
                            ++i;
                        }else{
                            sum+=(map.get(s.charAt(i+1))-map.get(s.charAt(i)));
                            ++i;
                        }
                    }else{
                        sum+=map.get(s.charAt(i));
                    }
                }else{
                    sum+=(map.get(s.charAt(i+1))-map.get(s.charAt(i)));
                    ++i;
                }

                if(i==s.length()-2){
                    sum+=map.get(s.charAt(i+1));
                }

            }
        }else{
            sum+=map.get(s.charAt(0));
        }


        return sum;

    }

    public static void main(String[] args) {
     Solution solution=new Solution();
     int s=solution.romanToInt("M");
     System.out.println(s);
    }
}