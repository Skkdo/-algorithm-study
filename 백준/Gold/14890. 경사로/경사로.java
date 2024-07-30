import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    private static int answer = 0;
    private static int L = 0;
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int n = Integer.parseInt(st.nextToken());
                map[i][j] = n;
            }
        }
        int[] line1;
        int[] line2;
        for (int i = 0; i < N; i++) {
            line1 = new int[N];
            line2 = new int[N];
            for (int j = 0; j < N; j++) {
                line1[j] = map[i][j];
                line2[j] = map[j][i];
            }
            check(line1);
            check(line2);
        }
        System.out.println(answer);

    }
    private static void check(int[] line) {

        int preHeight = line[0];
        int length = 1;

        for (int i = 1; i < N; i++) {
            int height = line[i];

            if (preHeight == height) {              // 평지
                length++;
            } else if (height > preHeight) {        // 오르막
                if (height - preHeight > 1) return;
                if (length < L) return;
                length = 1;
                preHeight = height;
            } else if (height < preHeight) {        // 내리막
                if (preHeight - height > 1) return;
                if (length < 0) return;
                length = 1 - L;
                preHeight = height;
            }
        }

        if (length < 0) return;
        answer++;
    }
}
