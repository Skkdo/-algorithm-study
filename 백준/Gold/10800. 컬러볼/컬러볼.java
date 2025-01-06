import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    private static class Ball {
        int no;
        int color;
        int size;
        int resultScore;

        private Ball(int no, int color, int size) {
            this.no = no;
            this.color = color;
            this.size = size;
            this.resultScore = 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Ball[] array = new Ball[N];
        Map<Integer, Integer> colorMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int color = Integer.parseInt(st.nextToken());
            int size = Integer.parseInt(st.nextToken());
            array[i] = new Ball(i + 1, color, size);
            colorMap.put(color, 0);
        }

        Arrays.sort(array, Comparator
                .comparingInt((Ball b) -> b.size)
                .thenComparingInt(b -> b.color));

        logic(array, colorMap);

        Arrays.sort(array, Comparator.comparingInt((Ball b) -> b.no));

        StringBuilder builder = new StringBuilder();
        for (Ball ball : array) {
            int resultScore = ball.resultScore;
            builder.append(resultScore)
                    .append("\n");
        }
        System.out.println(builder);
    }

    private static void logic(Ball[] array, Map<Integer, Integer> colorMap) {
        int sameSize_buffer = 0;
        int totalScore = 0;
        int sameColor_buffer = 0;
        int preSize = array[0].size;
        int preColor = array[0].color;

        for (Ball ball : array) {
            int ballSize = ball.size;
            int ballColor = ball.color;

            if (ballSize > preSize) {
                totalScore += sameSize_buffer;
                sameSize_buffer = 0;
                preSize = ballSize;

                Integer colorStack = colorMap.get(preColor);
                colorStack += sameColor_buffer;
                colorMap.replace(preColor, colorStack);

                preColor = ballColor;
                sameColor_buffer = 0;
            }

            if (ballColor != preColor) {
                Integer colorStack = colorMap.get(preColor);
                colorStack += sameColor_buffer;
                colorMap.replace(preColor, colorStack);

                preColor = ballColor;
                sameColor_buffer = 0;
            }

            Integer colorStack = colorMap.get(ballColor);
            ball.resultScore = totalScore - colorStack;

            sameSize_buffer += ballSize;
            sameColor_buffer += ballSize;
        }
    }
}

