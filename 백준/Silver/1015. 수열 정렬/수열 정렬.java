import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        int[] B = new int[N];
        boolean[] check = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            A[i] = num;
            B[i] = num;
        }

        Arrays.sort(B);

        for (int i = 0; i < N; i++) {
            int find = A[i];
            for (int j = 0; j < N; j++) {
                if (!check[j] && find == B[j]) {
                    sb.append(j).append(" ");
                    check[j] = true;
                    break;
                }
            }
        }
        System.out.println(sb);
    }
}
