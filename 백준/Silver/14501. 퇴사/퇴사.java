import java.util.*;
import java.io.*;


public class Main {

    private static class Work{
        int T;
        int P;

        public Work(int t,int p){
            this.T =t;
            this.P =p;
        }
    }
    private static ArrayList<Work> arrayList;
    private static int Max;
    private static int N;

    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arrayList = new ArrayList<>(N);
        Max = 0;

        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            Work work = new Work(t,p);
            arrayList.add(i,work);
        }

        for(int i =0;i<N;i++){
            if(arrayList.get(i).T+i>N) continue;
            bfs(i,0);
        }
        System.out.println(Max);
    }

    private static void bfs(int day,int totalMoney){
        Work work = arrayList.get(day);

        day += work.T;
        if (day>N) return;

        totalMoney += work.P;
        if(totalMoney>Max) Max = totalMoney;

        for(int i=day;i<N;i++){
            bfs(i,totalMoney);
        }

    }
}
