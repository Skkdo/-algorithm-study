import java.util.*;
import java.io.*;


public class Main {

    private static class XY{
        int x;
        int y;

        public XY(int x,int y){
            this.x=x;
            this.y=y;
        }
    }

    private static class Case{
        XY xy1;
        XY xy2;
        XY xy3;
        XY xy4;

        public Case(XY xy, int version){
            XY xy1 = new XY(xy.x, xy.y);
            if (version ==1){
                this.xy1= xy1;
                this.xy2= new XY(xy1.x+1, xy1.y);
                this.xy3= new XY(xy1.x+2, xy1.y);
                this.xy4= new XY(xy1.x+3, xy1.y);
            } else if (version == 2) {
                this.xy1=xy;
                this.xy2= new XY(xy1.x+1, xy1.y);
                this.xy3= new XY(xy1.x, xy1.y+1);
                this.xy4= new XY(xy1.x+1, xy1.y+1);
            }else if (version == 3) {
                this.xy1=xy;
                this.xy2= new XY(xy1.x, xy1.y+1);
                this.xy3= new XY(xy1.x, xy1.y+2);
                this.xy4= new XY(xy1.x+1, xy1.y+2);
            }else if (version == 4) {
                this.xy1=xy;
                this.xy2= new XY(xy1.x, xy1.y+1);
                this.xy3= new XY(xy1.x, xy1.y+2);
                this.xy4= new XY(xy1.x-1, xy1.y+2);
            }else if (version == 5) {
                this.xy1=xy;
                this.xy2= new XY(xy1.x, xy1.y+1);
                this.xy3= new XY(xy1.x+1, xy1.y+1);
                this.xy4= new XY(xy1.x+1, xy1.y+2);
            }else if (version == 6) {
                this.xy1=xy;
                this.xy2= new XY(xy1.x, xy1.y+1);
                this.xy3= new XY(xy1.x-1, xy1.y+1);
                this.xy4= new XY(xy1.x-1, xy1.y+2);
            }else if (version == 7) {
                this.xy1=xy;
                this.xy2= new XY(xy1.x+1, xy1.y);
                this.xy3= new XY(xy1.x+1, xy1.y+1);
                this.xy4= new XY(xy1.x+2, xy1.y);
            }


        }
        public boolean check(int[][] map, int version) {
            int xLength = map[0].length;
            int yLength = map.length;

            if (version == 1) {
                if (this.xy4.x >= xLength) return false;
                return true;
            } else if (version == 2) {
                if(this.xy4.x>= xLength||this.xy4.y>=yLength) return false;
                return true;
            }else if (version == 3) {
                if(this.xy4.x>= xLength||this.xy4.y>=yLength) return false;
                return true;
            }else if (version == 4) {
                if(this.xy4.x<0||this.xy4.y>=yLength) return false;
                return true;
            }else if (version == 5) {
                if(this.xy4.x>=xLength||this.xy4.y>=yLength) return false;
                return true;
            }else if (version == 6) {
                if(this.xy4.x<0||this.xy4.y>=yLength) return false;
                return true;
            }else if (version == 7) {
                if(this.xy4.x>=xLength||this.xy3.y>=yLength) return false;
                return true;
            }
            return false;
        }
        public int sum(int[][] map){
            int sum =0;
            sum += map[this.xy1.y][this.xy1.x];
            sum += map[this.xy2.y][this.xy2.x];
            sum += map[this.xy3.y][this.xy3.x];
            sum += map[this.xy4.y][this.xy4.x];
            return sum;
        }

    }

    private static int MAX =0;

    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map1 = new int[N][M];
        int[][] map2 = new int[M][N];
        int[][] map3 = new int[N][M];
        int[][] map4 = new int[M][N];

        for (int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<M;j++){
                int num = Integer.parseInt(st.nextToken());
                map1[i][j] =num;
                map2[j][N-i-1] =num;
                map3[N-i-1][M-j-1] = num;
                map4[M-j-1][i] =num;
            }
        }

        for (int i=1;i<=7;i++){
            findMax(map1,i);
            findMax(map2,i);
            findMax(map3,i);
            findMax(map4,i);
        }

        System.out.println(MAX);
    }

    private static void findMax(int[][] map, int version){
        int x = map[0].length;
        int y = map.length;

        for(int i=0;i<y;i++){
            for (int j=0;j<x;j++){
                XY xy = new XY(j,i);
                Case tetro = new Case(xy,version);
                if(tetro.check(map,version)){
                    int max = tetro.sum(map);
                    if(max>MAX) MAX =max;
                }
            }
        }


    }


}
