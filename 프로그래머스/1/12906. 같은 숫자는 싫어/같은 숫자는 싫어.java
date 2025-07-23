import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Queue<Integer> q = new LinkedList<>();
        
        q.add(arr[0]);
        int pre = arr[0];
        for(int i = 1; i < arr.length; i++){
            if(pre == arr[i]){
                continue;
            }else {
                q.add(arr[i]);
                pre = arr[i];
            }
        }
        return q.stream().mapToInt(Integer::intValue).toArray();
    }
}