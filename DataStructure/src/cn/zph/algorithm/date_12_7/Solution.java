package cn.zph.algorithm.date_12_7;

/**
 * 回文数判断
 */
public class Solution {
    public boolean isPalindrome(int x) {
      if(x<0){
          return false;
      }else if(x==0){
          return true;
      }else{
          String str=""+x;
          for(int i=0;i<str.length()/2;++i){
              if(str.charAt(i)!=str.charAt(str.length()-i-1)){
                  return false;
              }
          }
          return true;
      }

    }

    public static void main(String[] args) {
        System.out.println(new Solution().isPalindrome(-101));;
    }
}