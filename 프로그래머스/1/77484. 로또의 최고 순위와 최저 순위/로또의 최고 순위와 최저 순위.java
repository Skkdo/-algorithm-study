class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int zero =0;
        int match=0;
        for(int i=0;i<lottos.length;i++){
            int temp = lottos[i];
             if(temp==0) {
                zero++;
                continue;
                }
            for(int j=0;j<win_nums.length;j++){
                if(temp==win_nums[j]) match++;
            }
        }
        int low = 7-match;
        if(low == 7) low = 6;
        int high = 7-match-zero;
        if(high < 1) high = 1;
        if(high == 7) high = 6;
        
        answer[0] = high;
        answer[1] = low;
        
        return answer;
    }
}