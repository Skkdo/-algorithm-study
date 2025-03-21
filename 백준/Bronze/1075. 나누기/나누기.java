import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int F = Integer.parseInt(st.nextToken());

        int min = N / 100 * 100;
        for (int i = 0; i < 100; i++) {
            if (min % F == 0) {
                break;
            }
            min++;
        }

        int lastTwo = min % 100;
        String answer = Integer.toString(lastTwo);

        if (answer.length() == 1) {
            answer = "0" + answer;
        }
        System.out.println(answer);
    }
}
