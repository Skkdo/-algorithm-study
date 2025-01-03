import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] array = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array);

        int left = 0;
        int right = N - 1;
        int closestSum = Integer.MAX_VALUE;
        int waterA = 0;
        int waterB = 0;
   
        while (left < right) {
            int sum = array[left] + array[right];

            if (Math.abs(sum) < closestSum) {
                closestSum = Math.abs(sum);
                waterA = array[left];
                waterB = array[right];
            }
           
            if (sum < 0) {
                left++;
            }             
            else if (sum > 0) {
                right--;
            }            
            else {
                break;
            }
        }

        System.out.println(waterA + " " + waterB);
    }
}
