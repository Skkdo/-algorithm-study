class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        
        for(int i=1;i<=Math.sqrt(yellow);i++){
            if(yellow%i!=0) continue;
            int yellowX = i;
            int yellowY = yellow/i;
            
            int temp = (yellowX+2)*2+yellowY*2;
            if(temp==brown){
                int x = yellowX+2;
                int y = yellowY+2;
                answer[0] = Math.max(x,y);
                answer[1] = Math.min(x,y);
            }
            
        }
            
        return answer;
    }
}