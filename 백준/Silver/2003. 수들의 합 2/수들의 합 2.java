import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] array = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            int num = Integer.parseInt(st.nextToken());
            array[i] = num;
        }

        int answer = countPartSum(array,M);
        System.out.print(answer);
    }

    private static int countPartSum(int[] array, int find){
        int answer = 0;
        int tail = 0;
        int head = 0;
        int sum = array[0];

        while(tail < array.length){

            if(sum < find) {
                head++;
                if(head >= array.length) break;
                sum += array[head];
            }
            else if(sum > find) {
                sum -= array[tail];
                tail++;
            }
            else {
                answer++;

                head++;
                if(head >= array.length) break;
                sum += array[head];

                sum -= array[tail];
                tail++;
            }
        }
        return answer;
    }

}