
import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
        for(int j =1;j<=10;j++){
             int sum =0;
             int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] building = new int[n];
            for(int i=0;i<n;i++){
                building[i]=Integer.parseInt(st.nextToken());
            }
            int bigLeft =0;
            int bigRight =0;
            int nextIndex =0;
            for(int i=2;i<n-2;){
            	int now = building[i];
                if(building[i-1]>=building[i-2]){
                	bigLeft = building[i-1];
                }else{
                	bigLeft = building[i-2];
                }
                if(building[i+2]>=building[i+1]){
                	bigRight = building[i+2];
                    nextIndex = i+2;
                }else{
                	bigRight = building[i+1];
                    nextIndex = i+1;
                }
                if(now>bigLeft&&now>bigRight){
                	int bigger = (bigLeft>bigRight)?bigLeft:bigRight;
                    sum += now-bigger;
                    nextIndex = i+3;
                }
                  i = nextIndex;
            }
            
            
            System.out.println("#"+j+" "+sum);
        }
	
		

		
	}
}