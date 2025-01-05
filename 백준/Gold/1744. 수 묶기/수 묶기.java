import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] array = new int[N];
        int notPlusCount = 0;

        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());
            array[i] = input;
            if (input <= 0) {
                notPlusCount++;
            }
        }

        Arrays.sort(array);

        int sum = 0;
        for (int i = 0; i < notPlusCount; i++) {
            int preNum = array[i];
            int num = 1;
            if (i + 1 < notPlusCount) {
                num = array[i + 1];
                i++;
            }
            sum += preNum * num;
        }

        for (int i = N - 1; i > notPlusCount - 1; i--) {
            int num = array[i];
            int preNum = 1;
            if (i - 1 > notPlusCount - 1 && array[i - 1] != 1) {
                preNum = array[i - 1];
                i--;
            }
            sum += preNum * num;
        }
        System.out.println(sum);
    }
}