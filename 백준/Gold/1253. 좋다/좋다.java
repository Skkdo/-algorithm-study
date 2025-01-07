import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] array = new int[N];
        Map<Integer,Integer> map = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            int num = Integer.parseInt(st.nextToken());
            array[i] = num;
            if(map.containsKey(num)){
                int count = map.get(num);
                map.put(num,count+1);
            }else{
                map.put(num,1);
            }
        }

        Arrays.sort(array);
        int answer = 0;

        for(int i=0;i<N;i++){
            int sum = array[i];
            int sumCount = map.get(sum);
            map.put(sum,sumCount-1);
            
            for(int j=0;j<N;j++){
                int numA = array[j];
                int numA_count = map.get(numA);
                if (numA_count <= 0) continue;
                map.put(numA,numA_count-1);

                int numB = sum - numA;
                if(map.containsKey(numB) && map.get(numB) > 0){
                    answer++;
                    map.put(numA,numA_count);
                    break;
                }
                map.put(numA,numA_count);
            }
            map.put(sum,sumCount);
        }

        System.out.print(answer);
    }
}