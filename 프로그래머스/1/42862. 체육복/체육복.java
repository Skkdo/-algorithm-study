import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] arr = new int[n + 1];
        Arrays.fill(arr, 0);
        
        for(int i : lost) {
            arr[i]--;
        }
        for(int i : reserve) {
            arr[i]++;
        }
        
        int count = 0;
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] >= 0){
                count++;
                continue;
            }else {
                if(i - 1 >= 0 && arr[i - 1] > 0) {
                    count++;
                    continue;
                }
                if(i + 1 < arr.length && arr[i + 1] > 0) {
                    arr[i + 1]--;
                    count++;
                }
            }
        }
        return count;
    }
}