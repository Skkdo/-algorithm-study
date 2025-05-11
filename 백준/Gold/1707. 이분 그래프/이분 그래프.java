import java.util.*;
import java.io.*;

public class Main {
    static int v,e;
    static ArrayList<Integer>[] nodeList;
    static boolean[] check;
    static int[] group;
    static int pre;
    static boolean stop;


    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int testCase = Integer.parseInt(st.nextToken());

        for(int i=0;i<testCase;i++){
            st = new StringTokenizer(br.readLine());
             v = Integer.parseInt(st.nextToken());
             e = Integer.parseInt(st.nextToken());

             nodeList = new ArrayList[v+1];
             check = new boolean[v+1];
             group = new int[v+1];
             stop = false;

           for(int j=0;j<v;j++){
               nodeList[j+1] = new ArrayList<>();
           }


            for(int j=0;j<e;j++){
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                nodeList[start].add(end);
                nodeList[end].add(start);
            }

            for(int j=0;j<v;j++){
                if(stop==true) break;
                if(check[j]==true) continue;

                pre= j+1;
                check = new boolean[v+1];
                group = new int[v+1];
                DFS(j+1,1);



            }
            if(stop) System.out.println("NO");
            else System.out.println("YES");

        }



    }

    private static void DFS(int i,int num) {
        if(stop==true) return;
        if(check[i]==true){
            if(group[pre]==group[i]){
                stop=true;
            }
            return;
        }
        check[i] =true;
        group[i] = num;
        num = num * -1;


        for(int j=0;j<nodeList[i].size();j++){
            int now = nodeList[i].get(j);
            pre =i;
            DFS(now,num);

        }
    }


}








