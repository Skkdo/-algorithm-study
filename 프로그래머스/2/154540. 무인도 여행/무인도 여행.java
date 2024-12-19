import java.util.*;

class Solution {
    
    private static int[][] map;
    private static boolean[][] visit;
    
    public int[] solution(String[] maps) {
        
        int row = maps.length;
        int col = maps[0].length();
        
        map = new int[row][col];
        visit = new boolean[row][col];
        
        for(int i=0;i<row;i++){
            String string = maps[i];
            for(int j=0;j<col;j++){
                char ch = string.charAt(j);             
                if(ch == 'X'){
                    map[i][j] = 0;
                }else{
                    map[i][j] = ch - '0';
                }
            }
        }
        
        ArrayList<Integer> sumList = new ArrayList<>();
        
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(map[i][j]>0 && !visit[i][j]){
                    int sum = dfs(i,j);
                    sumList.add(sum);
                }
            }
        }
        
        if(sumList.isEmpty()) return new int[]{-1};
        
        Collections.sort(sumList);
        return sumList.stream().mapToInt(Integer::intValue).toArray();
    }
    
    static int dfs(int i,int j){
        int row = map.length;
        int col = map[0].length;
        
        if(i<0 || j<0 || i>=row || j>=col || visit[i][j] || map[i][j] == 0) return 0;
        
        visit[i][j] = true;
        int sum = map[i][j];
        
        sum += dfs(i+1,j);
        sum += dfs(i-1,j);
        sum += dfs(i,j+1);
        sum += dfs(i,j-1);
        
        return sum;
    }
}