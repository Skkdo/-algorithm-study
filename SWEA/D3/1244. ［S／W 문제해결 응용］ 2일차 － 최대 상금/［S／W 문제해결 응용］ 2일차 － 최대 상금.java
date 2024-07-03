
import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int j=1;j<=t;j++){
        	StringTokenizer st = new StringTokenizer(br.readLine());
            String num = st.nextToken();
            int change = Integer.parseInt(st.nextToken());
            Integer[] numArray = toArray(num);
            Integer[] best = numArray.clone();
            Arrays.sort(best,Collections.reverseOrder());
            
            
            for(int i=0;i<numArray.length;i++){
                if(change == 0 ) break;
            	if(numArray[i]!=best[i]){
                	for(int k=i+1;k<numArray.length;k++){
                    	if(numArray[k]==best[i]){
                            if(numArray[k]==best[k]) continue;
                        	int tmp = numArray[i];
                        	numArray[i] = numArray[k];
                            numArray[k] = tmp;
                            change --;
                            break;
                        }
                    }
                }
            }
            if(change %2 ==1&& !sameNumberCheck(numArray)){
            	int tmp = numArray[numArray.length-1];
                numArray[numArray.length-1] = numArray[numArray.length-2];
                numArray[numArray.length-2]=tmp;
            }
            String answer = Arrays.toString(numArray).replaceAll("[^0-9]","");
            System.out.println("#"+j+" "+answer);
            
        }
	}
    public static Integer[] toArray(String num){
        Integer[] answer = new Integer[num.length()];
    	for(int i=0;i<num.length();i++){
        	answer[i]=num.charAt(i)-'0';
        }
    	return answer;
    }
    public static boolean sameNumberCheck(Integer[] numArray){
    	int[] check = new int[10];
        for(int i=0;i<numArray.length;i++){
        	check[numArray[i]]++;
        }
        for(int i=0;i<10;i++){
        	if(check[i]>=2) return true;
        }
        return false;
    }
}