import java.util.*;

class Solution {
    
    private static int Count = 0;
    private static boolean[] Visit;
    
    public int solution(int[] nums) {
        
        
        int totalSum =0;
        for(int num : nums){
            totalSum += num;
        }
        Visit = new boolean[totalSum+1];
        Visit[1]=true;
        for(int i=2;i<=Math.sqrt(Visit.length-1);i++){
            if(Visit[i]) continue;
            check(i);
        }
        count(nums,0,0,0);
    
        return Count;
    }
    
    static void check(int num){     
        for(int i=2;num*i<Visit.length;i++){
            Visit[num*i] = true;
        }
    }
    
    static void count(int[] nums,int index,int sum,int depth){
        if(depth == 3){
            if(!Visit[sum]) Count++;
            return;
        }
        
        for(int i=index;i<nums.length;i++){
            count(nums,i+1,sum+nums[i],depth+1);
        }
    }
}