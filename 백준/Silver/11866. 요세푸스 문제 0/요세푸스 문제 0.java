import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        Queue<Integer> q = new ArrayDeque<>();
        for(int i=1;i<=N;i++){
            q.add(i);
        }
        
        sb.append("<");
        while(q.size() > 1){
            
            for(int i=1;i<=K;i++){
                int num = q.poll();
                if(i == K){
                    sb.append(num).append(", ");                   
                }else {
                    q.add(num);
                }
            }         
        }
        int last = q.poll();
        sb.append(last).append(">");
        System.out.print(sb);
    }
}