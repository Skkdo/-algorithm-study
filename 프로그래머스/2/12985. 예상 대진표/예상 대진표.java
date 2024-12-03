class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;
        int back = a>b?a:b;
        int front = a<b?a:b;
        int totalRound = totalRound(n,0);
        int minusRound = logic(n/2,front,back,0);
        answer = totalRound-minusRound;
        
        return answer;
    }
    static int totalRound(int n,int round){
        if(n==1) return round;
        return totalRound(n/2,round+1);
    }
    
    static int logic(int mid,int front,int back,int depth){
        if(front<=mid&&back>mid) return depth;
        
        if(mid <front){
            front -= mid;
            back -= mid;
        }
 
        return logic(mid/2,front,back,depth+1);
    }
}