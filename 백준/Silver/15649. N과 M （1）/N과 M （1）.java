import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] array = new int[n + 1];
        boolean[] check = new boolean[n + 1];

        for (int i = 1; i < array.length; i++) {
            array[i] = i;
        }

        bfs(array, check, 0, m, sb);
    }

    private static void bfs(int[] array, boolean[] check, int depth, int m, StringBuilder sb) {
        if (depth == m) {
            System.out.println(sb);
            return;
        }

        for (int i = 1; i < array.length; i++) {
            if (check[i]) {
                continue;
            }
            check[i] = true;
            sb.append(array[i]).append(" ");
            bfs(array, check, depth + 1, m, sb);
            sb.delete(sb.length() - 2, sb.length());
            check[i] = false;
        }
    }
}
