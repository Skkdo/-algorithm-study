import java.util.*;
import java.io.*;


public class Main {

    private static int[] dx = {0,1,0,-1};
    private static int[] dy = {-1,0,1,0};



    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];

        st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int dxdyIndex = Integer.parseInt(st.nextToken());

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                int n = Integer.parseInt(st.nextToken());
                map[i][j] = n;
            }
        }
        int answer =0;
        while(true){
            if(map[y][x]==0){
                answer++;
                map[y][x] = -1;
            }
            boolean check = false;
            for(int i=0;i<4;i++){
                int nextX = x+dx[i];
                int nextY = y+dy[i];
                if(map[nextY][nextX]==0) check = true;
            }

            if(check){
                for(int i=0;i<4;i++){
                    dxdyIndex--;
                    if(dxdyIndex==-1) dxdyIndex =3;
                    int nextX = x+dx[dxdyIndex];
                    int nextY = y+dy[dxdyIndex];
                    if(map[nextY][nextX]==0) break;
                }
               x = x+ dx[dxdyIndex];
               y = y+ dy[dxdyIndex];
            }else {
                int nextX = x- dx[dxdyIndex];
                int nextY = y- dy[dxdyIndex];
                if(map[nextY][nextX]==1) break;
                x = nextX;
                y = nextY;
            }

        }

        System.out.println(answer);
    }

}
