class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = health;
        int finish = attacks[attacks.length-1][0] ;
        int index=0;
        int heal = bandage[1];
        int duration = bandage[0];
        int bonusHeal = bandage[2];
        int combo = 0;
        
        for(int i=0;i<=finish;i++){
            if(answer>health){
                answer = health;
            }
            if(answer <= 0){
                answer =-1;
                break;
            }
            combo++;
            
            if(attacks[index][0]==i){
                answer -= attacks[index][1];
                index++;
                combo = 0;
                continue;
            }
            if(combo==duration){
                answer += bonusHeal;
                combo = 0;
            }
            answer += heal;
        }
        if(answer>health){
                answer = health;
            }
        if(answer <= 0){
                answer =-1;
            }
        
        return answer;
    }
}