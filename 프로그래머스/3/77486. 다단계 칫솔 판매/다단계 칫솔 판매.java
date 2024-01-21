class Solution {
    
    static int[] result;
    static String[] member;
    static int memberN;
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer;
        memberN =enroll.length;
        result = new int[memberN];
        member = enroll;
        
        int[] parents = new int[memberN];
        
        for(int i=0;i<memberN;i++){
            if(referral[i].equals("-")){
                parents[i]= -1;
                continue;
            }
            int index = findIndexByName(referral[i]);
            parents[i]= index;
        }
        
        for(int i=0;i<seller.length;i++){
            int index = findIndexByName(seller[i]);
            int totalMoney = 100 * amount[i];
            calculate(parents,index,totalMoney);
        }
        
        
        
        answer = result;
        return answer;
    }
    
    static void calculate(int[] parents,int index,int money){
        int parentsMoney = money/10;
        int myMoney = money - parentsMoney;

        result[index] += myMoney;
        if(parents[index]==-1) return;
        calculate(parents,parents[index],parentsMoney);
    }
    
    static int findIndexByName(String name){
        int i=0;
        for(;i<memberN;i++){
            if(member[i].equals(name)) break;
        }
        return i;
    }
}