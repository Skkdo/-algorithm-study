
import java.util.*;
import java.io.*;

public class Main{

    // 위 아래 왼쪽 오른쪽 U,D,L,R
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};

    static char[][] map;
    static int R;
    static int C;

    static int score;
    static int goal;
    static int x;
    static int y;
    static boolean isComplete;
    static String cmdString;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args)throws IOException{
        int gameCount = 1;
        while(true){
            init();
            play();
            if(isComplete){
                System.out.println("Game "+gameCount+": complete");
            }else{
                System.out.println("Game "+gameCount+": incomplete");
            }
            showMap();
            gameCount++;
        }
    }

    static void init()throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        if(R==0&&C==0){
            System.exit(0);
        }

        map = new char[R][C];
        score =0;
        goal =0;
        isComplete = false;

        for(int i=0;i<R;i++){
            String string = br.readLine();
            for(int j=0;j<C;j++){
                char ch = string.charAt(j);
                map[i][j] = ch;
                if(ch =='B'||ch=='+'||ch=='W') goal++;
                if(ch=='w'||ch=='W'){
                    x = j;
                    y = i;
                }
                if(ch =='B') score++;
            }
        }
        cmdString =br.readLine();
    }

    static void play(){
        if(cmdString==null) return;
        for(int i =0;i<cmdString.length();i++){
            char cmd = cmdString.charAt(i);
            int nextX;
            int nextY;
            int beyondNextX;
            int beyondNextY;
            if(cmd == 'U'){
                nextX = x+dx[0];
                nextY = y+dy[0];
                beyondNextX = nextX+dx[0];
                beyondNextY = nextY+dy[0];
                next(nextX,nextY,beyondNextX,beyondNextY);
            }
            if(cmd == 'D'){
                nextX = x+dx[1];
                nextY = y+dy[1];
                beyondNextX = nextX+dx[1];
                beyondNextY = nextY+dy[1];
                next(nextX,nextY,beyondNextX,beyondNextY);
            }
            if(cmd == 'L'){
                nextX = x+dx[2];
                nextY = y+dy[2];
                beyondNextX = nextX+dx[2];
                beyondNextY = nextY+dy[2];
                next(nextX,nextY,beyondNextX,beyondNextY);
            }
            if(cmd == 'R'){
                nextX = x+dx[3];
                nextY = y+dy[3];
                beyondNextX = nextX+dx[3];
                beyondNextY = nextY+dy[3];
                next(nextX,nextY,beyondNextX,beyondNextY);
            }
            if(score == goal) {
                isComplete = true;
                return;
            }
        }
    }

    static void next(int nextX, int nextY, int beyondNextX, int beyondNextY){
        char nextCh = map[nextY][nextX];
        char beyondNextCh;
        
        if(beyondNextX < 0 || beyondNextX >= C || beyondNextY < 0 || beyondNextY >= R){
            beyondNextCh = '#';
        }else{
            beyondNextCh = map[beyondNextY][beyondNextX];
        }

       if(nextCh == '#') return;
       if(nextCh=='.'){
           move(nextX,nextY);
           return;
       }
        if(nextCh=='+'){
            move(nextX,nextY);
            return;
        }

       if(beyondNextCh=='#'||beyondNextCh=='b'||beyondNextCh=='B') return;
       if(nextCh=='b'){
           beyond(beyondNextX,beyondNextY,beyondNextCh);
           move(nextX,nextY);
           return;
       }
       if(nextCh=='B'){
           score--;
           beyond(beyondNextX,beyondNextY,beyondNextCh);
           move(nextX,nextY);
       }
    }

    static void move(int nextX,int nextY){

        if(map[y][x]=='W'){
            map[y][x] = '+';
        }else{
            map[y][x] = '.';
        }

        if(map[nextY][nextX]=='+'||map[nextY][nextX]=='B'){
            map[nextY][nextX] = 'W';
        }else{
            map[nextY][nextX] = 'w';
        }
        x = nextX;
        y = nextY;
    }

    static void beyond(int beyondNextX, int beyondNextY,char beyondNextCh){
        if(beyondNextCh == '.'){
            map[beyondNextY][beyondNextX] = 'b';
           return;
        }
        if(beyondNextCh == '+'){
            map[beyondNextY][beyondNextX] = 'B';
            score++;
        }
    }

    static void showMap(){
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

}