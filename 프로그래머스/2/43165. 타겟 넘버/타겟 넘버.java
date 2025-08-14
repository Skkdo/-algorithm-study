import java.util.*;

class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        
        for(int i = 0; i < numbers.length; i++) {
            Integer num = numbers[i];
            for(int size = q.size(); size > 0; size--) {
                Integer poll = q.poll();
                q.add(poll + num);
                q.add(poll - num);
            }  
        }
        
        while(!q.isEmpty()) if(q.poll() == target) answer++;
        return answer;
    }
}