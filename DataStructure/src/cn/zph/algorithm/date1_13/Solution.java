package cn.zph.algorithm.date1_13;

public class Solution {
    public static double positiveFunc(double x, int n) {
        if (n == 1) {
            return x;
        } else {
            return positiveFunc(x, n - 1) * x;
        }
    }

    public static double test(double x, int n) {
        double sum = 1.0;
        for (int i = 0; i < n; ++i) {
            sum *= x;
        }
        return sum;
    }

    public static double myPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        } else if (n == 1) {
            return x;
        } else if (n > 0) {
            return test(x, n);
        } else if (n < 0) {
            return 1 / test(x, -n);
        }
        return 0;
    }

    public static int[] plusOne(int[] digits) {
      /*  if (digits.length == 1) {
            int a = digits[0] + 1;
            if (a == 10) {
                return new int[]{1, 0};
            } else {
                digits[0] += 1;
                return digits;
            }
        }*/
        int lastIndex = digits.length - 1;
        int i = lastIndex;
        int flag = 0;
/*
*    if (flag == 1) {
                digits[i] += 1;
                if(digits[i]>9){
                    digits[i] = 0;
                    flag=1;
                }else {
                    flag=0;
                }
            } else if (digits[i] + 1 <= 9 ) {
                if(flag==0)
                digits[i] += 1;
                    flag = 0;
                    break;

            }else if (digits[i] + 1 >9) {
                digits[i] = 0;
                flag = 1;
            }
            i--;*/
        while (i >= 0) {
            if (flag == 1 || i == lastIndex) {
                if(digits[i]+1>9){
                    digits[i]=0;
                    flag=1;
                }else{
                    digits[i]+=1;
                    flag=0;
                    break;
                }
            }else {
                break;
            }
            i--;

        }
       if (flag == 1) {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            for (int j = 1; j < result.length; ++j) {
                result[j] = digits[j - 1];
            }

            return result;
        }

        return digits;
    }

    public static void main(String[] args) {

        //System.out.println(myPow(2.0, -2));
        int[] ints = plusOne(new int[]{9, 9, 9});
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
