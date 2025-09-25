import java.util.*;

class Solution {
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, -1, 0, 1};

    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        
        q.offer(new int[]{0, 0, 1}); 
        visited[0][0] = true;
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1], depth = cur[2];
            
            if (x == m - 1 && y == n - 1) {
                return depth; 
            }
            
            for (int i = 0; i < 4; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];
                
                if (nextX < 0 || nextX >= m || nextY < 0 || nextY >= n) continue;
                if (visited[nextY][nextX]) continue;
                if (maps[nextY][nextX] == 0) continue;
                
                visited[nextY][nextX] = true;
                q.offer(new int[]{nextX, nextY, depth + 1});
            }
        }
        
        return -1;
    }
}
