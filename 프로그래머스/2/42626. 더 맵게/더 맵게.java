import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int count = 0;
        
        for(int n : scoville) {
            pq.add(n);
        }
        
        while(pq.size() >= 2 && pq.peek() < K) {
            int first = pq.poll();
            int second = pq.poll();
            pq.add(first + second * 2);
            count++;
        }
        
        if(pq.peek() < K) return -1;
        return count;
    }
}