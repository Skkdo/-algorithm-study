import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            pq.add(num);
        }

        int totalSum = 0;
        while(pq.size() > 1){
            int numA = pq.poll();
            int numB = pq.poll();

            int sum = numA + numB;
            totalSum += sum;
            pq.add(sum);
        }
        System.out.print(totalSum);
    }
}