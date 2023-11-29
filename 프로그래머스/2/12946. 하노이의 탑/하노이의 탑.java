class Solution {
    static int index = 0;
    static int[][] answer;
    
    public int[][] solution(int n) {
        int size =0;
        for(int i=0;i<n;i++){
            size = size *2 +1;
        }
        answer = new int[size][2];
        hanoi(n,1,2,3);
        
        
        return answer;
    }
    public static void hanoi(int n,int start,int tmp, int end){
        if(n==1){
            answer[index][0] = start;
            answer[index++][1] = end;
        }else{
            hanoi(n-1,start,end,tmp);
            answer[index][0] = start;
            answer[index++][1] = end;
            hanoi(n-1,tmp,start,end);
        }
        
        
    }
}