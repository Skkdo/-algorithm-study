import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int max = 0;
        char[][] map = new char[N][N];
        for(int i=0;i<N;i++){
            String string = br.readLine();
            for(int j=0;j<N;j++){
                map[i][j] = string.charAt(j);
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<N-1;j++){
                max = getMax(map, j, i, max);
            }
        }
        System.out.print(max);
    }

    public static int getMax(char[][] map, int j, int i, int max) {
        int[] array = new int[6];
        swapC(map, j, j +1, i);
        array[0] = checkC(map, j, i);
        array[1] = checkR(map, i, j);
        array[2] = checkR(map, i, j +1);
        swapC(map, j, j +1, i);

        swapR(map, j, j +1, i);
        array[3] = checkR(map, j, i);
        array[4] = checkC(map, i, j);
        array[5] = checkC(map, i, j +1);
        swapR(map, j, j +1, i);
        Arrays.sort(array);
        int count = array[5];
        if(count> max) max = count;
        return max;
    }

    public static int checkC(char[][] map, int index1,int index2){
        char find = map[index2][index1];
        int count = 0;
        int max = 0;
        for(int i=0;i< map.length;i++){
            if(find == map[index2][i]) {
                count++;
                if(count>max) max = count;
            }else{
                count = 0;
            }
        }
        return max;
    }

    public static int checkR(char[][] map, int index1,int index2){
        char find = map[index1][index2];
        int count = 0;
        int max = 0;
        for(int i=0;i<map.length;i++){
            if(find == map[i][index2]) {
                count++;
                if(count>max) max = count;
            }else{
                count = 0;
            }
        }
        return max;
    }

    public static void swapC(char[][] map, int index1,int index2,int index3){
        char tmp = map[index3][index1];
        map[index3][index1] = map[index3][index2];
        map[index3][index2] = tmp;
    }
    public static void swapR(char[][] map, int index1,int index2,int index3){
        char tmp = map[index1][index3];
        map[index1][index3] = map[index2][index3];
        map[index2][index3] = tmp;
    }
}