import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] check = new boolean[n];
        int answer = 0;
        
        for(int i = 0; i < n; i++) {
            if(check[i]) continue;
            
            answer++;
            check[i] = true;
            addQ(n, computers, q, check, i);
            
            while(!q.isEmpty()) {
                int num = q.poll();
                addQ(n, computers, q, check, num);
            }
        }
        return answer;
    }
    
    public static void addQ(int n, int[][] computers, Queue<Integer> q, boolean[] check, int num) {
        for(int i = 0; i < n; i++) {
            if(computers[num][i] != 1 || i == num || check[i]) continue;
            q.add(i);
            check[i] = true;
        }
    }
}