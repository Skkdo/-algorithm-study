import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n];
        int[][] dp = new int[2][n]; // dp[i][0] : i가 최대일때 오름차순으로 최대 길이, dp[i][1] : 내림차순 최대 길이

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            array[i] = num;
        }

        Arrays.fill(dp[0], 1);
        Arrays.fill(dp[1], 1);

        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                if (array[i] > array[j]) {
                    dp[0][i] = Math.max(dp[0][i], dp[0][j] + 1);
                }
            }
        }

        for (int i = array.length - 2; i >= 0; i--) {
            for (int j = array.length - 1; j > i; j--) {
                if (array[i] > array[j]) {
                    dp[1][i] = Math.max(dp[1][i], dp[1][j] + 1);
                }
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            if (max < dp[0][i] + dp[1][i]) {
                max = dp[0][i] + dp[1][i];
            }
        }
        max--;
        System.out.print(max);
    }
}