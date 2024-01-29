import java.util.*;
class Solution {
    public int solution(int[] stones, int k) {
       int[] clone = stones.clone();  
       Arrays.sort(clone);
       
       int mid = clone.length/2;
       int value = clone[mid];
       int end = clone.length-1; 
       int start = 0; 
       while(start<end){
           
           int count = check(stones,value,k);
           
           if(count<k){
               start = mid+1;
               mid = (start+end)/2;
               value = clone[mid];
               continue;
           }    
           if(count>=k){
               end = mid;
               mid = (start+end)/2;
               value = clone[mid];
           }
           
        }
        
     return value;
    }
    
    public static int check(int[] stones,int value,int k){
        int count = 0;
        for(int i=0;i<stones.length;i++){
            if(count>=k) return count;
            if(stones[i]-value<=0) {
                count++;
                continue;
            }
            count = 0;
        }
        return count;
    }
    
}