class Solution {
    public int solution(int[][] triangle) {
        int height = triangle.length;
        
        for(int i=1;i<height;i++){
            plus(triangle[i-1],triangle[i]);
        }
        
        return findMax(triangle[height-1]);
    }
    
    private static void plus(int[] top, int[] bottom){
        int top_first = top[0];
        int top_last = top[top.length-1];
        bottom[0] += top_first;
        bottom[bottom.length-1] += top_last;
        
        for(int i=1;i<bottom.length-1;i++){
             int bigger = (top[i-1] > top[i])? top[i-1] : top[i];
             bottom[i] += bigger;
        }
    }
    
    private static int findMax(int[] array){
        int max = array[0];
        for(int i =1;i<array.length;i++){
            max = (max > array[i])? max : array[i];
        }
        return max;
    }
}