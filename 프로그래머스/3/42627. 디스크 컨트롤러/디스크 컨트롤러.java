import java.util.*;

class Solution {
    
    public class Job {
        int num;
        int request_t;
        int time;
        
        public Job(int num, int request_t, int time) {
            this.num = num;
            this.request_t = request_t;
            this.time = time;
        }
    }
    public int solution(int[][] jobs) {
        PriorityQueue<Job> pq = new PriorityQueue<>(Comparator
                                                    .comparingInt((Job j) -> j.time)
                                                    .thenComparingInt(j -> j.request_t)
                                                    .thenComparingInt(j -> j.num));
        Job[] arr = new Job[jobs.length];
        
        for(int i = 0; i < jobs.length; i++) {
            arr[i] = new Job(i, jobs[i][0], jobs[i][1]);
        }
        
        Arrays.sort(arr, Comparator.comparingInt((Job j) -> j.request_t));
        
        int idx = 0;
        int time = 0;
        int sum = 0;
        
        while(true) {
            for(int i = idx; i < arr.length; i++) {
                if(arr[i].request_t <= time) {
                    pq.add(arr[i]);
                    idx++;
                }
            }
            
            if(!pq.isEmpty()) {
                Job j = pq.poll();
                time += j.time;
                sum += time - j.request_t;
                continue;
            }
            
            time++;
            if(pq.isEmpty() && idx >= arr.length) break;
        }
        
        return sum / jobs.length;
    }
}