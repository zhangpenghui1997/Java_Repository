package cn.zph.algorithm.date1_9;

class Solution {
    public static String countAndSay(int n) {
        String str="";
        if (n == 1) {
            return "1";
        } else {
            str += countAndSay(n - 1);
        }
        return str;
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(3));
    }
}