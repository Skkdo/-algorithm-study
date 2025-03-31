import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int A_num = Integer.parseInt(st.nextToken());
        int B_num = Integer.parseInt(st.nextToken());

        int round = 0;
        while (A_num != B_num) {
            round++;
            A_num = nextNum(A_num);
            B_num = nextNum(B_num);
        }
        System.out.print(round);
    }

    private static int nextNum(int num) {
        if (num == 1) {
            return 1;
        }
        if (num % 2 == 0) {
            return num / 2;
        } else {
            return (num + 1) / 2;
        }
    }
}
