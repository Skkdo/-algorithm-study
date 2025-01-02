import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;


public class Main {

    private static class Locate {
        int x;
        int y;

        public Locate(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Locate[] array = new Locate[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            array[i] = new Locate(x,y);
        }

        Arrays.sort(array, Comparator.comparingInt((Locate locate) -> locate.x)
                .thenComparing(locate -> locate.y));

        for(Locate locate : array){
            bw.write(locate.x +" "+ locate.y);
            bw.newLine();
        }
        bw.flush();
    }
}