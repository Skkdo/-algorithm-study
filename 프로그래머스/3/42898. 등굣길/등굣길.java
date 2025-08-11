class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] map = new int[n + 1][m + 1];
        map[1][1] = 1;
        
        for(int[] arr : puddles) map[arr[1]][arr[0]] = -1;
        
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(map[i][j] == -1) continue;
                
                int cur = map[i][j];
                int up = map[i - 1][j];
                int left = map[i][j - 1];
                
                cur = up > 0? cur + up : cur; 
                cur = left > 0? cur + left : cur; 
                map[i][j] = cur % 1000000007;
            }
        }
        return map[n][m];
    }
}