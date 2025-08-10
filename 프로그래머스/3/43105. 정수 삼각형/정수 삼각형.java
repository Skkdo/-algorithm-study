import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        for(int i = 0; i < triangle.length - 1; i++) {
            int[] plus = new int[triangle[i + 1].length];
            
            for(int j = 0; j < triangle[i].length; j++) {
                plus[j] = Math.max(triangle[i][j], plus[j]);
                plus[j + 1] = Math.max(triangle[i][j], plus[j + 1]);
            }
            
            for(int j = 0; j < triangle[i + 1].length; j++) {
                triangle[i + 1][j] += plus[j];
            }
        }
        
        int max = 0;
        for(int num : triangle[triangle.length - 1]) max = Math.max(num, max);
        return max;
    }
}