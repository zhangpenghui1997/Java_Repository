package cn.zph.algorithm.date12_30_1;

public class Solution {
    public static int maxArea(int[] height) {
        int length=height.length;
        if(length==0){
            return 0;
        }
        int i,j,maxArea=0;
          for(i=0;i<length-1;++i){
              int minHeight=height[i];
              for(j=i+1;j<length;++j){
                  if(minHeight>height[j]){
                      minHeight=height[j];
                  }
                  int currentArea;
                  if(height[j]>minHeight&&height[i]>minHeight){
                      int h=height[j]<height[i]?height[j]:height[i];
                      currentArea=(j-i)*h;
                  }else{
                      currentArea=(j-i)*minHeight;
                  }
                  if(maxArea<currentArea){
                      maxArea=currentArea;
                  }
              }
          }
          return maxArea;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}
