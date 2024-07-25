import java.util.*;
import java.io.*;


public class Main {

    private static int max = 0;
    private static int N;


    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];

        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                int n = Integer.parseInt(st.nextToken());
                map[i][j] = n;
            }
        }
        int[][] copy;
        for(int i=0;i<4;i++){
            copy = new int[N][N];
            for(int j=0;j<N;j++){
                for(int k=0;k<N;k++){
                    copy[j][k] = map[j][k];
                }
            }
            dfs(copy,i,1);
        }
        System.out.println(max);

    }
    // arrow 0 = 상 1 = 하 2 = 좌 3 = 우
    private static void dfs(int[][] map,int arrow , int depth){
        if(depth == 6) return;

        if(arrow==0){
            for(int y=0;y<N;y++){
                int before =0;
                int beforeXIndex =0;
                int beforeYIndex =0;
                // 0을 제외한 인접한 같은 숫자 합치기
                for(int x=0;x<N;x++){
                    if(map[x][y]==0) continue;
                    if(before==map[x][y]){
                        map[beforeXIndex][beforeYIndex] *= 2;
                        if (map[beforeXIndex][beforeYIndex]>max) max = map[beforeXIndex][beforeYIndex];
                        before =0;
                        map[x][y] =0;
                        continue;
                    }
                    if (map[x][y]>max) max = map[x][y];
                    before=map[x][y];
                    beforeXIndex = x;
                    beforeYIndex = y;
                }
                // 밀착
                int side = 0;
                for(int x=0;x<N;x++){
                    if(map[x][y]==0) continue;
                    if(side==x) {
                        side++;
                        continue;
                    }
                    map[side][y] = map[x][y];
                    map[x][y] =0;
                    side++;
                }
            }
        }else if(arrow ==1){
            for(int y=0;y<N;y++){
                int before =0;
                int beforeXIndex =0;
                int beforeYIndex =0;
                // 0을 제외한 인접한 같은 숫자 합치기
                for(int x=N-1;x>=0;x--){
                    if(map[x][y]==0) continue;
                    if(before==map[x][y]){
                        map[beforeXIndex][beforeYIndex] *= 2;
                        if (map[beforeXIndex][beforeYIndex]>max) max = map[beforeXIndex][beforeYIndex];
                        before =0;
                        map[x][y] =0;
                        continue;
                    }
                    if (map[x][y]>max) max = map[x][y];
                    before=map[x][y];
                    beforeXIndex = x;
                    beforeYIndex = y;
                }
                // 밀착
                int side = N-1;
                for(int x=N-1;x>=0;x--){
                    if(map[x][y]==0) continue;
                    if(side==x) {
                        side--;
                        continue;
                    }
                    map[side][y] = map[x][y];
                    map[x][y] =0;
                    side--;
                }
            }
        }else if(arrow==2){
            for(int x=N-1;x>=0;x--){
                int before =0;
                int beforeXIndex =0;
                int beforeYIndex =0;
                // 0을 제외한 인접한 같은 숫자 합치기
                for(int y=0;y<N;y++){
                    if(map[x][y]==0) continue;
                    if(before==map[x][y]){
                        map[beforeXIndex][beforeYIndex] *= 2;
                        if (map[beforeXIndex][beforeYIndex]>max) max = map[beforeXIndex][beforeYIndex];
                        before =0;
                        map[x][y] =0;
                        continue;
                    }
                    if (map[x][y]>max) max = map[x][y];
                    before=map[x][y];
                    beforeXIndex = x;
                    beforeYIndex = y;
                }
                // 밀착
                int side=0;
                for(int y=0;y<N;y++){
                    if(map[x][y]==0) continue;
                    if(side==y) {
                        side++;
                        continue;
                    }
                    map[x][side] = map[x][y];
                    map[x][y] =0;
                    side++;
                }
            }

        } else if (arrow==3) {
            for(int x=0;x<N;x++){
                int before =0;
                int beforeXIndex =0;
                int beforeYIndex =0;
                // 0을 제외한 인접한 같은 숫자 합치기
                for(int y=N-1;y>=0;y--){
                    if(map[x][y]==0) continue;
                    if(before==map[x][y]){
                        map[beforeXIndex][beforeYIndex] *= 2;
                        if (map[beforeXIndex][beforeYIndex]>max) max = map[beforeXIndex][beforeYIndex];
                        before =0;
                        map[x][y] =0;
                        continue;
                    }
                    if (map[x][y]>max) max = map[x][y];
                    before=map[x][y];
                    beforeXIndex = x;
                    beforeYIndex = y;
                }
                // 밀착
                int side =N-1;
                for(int y=N-1;y>=0;y--){
                    if(map[x][y]==0) continue;
                    if(side==y) {
                        side--;
                        continue;
                    }
                    map[x][side] = map[x][y];
                    map[x][y] =0;
                    side--;
                }
            }
        }


        int[][] copy;
        for(int i=0;i<4;i++){
            copy = new int[N][N];
            for(int j=0;j<N;j++){
                for(int k=0;k<N;k++){
                    copy[j][k] = map[j][k];
                }
            }
            dfs(copy,i,depth+1);
        }
    }


}
