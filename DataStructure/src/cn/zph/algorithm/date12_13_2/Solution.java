package cn.zph.algorithm.date12_13_2;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        if(s==""){
            return true;
        }
        Map<Character, Character> map = new HashMap<>();
        map.put('}', '{');
        map.put(']', '[');
        map.put(')', '(');


        Stack<Character> stack=new Stack<>();

        for (int i = 0; i < s.length(); ++i) {
          if(!(!map.containsKey(s.charAt(i))&&!map.containsValue(s.charAt(i)))){
              if(stack.isEmpty()){
                  stack.push(s.charAt(i));
              }else if(map.get(s.charAt(i))==stack.peek()){
                  stack.pop();
              }else{
                  stack.push(s.charAt(i));
              }
          }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isValid(""));
    }
}
