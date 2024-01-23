import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int[] index = new int[board[0].length];
        
        int[][] map = new int[board[0].length][board.length];
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==0) continue;
                map[j][index[j]++] = board[i][j];
            }
        }
        index = new int[board[0].length];
        
        Stack stack = new Stack<>();
        
        for(int i=0;i<moves.length;i++){
        
            int get = map[moves[i]-1][index[moves[i]-1]++];
            if(index[moves[i]-1]>=board.length) index[moves[i]-1]--;
            
            if(get == 0){continue;}
            
            if(stack.size()==0){
                stack.push(get);
                continue;
            }
            
            if((int)stack.peek()==get) {
                stack.pop();
                answer += 2;
                continue;
            }
            stack.push(get);
            
        }
        
        return answer;
    }
}