import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> q = new LinkedList<>();
        int[] input_time = new int[truck_weights.length];
        int in_idx = 0;
        int truck_idx = 0;
        int sum_weight = 0;
        int time = 0;
        
        while(true) {
            time++;
            
            // out
            if(!q.isEmpty() && in_idx < input_time.length && time >= input_time[in_idx] + bridge_length){
                sum_weight -= q.poll();
                in_idx++;
            }
            // in
            if(q.size() < bridge_length &&  truck_idx < truck_weights.length && sum_weight + truck_weights[truck_idx] <= weight) {
                q.add(truck_weights[truck_idx]);
                sum_weight += truck_weights[truck_idx];
                input_time[truck_idx] = time;
                truck_idx++;
            }
            
            if(q.isEmpty()) break;
        }
        return time;
    }
}