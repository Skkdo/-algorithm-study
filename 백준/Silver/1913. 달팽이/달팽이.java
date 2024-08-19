import java.util.*;
import java.io.*;

public class Main{

    static int[] dx = {0,1,0,-1};
    static int[] dy = {-1,0,1,0};
    static int dxdyIndex = 0;

    public static void main(String[] args)throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int N = Integer.parseInt(br.readLine());
        int find = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        int count = 1;

        int x =N/2;
        int y =N/2;
        int findX = 0;
        int findY = 0;
        map[y][x] = count;

        while(true){
            if(count == N*N) break;
            if(count == find){
                findX = x;
                findY = y;
            }
            int nextX = x + dx[dxdyIndex];
            int nextY = y + dy[dxdyIndex];
            if(map[nextY][nextX]==0){
                x = nextX;
                y = nextY;
                map[y][x] = ++count;
                dxdyIndex++;
                if(dxdyIndex == 4) dxdyIndex =0;
            }else{
                dxdyIndex--;
                if(dxdyIndex == -1) dxdyIndex =3;
            }
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
        System.out.print((findY+1)+" "+(findX+1));


    }
}