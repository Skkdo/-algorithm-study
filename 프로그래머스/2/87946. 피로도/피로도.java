import java.util.*;

class Solution {
    int MAX = 0;
    
    public int solution(int k, int[][] dungeons) {
        boolean[] check = new boolean[dungeons.length];
        DFS(k, 0, dungeons, check);
        return MAX;
    }
    
    public void DFS(int k, int count, int[][] dungeons, boolean[] check) {
        for(int i = 0; i < dungeons.length; i++) {
            if(check[i]) continue;
            if(k < dungeons[i][0]) continue;
            
            check[i] = true;
            DFS(k - dungeons[i][1], count + 1, dungeons, check);
            check[i] = false;
        }
         MAX = Math.max(MAX, count);
    }
}