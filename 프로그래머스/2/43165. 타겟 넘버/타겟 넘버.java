class Solution {
    static int num;
    public int solution(int[] numbers, int target) {
        int answer = 0;
        int[][] map = new int[numbers.length][2];
        for(int i=0;i<numbers.length;i++){
            map[i][0] = numbers[i];
            map[i][1] = numbers[i]*-1;
        }
        num =0;
        DFS(0,target,0,map);
        answer = num;
        return answer;
    }
    public static void DFS(int index , int target, int tmp ,int[][] map){
        if(index == map.length){
            if(tmp == target) num++;
            return;
        }
        for(int i=0;i<map[index].length;i++){
            tmp += map[index][i];
            DFS(index+1,target,tmp,map);
            tmp -= map[index][i];
        }
        
    }
}