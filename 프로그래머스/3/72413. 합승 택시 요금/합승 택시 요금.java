import java.util.*;

class Solution {
    static int min;
    static int S;
    static int A;
    static int B;
   
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;
        
        S=s;
        A=a;
        B=b;
        
        int max =0;
        int[][] map = new int[n+1][n+1];
        for(int i=0;i<fares.length;i++){
            map[fares[i][0]][fares[i][1]]=fares[i][2];
            map[fares[i][1]][fares[i][0]]=fares[i][2];
            max += fares[i][2];
        }
        min =max;
        
        int[] minArray = new int[n+1];  
        boolean[] check;
        
        
        
        
        for(int i=1;i<n+1;i++){
            Arrays.fill(minArray,max);
            check = new boolean[n+1];
            check[0] =true;
            
            D(i,map,check,minArray);
        }
             
        answer = min;
        return answer;
    }
    
    public static void D(int n,int[][] map,boolean[] check,int[] minArray){
       
       int minIndex = n; 
       minArray[n]=0;
       boolean stop = true; 
        
       while(stop){
       int minNode =minArray[0];    
       
           
       //최소 배열 다 돌았는지 확인
      for(boolean b : check){
           if(!b) {stop = true; break;}
            stop = false;
       }
           
       // 최소배열에서 제일 작은 값 찾기 
       for(int i=1;i<minArray.length;i++){
           if(check[i]) continue;
           if(minNode>=minArray[i]) {minNode = minArray[i]; minIndex = i;}
       }
       check[minIndex] = true; 
           
       // 연결된 노드 가중치 비교해서 작은 값 대입     
       for(int i=1;i<map.length;i++){
           if(map[minIndex][i]==0) continue;
           if(check[i]) continue;
           if(minArray[i]>minArray[minIndex]+map[minIndex][i]){ 
               minArray[i] = minArray[minIndex]+map[minIndex][i];
           }    
       } 
       }
        
        if(min>minArray[A]+minArray[B]+minArray[S]){
        min = minArray[A]+minArray[B]+minArray[S];
        }
        
        
    }
    
 
    
}