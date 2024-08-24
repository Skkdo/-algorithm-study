import java.io.*;
import java.util.*;

public class Main {

    static String[] compareArray = new String[2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] stringArray = new String[N];
        for(int i=0;i<N;i++){
            String string = br.readLine();
            stringArray[i] = string;
        }
        Arrays.sort(stringArray);
        int count =0;
        for(int i=0;i<M;i++){
            String find = br.readLine();
            if(search(stringArray,find,0,N-1)) count++;
        }
        System.out.println(count);
    }

    static boolean search(String[] stringArray,String find,int start,int end){
        if(start>end) return false;
        int mid = (start+end)/2;

        String compare = stringArray[mid];
        if(compare.length()>=find.length()){
            if(find.equals(compare.substring(0,find.length()))) return true;
        }

        compareArray[0] = compare;
        compareArray[1] = find;
        Arrays.sort(compareArray);
        boolean result = false;
        if(compareArray[0].equals(find)){
            result = search(stringArray,find,start,mid-1);
        }
        if(compareArray[0].equals(compare)){
            result = search(stringArray,find,mid+1,end);
        }
        return result;
    }
}