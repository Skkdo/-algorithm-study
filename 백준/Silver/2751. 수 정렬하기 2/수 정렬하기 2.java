import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        int[] array = new int[N];
        
        for(int i=0;i<N;i++){
            int input = Integer.parseInt(br.readLine());
            array[i] = input;
        }
        
        Arrays.sort(array);
        
        for(int num : array){
            bw.write(String.valueOf(num));
            bw.newLine();
            bw.flush();
        }
        bw.close();
    }
}