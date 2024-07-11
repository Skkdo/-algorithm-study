import java.io.*;
import java.util.*;

class Main
{
    public static void main(String[] args) throws Exception
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        while (testCase--!=0){
            int n = Integer.parseInt(br.readLine());
            int resultOf1_2=0;
            int resultOf1_3=0;
            int resultOf2_3=0;
            int resultOf1_2_3=0;
            int answer =1 ;
            if(n>=2){
                resultOf1_2 = n/2;
            }
            if(n>=3){
                resultOf1_3 = n/3;
            }
            if(n>=5){
                resultOf2_3 = case2_3(n);
            }
            if(n>=6){
                for(int i=1 ; n-i>=5;i++){
                    int result = case2_3(n-i);
                    resultOf1_2_3 += result;
                }
            }
            answer = answer + resultOf1_2 + resultOf1_3 + resultOf2_3 + resultOf1_2_3;
            System.out.println(answer);
        }


    }
    private static int case2_3(int n){
        if(n==5||n==7||n==9) return 1;
        int resultOf2_3 = 0;
        if(n%2 ==0){
            if (n%6==0){
                resultOf2_3 = n/6 -1;
            }else{
                resultOf2_3 += n/6;
            }
        } else if (n%2==1) {
            if ((n-3)%6==0){
                resultOf2_3 = (n-3)/6;
            }else{
                resultOf2_3 += (n-3)/6+1;
            }
        }
        return resultOf2_3;
    }




}

