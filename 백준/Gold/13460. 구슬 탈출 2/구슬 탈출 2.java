import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int Min = -1;

    static class Ball{
        int x;
        int y;
        char type;
        Ball(char type,int x,int y){
            this.x = x;
            this.y = y;
            this.type = type;
        }
        Ball(char type){
            this.type = type;
        }
        void setXY(int x,int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int mapY = Integer.parseInt(st.nextToken());
        int mapX = Integer.parseInt(st.nextToken());
        char[][] map = new char[mapY][mapX];
        Ball redBall = new Ball('R');
        Ball blueBall = new Ball('B');

        for(int i=0;i<mapY;i++){
            String input = br.readLine();
            for(int j=0;j<mapX;j++){
                char ch = input.charAt(j);
                map[i][j] = ch;
                if(ch=='B'){
                    blueBall.setXY(j,i);
                }
                if(ch=='R'){
                    redBall.setXY(j,i);
                }
            }
        }

        play(1,redBall,blueBall,map);
        System.out.println(Min);
    }

    static void play(int depth,Ball redBall,Ball blueBall,char[][] map){
        if(depth > 10){
            return;
        }

        char[][] copyMap;
        Ball copyRedBall;
        Ball copyBlueBall;
        for(int i=0;i<4;i++){
            copyMap = new char[map.length][];
            for(int j=0;j< copyMap.length;j++){
                copyMap[j] = Arrays.copyOf(map[j],map[j].length);
            }
            copyRedBall = new Ball(redBall.type, redBall.x, redBall.y);
            copyBlueBall = new Ball(blueBall.type, blueBall.x, blueBall.y);

            int res = control(i,copyRedBall,copyBlueBall,copyMap);
            if(res == -1) continue;
            if(res == 1) {
                if(Min == -1) Min = depth;
                if(Min != -1) Min = Math.min(depth,Min);
            }
            if(res == 0) play(depth+1,copyRedBall,copyBlueBall,copyMap);
        }
    }

    static int control(int direction,Ball redBall,Ball blueBall, char[][] map) {
        boolean check = false;
        int nextX = redBall.x;
        int nextY = redBall.y;

        while(true){
            nextX += dx[direction];
            nextY += dy[direction];
            if(map[nextY][nextX]=='B') check = true;
            if(map[nextY][nextX]=='#') break;
        }

        int resultBlue;
        int resultRed;
        if(check){
            resultBlue = move(direction,blueBall,map);
            if(resultBlue == -1) return -1;
            resultRed = move(direction,redBall,map);
            return resultRed;
        }
        resultRed = move(direction,redBall,map);
        resultBlue = move(direction,blueBall,map);
        if(resultBlue == -1) return -1;

        return resultRed;
    }

    static int move(int direction,Ball ball ,char[][] map) {
        int nextX = ball.x;
        int nextY = ball.y;
        while(true){
            nextX += dx[direction];
            nextY += dy[direction];
            if(map[nextY][nextX]=='R'||map[nextY][nextX]=='B'||map[nextY][nextX]=='#') break;
            if(map[nextY][nextX]=='O'&&ball.type=='R'){
                map[ball.y][ball.x]='.';
                return 1;
            }
            if(map[nextY][nextX]=='O'&&ball.type=='B') return -1;

            map[ball.y][ball.x]='.';
            ball.setXY(nextX,nextY);
            map[ball.y][ball.x]=ball.type;
        }
        return 0;
    }


}
