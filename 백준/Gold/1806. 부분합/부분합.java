import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int min = N;
        long[] array = new long[N];

        st = new StringTokenizer(br.readLine());
        array[0] = Integer.parseInt(st.nextToken());
        for (int i = 1; i < N; i++) {
            array[i] = array[i - 1] + Integer.parseInt(st.nextToken());
        }

        if (array[N - 1] < S) {
            System.out.println(0);
            return;
        }

        int tail = Arrays.binarySearch(array, S);
        if (tail < 0) {
            tail = -(tail + 1);
        }

        for (; tail < N; tail++) {
            long diff = array[tail] - S;
            int count_tail = tail + 1;
            int count_head;

            int head = Arrays.binarySearch(array, diff);
            if (head < 0) {
                head = -(head + 1);
                count_head = head;
            }else {
                count_head = head + 1;
            }

            int count = count_tail - count_head;
            min = Math.min(min, count);
        }
        System.out.println(min);
    }
}
