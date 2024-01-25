import java.util.*;
class Solution {
    
    static HashSet<Integer> set;
    static int[] user_key;
    
    public int solution(String[] user_id, String[] banned_id) {
        int answer = 1;
        
        boolean[] used = new boolean[user_id.length];
        int[][] ban_case = new int[banned_id.length][];
        
        
        user_key = new int[user_id.length];
        int value =1;
        for(int i=0;i<user_key.length;i++){
            user_key[i] = value;
            value *= 10;
        }
        
        set = new HashSet<Integer>();
        makeArray(user_id,banned_id,ban_case);
        initArray(user_id,banned_id,ban_case);
        DFS(ban_case,used,0,0);
        
        answer = set.size(); 
       
        return answer;
    }
    
    public static void DFS(int[][] ban_case,boolean[] used,int depth, int result){
        if(depth==ban_case.length){
            set.add((Integer) result);
            return;
        }
        for(int i=0;i<ban_case[depth].length;i++){
            int index = ban_case[depth][i];
            if(used[index]) continue;
            used[index]=true;
            result += user_key[index];
            DFS(ban_case,used,depth+1,result);
            used[index]=false;
            result -= user_key[index];
        }
        
        
    }
    
    
        
    public static boolean check(String user, String ban){
        if(user.length()!=ban.length()) return false;
        
        for(int i=0;i<ban.length();i++){
            if(ban.charAt(i)=='*') continue;
            if(ban.charAt(i)!=user.charAt(i)) return false;
        }
        
        return true;
    }
    
    public static void makeArray (String[] user_id, String[] banned_id,int[][] ban_case){
        for(int i=0;i<ban_case.length;i++){
            int num=0;
            for(int j=0;j<user_id.length;j++){
                if(check(user_id[j],banned_id[i])){
                    num++;
                }
            }
            ban_case[i] = new int[num];
        }        
    }
    
    public static void initArray (String[] user_id, String[] banned_id,int[][] ban_case){
        for(int i=0;i<ban_case.length;i++){
            int num=0;
            for(int j=0;j<user_id.length;j++){
                if(check(user_id[j],banned_id[i])){
                    ban_case[i][num] = j;
                        num++;
                }
            }
            
        }        
    }
    
}