import java.io.*;
import java.util.*;

class Main
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] map = new int[100001];
        for (int i=0;i<map.length;i++) {
            map[i] = Integer.MAX_VALUE;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        map[n] =0;
        while(true){
            if (queue.isEmpty()) break;

            for (int i=0;i<queue.size();i++){
                int locate = queue.poll();
                int time = map[locate];
                if(locate-1>=0&&time+1<map[locate-1]){
                    map[locate-1] = time+1;
                    queue.add(locate-1);
                }
                if(locate+1<=100000&&time+1<map[locate+1]){
                    map[locate+1] = time+1;
                    queue.add(locate+1);
                }
                if (locate==0) continue;
                if(locate*2<=100000&&time<map[locate*2]){
                    map[locate*2] = time;
                    queue.add(locate*2);
                }
            }

        }
        System.out.println(map[k]);

    }
}

