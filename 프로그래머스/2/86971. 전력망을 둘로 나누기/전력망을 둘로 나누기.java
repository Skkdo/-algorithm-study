import java.util.*;

class Solution {
    static boolean[] check;
    
    public int solution(int n, int[][] wires) {
        int answer = 0;
        int min = n;
        ArrayList<Integer>[] arr = new ArrayList[n+1];
        
        for(int i=0;i<n+1;i++){
            arr[i] = new ArrayList<Integer>();
        }
        
        for(int i=0;i<n-1;i++){
            arr[wires[i][0]].add(wires[i][1]);
            arr[wires[i][1]].add(wires[i][0]);
        }
        
        for(int i=0;i<n-1;i++){
            int temp=0;
            check = new boolean[n+1];
            check[wires[i][1]] = true;
            check[wires[i][0]] = true;
            temp = DFS(arr,wires[i][0],0);
            temp = Math.abs(n-temp-temp);
            if(min>temp){
                min = temp;
            }
        }
        
        return min;
    }
    public static int DFS(ArrayList<Integer>[] arr,int index,int count){
        count++;
        for(int i=0;i<arr[index].size();i++){
            if(check[arr[index].get(i)]){
                continue;
            }
            check[arr[index].get(i)] =true;
            count = DFS(arr,arr[index].get(i),count);
        }
        return count;
    }
    
    
    
}