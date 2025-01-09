import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Stack<Integer> stack = new Stack<>();
        StringBuilder builder = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] array = new int[N];
        int[] resultArray = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            array[i] = num;
        }

        stack.add(0);
        for (int i = 1; i < N; i++) {
            int num = array[i];
            while(!stack.empty() && array[stack.peek()] < num){
                Integer index = stack.pop();
                resultArray[index] = num;
            }
            stack.add(i);
        }

        while(!stack.isEmpty()){
            Integer index = stack.pop();
            resultArray[index] = -1;
        }

        for(int num : resultArray){
            builder
                    .append(num)
                    .append(" ");
        }

        System.out.print(builder);
    }
}