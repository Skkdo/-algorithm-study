import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        int stack[] = new int[id_list.length];
        ArrayList<Integer>[] list = new ArrayList[id_list.length];
        for(int i=0;i<id_list.length;i++){
            list[i] = new ArrayList<>();
        }
        StringTokenizer st;
        for(int i=0;i<report.length;i++){
            st = new StringTokenizer(report[i]);
            int user1_index = search(id_list,st.nextToken()); 
            int user2_index = search(id_list,st.nextToken()); 
            if(list[user2_index].contains(user1_index)) continue;
            stack[user2_index]++;
            list[user2_index].add(user1_index);  
        }
        for(int i=0;i<stack.length;i++){
            if(stack[i]>=k){
                for(int j=0;j<list[i].size();j++){
                    answer[list[i].get(j)]++;
                }
            }
        }
        
        
        
        
        return answer;
    }
    
    public static int search (String[] id_list, String name){
        for(int i=0;i<id_list.length;i++){
            if(id_list[i].equals(name)) return i;
        }
        return 0;
    }
}