package cn.zph.algorithm.date12_11;

public class Solution {

    public String longestCommonPrefix(String[] strs) {
        if(strs.length>0){
            int maxLength=0;
            int minLength=strs[0].length();
            for(int i=0;i<strs.length;++i){
                if(strs[i].length()>maxLength){
                    maxLength=strs[i].length();
                }
                if(strs[i].length()<minLength){
                    minLength=strs[i].length();
                }
            }

            String r="";
            pos:for(int j=0;j<minLength;++j){
                char a=strs[0].charAt(j);
                for(int i=0;i<strs.length;++i) {
                    if(a!=strs[i].charAt(j)){
                        break pos;
                    }
                    if(i==strs.length-1)
                    {
                        r+=a;
                    }

                }
            }
            return r;
        }else{
            return "";
        }


    }

    public static void main(String[] args) {
        String [] str={};
        System.out.println(new Solution().longestCommonPrefix(str));
    }
}
