package cn.zph.algorithm.date12_28;

public class Solution {
    public static int strStr(String haystack, String needle) {
        int hLength = haystack.length();
        int nLength = needle.length();
        if (hLength < nLength ) {
            return -1;
        }
        if("".equals(needle) || "".equals(haystack)){
            return 0;
        }
        int i,j,index;
        char startNeddle = needle.charAt(0);

            for (j = 0; j < hLength; ++j) {
                if (haystack.charAt(j) == startNeddle) {
                    i=0;
                    index=j;
                 while(i<nLength&&j<hLength){
                     if(haystack.charAt(j) != needle.charAt(i)){
                         j=index;
                         break;
                     }
                     i++;
                     j++;
                 }

                    if(i==nLength){
                        return index;
                    }
                }
            }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr("mississippi",
                "issip"));
    }
}
