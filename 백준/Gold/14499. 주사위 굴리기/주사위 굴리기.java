import java.io.*;
import java.util.*;

public class Main {

    private static int[][] MAP;
    private static int X;
    private static int Y;
    private static int N;
    private static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N =Integer.parseInt(st.nextToken());
        M =Integer.parseInt(st.nextToken());
        Y =Integer.parseInt(st.nextToken());
        X =Integer.parseInt(st.nextToken());
        int k =Integer.parseInt(st.nextToken());

        MAP = new int[N][M];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                int num = Integer.parseInt(st.nextToken());
                MAP[i][j] = num;
            }
        }

        Dise dise = new Dise();
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<k;i++){
            int cmd = Integer.parseInt(st.nextToken());
            roll(cmd,dise);
        }
    }
    public static void roll(int cmd, Dise dise){
        int mapNum;
        switch(cmd){
            case 1:
                if(X+1 >= M) return;

                X++;
                mapNum = MAP[Y][X];
                dise.right();

                if(mapNum==0){
                    MAP[Y][X] = dise.values[dise.bottomIndex];
                }else {
                    dise.values[dise.bottomIndex] = mapNum;
                    MAP[Y][X] = 0;
                }
                break;

            case 2:
                if(X-1<0) return;

                X--;
                mapNum = MAP[Y][X];
                dise.left();

                if(mapNum==0){
                    MAP[Y][X] = dise.values[dise.bottomIndex];
                }else {
                    dise.values[dise.bottomIndex] = mapNum;
                    MAP[Y][X] = 0;
                }
                break;

            case 3:
                if(Y-1<0) return;

                Y--;
                mapNum = MAP[Y][X];
                dise.up();

                if(mapNum==0){
                    MAP[Y][X] = dise.values[dise.bottomIndex];
                }else {
                    dise.values[dise.bottomIndex] = mapNum;
                    MAP[Y][X] = 0;
                }
                break;

            case 4:
                if(Y+1 >= N) return;

                Y++;
                mapNum = MAP[Y][X];
                dise.down();

                if(mapNum==0){
                    MAP[Y][X] = dise.values[dise.bottomIndex];
                }else {
                    dise.values[dise.bottomIndex] = mapNum;
                    MAP[Y][X] = 0;
                }
        }
        System.out.println(dise.values[dise.topIndex]);
    }
    private static class Dise{
        private int[] values = {0,0,0,0,0,0};
        private int frontIndex = 0;
        private int rightIndex = 1;
        private int backIndex = 2;
        private int leftIndex = 3;
        private int topIndex = 4;
        private int bottomIndex = 5;

        private void up(){
            int front = this.values[frontIndex];
            int back = this.values[backIndex];
            int top = this.values[topIndex];
            int bottom = this.values[bottomIndex];
            this.values[frontIndex] = top;
            this.values[backIndex] = bottom;
            this.values[topIndex] = back;
            this.values[bottomIndex] = front;
        }
        private void down(){
            int front = this.values[frontIndex];
            int back = this.values[backIndex];
            int top = this.values[topIndex];
            int bottom = this.values[bottomIndex];
            this.values[frontIndex] = bottom;
            this.values[backIndex] = top;
            this.values[topIndex] = front;
            this.values[bottomIndex] = back;
        }
        private void left(){
            int top = this.values[topIndex];
            int bottom = this.values[bottomIndex];
            int right = this.values[rightIndex];
            int left = this.values[leftIndex];
            this.values[topIndex] = right;
            this.values[rightIndex] = bottom;
            this.values[leftIndex] = top;
            this.values[bottomIndex] = left;
        }
        private void right(){
            int top = this.values[topIndex];
            int bottom = this.values[bottomIndex];
            int right = this.values[rightIndex];
            int left = this.values[leftIndex];
            this.values[topIndex] = left;
            this.values[rightIndex] = top;
            this.values[leftIndex] = bottom;
            this.values[bottomIndex] = right;
        }
    }
}


