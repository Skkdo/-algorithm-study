import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<String,Integer> hashMap = new HashMap<>();

        for(int i=0;i<N;i++){
            String string = br.readLine();
            hashMap.put(string,0);
        }
        int count =0;
        for(int i=0;i<M;i++){
            String string = br.readLine();
            if(hashMap.containsKey(string)){
                count++;
            }
        }
        System.out.println(count);
    }
}