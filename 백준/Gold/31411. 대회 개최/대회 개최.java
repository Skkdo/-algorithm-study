import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    private static class Quiz {
        int type;
        int level;

        private Quiz(int category, int level) {
            this.type = category;
            this.level = level;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Quiz[] array = new Quiz[N * K];

        for (int type = 0, index = 0; type < N; type++) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < K; i++) {
                int level = Integer.parseInt(st.nextToken());
                array[index++] = new Quiz(type, level);
            }
        }

        Arrays.sort(array, Comparator.comparingInt((Quiz q) -> q.level));

        int[] typeCount = new int[N];
        int types = 0;
        int answer = Integer.MAX_VALUE;
        int tail = 0;

        for (int head = 0; head < array.length; head++) {
            Quiz quiz = array[head];

            if (typeCount[quiz.type] == 0) {
                types++;
            }
            typeCount[quiz.type]++;

            while (types == N) {
                int sum = array[head].level - array[tail].level;
                answer = Math.min(answer, sum);

                Quiz deleteQuiz = array[tail++];
                typeCount[deleteQuiz.type]--;

                if (typeCount[deleteQuiz.type] == 0) {
                    types--;
                }
            }
        }
        System.out.print(answer);
    }
}