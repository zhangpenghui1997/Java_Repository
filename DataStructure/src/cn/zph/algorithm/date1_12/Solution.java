package cn.zph.algorithm.date1_12;

class Solution {
    public static int lengthOfLastWord(String s) {
        int length=0,lastLength=0;
         for(int i=0;i<s.length();++i){

             if(s.charAt(i)==' '){
                 if(length!=0)
                 lastLength = length;
                 length=0;
             }else {
                 length++;
             }
         }
         if(s.charAt(s.length()-1)==' ' && s.length()>1){
             return lastLength;
         }
         return length;

    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("a  "));
    }
}