class Solution {
        static int max =0;
        static boolean[] visited;
    
    public int solution(int k, int[][] dungeons) {
        int answer = 0;
        visited = new boolean[dungeons.length];
        test(dungeons,k,0);
        answer = max;        
        return answer;
    }
    public static void test(int[][] dungeons,int k,int clear){
        
        for(int i=0;i<dungeons.length;i++){
            if(visited[i]) continue;
            if(k>=dungeons[i][0]&&k>=dungeons[i][1]){
                visited[i] = true;
                test(dungeons,k-dungeons[i][1],clear+1);
                visited[i] = false;
            }
        }
        if(max<clear) max =clear;
    }
}