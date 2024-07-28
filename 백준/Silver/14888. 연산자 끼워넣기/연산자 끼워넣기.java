import java.util.*;
import java.io.*;


public class Main {

    private static int MAX = Integer.MIN_VALUE;
    private static int MIN = Integer.MAX_VALUE;


    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] numArr = new int[N];
        int[] cmd = new int[4];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            int n = Integer.parseInt(st.nextToken());
            numArr[i] = n;
        }
        st = new StringTokenizer(br.readLine());
        for (int i=0;i<4;i++){
            int n = Integer.parseInt(st.nextToken());
            cmd[i] = n;
        }

        for(int i=0;i<4;i++){
            if(cmd[i]==0) continue;
            int[] cmdCopy = {
                    cmd[0],
                    cmd[1],
                    cmd[2],
                    cmd[3]
            };
            dfs(numArr,cmdCopy,i,numArr[0],1);
        }
        System.out.println(MAX);
        System.out.println(MIN);

    }

    private static void dfs(int[] numArr,int[] cmdCopy,int cmd,int result,int depth){

        int num = numArr[depth];
        cmdCopy[cmd]--;
        switch (cmd){
            case 0:
                result +=num;
                break;
            case 1:
                result -=num;
                break;
            case 2:
                result *=num;
                break;
            case 3:
                result /=num;
        }

        if(depth==numArr.length-1){
            if (result>MAX) MAX = result;
            if(result<MIN) MIN = result;
            return;
        }

        for (int i=0;i<4;i++){
            if(cmdCopy[i]==0) continue;
            int[] copy = {
                    cmdCopy[0],
                    cmdCopy[1],
                    cmdCopy[2],
                    cmdCopy[3]
            };
            dfs(numArr,copy,i,result,depth+1);
        }

    }

}
