import java.util.*;
import java.io.*;

public class Main{

    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int dxdyIndex = 0;

    public static void main(String[] args)throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] map = new int[M][N];

        map[0][0] = 1;
        int x = 0;
        int y = 0;
        int answer = 0;
        int check = 1;

        while(true){
            if(check == N*M) break;
            int nextX = x + dx[dxdyIndex];
            int nextY = y + dy[dxdyIndex];
            if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= M || map[nextY][nextX] != 0){
                dxdyIndex++;
                if(dxdyIndex == 4) dxdyIndex = 0;
                answer++;
                continue;
            }
            x = nextX;
            y = nextY;
            map[y][x] = 1;
            check++;
        }
        System.out.println(answer);

    }
}