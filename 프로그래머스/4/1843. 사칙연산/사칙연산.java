class Solution {
    public int solution(String arr[]) {
        int n = (arr.length + 1) / 2;
        int[][] maxDP = new int[n][n];
        int[][] minDP = new int[n][n];
        
        for(int i = 0; i < n; i++) {
            int num = Integer.parseInt(arr[2 * i]);
            maxDP[i][i] = num;
            minDP[i][i] = num;
        }
        
        for(int range = 1; range < n; range++) {
            for(int i = 0; i + range < n; i++) {
                int j = i + range;
                maxDP[i][j] = Integer.MIN_VALUE;
                minDP[i][j] = Integer.MAX_VALUE;
                
                for(int k = i; k < j; k++) {
                    String op = arr[2 * k + 1];
                    if(op.equals("+")){
                        maxDP[i][j] = Math.max(maxDP[i][j], maxDP[i][k] + maxDP[k + 1][j]);
                        minDP[i][j] = Math.min(minDP[i][j], minDP[i][k] + minDP[k + 1][j]);
                    }else {
                        maxDP[i][j] = Math.max(maxDP[i][j], maxDP[i][k] - minDP[k + 1][j]);
                        minDP[i][j] = Math.min(minDP[i][j], minDP[i][k] - maxDP[k + 1][j]); 
                    }
                }
            }
        }
        return maxDP[0][n - 1];
    }
}