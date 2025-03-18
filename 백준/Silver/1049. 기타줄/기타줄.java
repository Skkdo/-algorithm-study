import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] sixList = new int[M];
        int[] oneList = new int[M];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int six = Integer.parseInt(st.nextToken());
            int one = Integer.parseInt(st.nextToken());

            oneList[i] = one;
            if (six > 6 * one) {
                sixList[i] = 6 * one;
            } else {
                sixList[i] = six;
            }
        }

        Arrays.sort(sixList);
        Arrays.sort(oneList);

        int minSix = sixList[0];
        int minOne = oneList[0];

        int sum = N / 6 * minSix;
        sum += Math.min(minSix, N % 6 * minOne);

        System.out.println(sum);
    }
}
