import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        String answer = "";

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String result = st.nextToken();

            if (answer.isEmpty()) {
                answer = result;
            } else {
                for (int j = 0; j < answer.length(); j++) {
                    char answerWord = answer.charAt(j);
                    char resultWord = result.charAt(j);
                    if(answerWord != resultWord) {
                        answer = answer.substring(0,j) + "?" + answer.substring(j + 1);
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
