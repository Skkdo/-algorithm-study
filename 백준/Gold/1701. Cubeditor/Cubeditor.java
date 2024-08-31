import java.io.*;
import java.util.*;

public class Main {
    static int[] table;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String string = br.readLine();
        max = 0;
        for(int i=0;i<string.length();i++){
            getTable(string.substring(i));
        }
        System.out.println(max);
    }

    static void getTable(String pattern){
        table = new int[pattern.length()];
        int begin = 1;
        int m = 0;
        while(begin+m<pattern.length()){
            if(pattern.charAt(begin+m)==pattern.charAt(m)){
                m++;
                table[begin+m-1] = m;
                if(max<m) max =m;
            }else{
                if(m==0){
                    begin++;
                }else{
                    begin += m-table[m-1];
                    m = table[m-1];
                }
            }
        }
    }


}