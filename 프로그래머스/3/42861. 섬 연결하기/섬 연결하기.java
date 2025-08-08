import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        Arrays.sort(costs, (a, b) -> a[2] - b[2]);
        int[] parent = new int[n];
        int answer = 0;
        
        for(int i = 0; i < n; i++) parent[i] = i;
        
        for(int[] cost : costs) {
            int a = cost[0];
            int b = cost[1];
            int c = cost[2];
            
            if(find(a, parent) != find(b, parent)) {
                union(a, b, parent);
                answer += c;
            }
        }
        return answer;
    }
    
    public void union(int a, int b, int[] parent) {
        int parentA = find(a, parent);
        int parentB = find(b, parent);
        if(parentA < parentB) parent[parentB] = parentA;
        else parent[parentA] = parentB;
    }
    
    public int find(int n, int[] parent) {
        if(parent[n] == n) return n;
        return parent[n] = find(parent[n], parent);
    }
}