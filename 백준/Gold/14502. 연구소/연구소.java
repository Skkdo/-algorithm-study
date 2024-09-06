import java.io.*;
import java.util.*;

public class Main {
    static int[] dx ={0,0,1,-1};
    static int[] dy ={1,-1,0,0};
    static class Locate{
        int x;
        int y;
        Locate(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
    static int[][] Map;
    static int N;
    static int M;
    static ArrayList<Locate> VirusList = new ArrayList<>();
    static int MaxSafeZone =Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Map = new int[N][M];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                int num = Integer.parseInt(st.nextToken());
                Map[i][j]= num;
                if(num == 2) VirusList.add(new Locate(j,i));
            }
        }
        addWall(0,0,1);
        System.out.println(MaxSafeZone);
    }
    static void addWall(int startX,int startY,int depth){
        if(depth>3){
            bfs(getCopyMap(), getVirusQueue());
            return;
        }
        for(int i=startY;i<N;i++){
            for (int j=startX;j<M;j++){
                if(Map[i][j]==0) {
                    Map[i][j] = 1;
                    addWall(j, i, depth + 1);
                    Map[i][j] = 0;
                }
            }
            startX =0;
        }
    }
    static Queue<Locate> getVirusQueue() {
        Queue<Locate> queue = new LinkedList<>();
        for(int i = 0; i< VirusList.size(); i++){
            queue.add(VirusList.get(i));
        }
        return queue;
    }
    static int[][] getCopyMap() {
        int[][] copyMap = new int[N][M];
        for(int i=0;i<N;i++){
            copyMap[i] = Arrays.copyOf(Map[i],M);
        }
        return copyMap;
    }

    static void bfs(int[][] map,Queue<Locate> queue) {
        while(!queue.isEmpty()){
            infection(map, queue);
        }

        int countSafeZone = countSafeZone(map);
        MaxSafeZone = Math.max(MaxSafeZone,countSafeZone);
    }

    static void infection(int[][] map, Queue<Locate> queue) {
        Locate virusLocate = queue.poll();

        for(int direction=0;direction<4;direction++){
            int nextX = virusLocate.x+dx[direction];
            int nextY = virusLocate.y+dy[direction];
            if(nextX<0||nextX>=M||nextY<0||nextY>=N) continue;

            if(map[nextY][nextX]==0){
                map[nextY][nextX]=2;
                queue.add(new Locate(nextX,nextY));
            }
        }
    }
    static int countSafeZone(int[][] map){
        int safeZone =0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j]==0) safeZone++;
            }
        }
        return safeZone;
    }

}
