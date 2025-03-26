import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int answer = logic(64, 64, x, 1);
        System.out.println(answer);
    }

    private static int logic(int total, int shortest, int find, int count) {
        if (total == find) {
            return count;
        }

        shortest /= 2;
        total -= shortest;

        if (total >= find) {
            return logic(total, shortest, find, count);
        } else {
            return logic(total + shortest, shortest, find, count + 1);
        }
    }
}
