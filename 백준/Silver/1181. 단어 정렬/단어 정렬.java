import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[] array = new String[N];

        for(int i=0;i<N;i++){
            String input = br.readLine();
            array[i] = input;
        }

        Arrays.sort(array, Comparator.comparing(String::length)
                .thenComparing(Comparator.naturalOrder()));

        array = Arrays.stream(array).distinct().toArray(String[]::new);

        for(String string : array){
            bw.write(string);
            bw.newLine();
        }
        bw.flush();
    }
}