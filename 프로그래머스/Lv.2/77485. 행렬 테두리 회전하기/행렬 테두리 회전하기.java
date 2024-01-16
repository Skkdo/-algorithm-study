import java.util.*;

class Solution {
    static int[][] map;
    
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        
        map = new int[rows][columns];
        int value =1;
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                map[i][j] =value++;
            }
        }
        for(int i=0;i<queries.length;i++){
            int min=test(queries[i][0],queries[i][1],queries[i][2],queries[i][3]);
            answer[i] =min;
        }
        
        return answer;
    }
    static int test(int y1,int x1,int y2, int x2){
       int sizeX = x2-x1+1;
        int sizeY = y2-y1+1;
        int valuesSize = 2*sizeX+2*sizeY-4;
        int[] values= new int[valuesSize];

        int index =0;
        for(int a=x1-1;a<x2;a++){
            values[index++]= map[y1-1][a];
        }
        for(int b=y1;b<y2;b++){
            values[index++]= map[b][x2-1];
        }
        for(int c=x2-2;c>=x1-1;c--){
            values[index++]= map[y2-1][c];
        }
        for(int d=y2-2;d>=y1;d--){
            values[index++]= map[d][x1-1];
        }

        index =0;
        map[y1-1][x1-1] = values[valuesSize-1];
        for(int a=x1;a<x2;a++){
            map[y1-1][a] = values[index++];
        }
        for(int b=y1;b<y2;b++){
            map[b][x2-1] = values[index++];
        }
        for(int c=x2-2;c>=x1-1;c--){
            map[y2-1][c] = values[index++];
        }
        for(int d=y2-2;d>=y1;d--){
            map[d][x1-1] = values[index++];
        }
        Arrays.sort(values);
        return values[0];
        
    }
}