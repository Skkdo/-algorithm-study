import java.util.*;
import java.io.*;


public class Main {

    private static class XY{
        int x;
        int y;

        public XY(int x,int y){
            this.x = x;
            this.y = y;
        }

    }


    public static void main(String[] args)throws IOException {

        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};
        int dxdyIndex = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];

        int K = Integer.parseInt(br.readLine());
        for(int i=0;i<K;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x-1][y-1] = 1;
        }
        int L = Integer.parseInt(br.readLine());
        String[] cmd = new String[10001];
        for(int i=0;i<L;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            String C = st.nextToken();
            cmd[x] = C;
        }

        Queue<XY> queue = new LinkedList<>();
        int x =0;
        int y =1;
        int time;
        queue.add(new XY(0,0));
        map[0][0] = -1;
        for(time=1;time<=10000;){
            if(x>=N||y>=N||x<0||y<0) break;

            XY xy = new XY(x,y);
            if (map[x][y]==-1) break;

            queue.add(xy);

            if (map[x][y]==0){
                XY tail =queue.poll();
                map[tail.x][tail.y] = 0;
            }
            map[x][y] =-1;

            if (cmd[time]!=null){
                String C = cmd[time];
                if(C.equals("D")){
                    if (dxdyIndex==3) dxdyIndex =-1;
                    dxdyIndex++;
                }
                if(C.equals("L")){
                    if (dxdyIndex==0) dxdyIndex =4;
                    dxdyIndex--;
                }
            }

            x = x+dx[dxdyIndex];
            y = y+dy[dxdyIndex];
            time++;

        }
        System.out.println(time);




    }


}
