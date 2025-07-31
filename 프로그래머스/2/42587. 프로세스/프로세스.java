import java.util.*;

class Solution {
    
    public class Process {
        int priority;
        int location;
        
        public Process(int priority, int location) {
            this.priority = priority;
            this.location = location;
        }
    }
    
    public int solution(int[] priorities, int location) {
        Queue<Process> q = new LinkedList<>();
        Integer[] arr = new Integer[priorities.length];
        
        for(int i = 0; i < priorities.length; i++) {
            q.add(new Process(priorities[i], i));
            arr[i] = priorities[i];
        }
        
        Arrays.sort(arr, Comparator.reverseOrder());
        
        int count = 0;
        int arrIdx = 0;
        while(!q.isEmpty()){
            Process p = q.poll();
            if(arr[arrIdx] > p.priority){
                q.add(p);
                continue;
            }
            
            count++;
            arrIdx++;
            if(p.location == location) break;
        }
        return count;
    }
}