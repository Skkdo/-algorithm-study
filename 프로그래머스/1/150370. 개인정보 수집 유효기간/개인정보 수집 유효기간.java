import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> answer = new ArrayList();
        StringTokenizer st;
        int[] Today = toInt(today);
        String[] termsInfo = new String[terms.length*2];
        
        for(int i=0;i<termsInfo.length;i+=2){
            st = new StringTokenizer(terms[i/2]);
            termsInfo[i] = st.nextToken();
            termsInfo[i+1] = st.nextToken();
        }
        
        for(int i=0;i<privacies.length;i++){
            st = new StringTokenizer(privacies[i]);
            int[] temp = toInt(st.nextToken());
            String key = st.nextToken();
            int year = (Today[0] - temp[0])*12*28;
            int month = (Today[1] - temp[1])*28;
            int day = (Today[2] - temp[2]);
            int result = year+month+day;
            if(result>=find(termsInfo,key)){
                answer.add(i+1);
            }
        }
        int[] arr = new int[answer.size()];
        for(int i=0;i<answer.size();i++){
            arr[i]=answer.get(i).intValue();
        }
        
        return arr;
    }
    
    public static int[] toInt(String string){
        int[] result = new int[3];
        StringTokenizer st = new StringTokenizer(string,".");
        
        int year = Integer.parseInt(st.nextToken());
        int month = Integer.parseInt(st.nextToken());
        int day = Integer.parseInt(st.nextToken());
        result[0]=year;
        result[1]=month;
        result[2]=day;
        return result;
    }
    
    public static int find(String[] string, String key){
        int result=0;
        for(int i=0;i<string.length;i+=2){
            if(string[i].equals(key)){
                result = Integer.parseInt(string[i+1]);
            }
        }
        return result*28;
    }
}