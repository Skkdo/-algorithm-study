import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (isTrue(i)) {
                count++;
            }
        }
        System.out.println(count);
    }

    private static boolean isTrue(int num) {
        String stringNum = Integer.toString(num);
        int diff = 0;

        if (stringNum.length() < 3) {
            return true;
        } else {
            diff = stringNum.charAt(1) - stringNum.charAt(0);
        }

        for (int i = 1; i < stringNum.length(); i++) {
            if (diff != stringNum.charAt(i) - stringNum.charAt(i - 1)) {
                return false;
            }
        }
        return true;
    }
}
