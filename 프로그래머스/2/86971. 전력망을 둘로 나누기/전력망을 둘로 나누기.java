import java.util.*;

class Solution {
    
    public class Group {
        boolean[] check;
        int count;
        
        public Group(int size) {
            this.check = new boolean[size + 1];
            this.count = 0;
        }
        
        public void add(int n) {
            this.check[n] = true;
            this.count++;
        }
        
        public boolean grouping(int[] wires) {
            int wire1 = wires[0];
            int wire2 = wires[1];
            
            if(check[wire1] || check[wire2]) {
                this.check[wire1] = true;
                this.check[wire2] = true;
                this.count++;
                return true;
            }
            return false;
        }
    }
    
    public int solution(int n, int[][] wires) {
            int min = Integer.MAX_VALUE;
        
            for(int cut = 0; cut < wires.length; cut++) {
                Group g1 = new Group(n);
                Group g2 = new Group(n);
                g1.add(wires[cut][0]);
                g2.add(wires[cut][1]);
            
                Queue<int[]> q = new LinkedList<>();
            
                for(int i = 0; i < wires.length; i++) {
                    if(i == cut) continue;
                
                    if(g1.grouping(wires[i])) continue;
                    if(g2.grouping(wires[i])) continue;
                    q.add(wires[i]);
                }
            
                while(!q.isEmpty()) {
                    int[] wire = q.poll();
                    if(g1.grouping(wire)) continue;
                    if(g2.grouping(wire)) continue;
                    q.add(wire);
                }
                min = Math.min(Math.abs(g1.count - g2.count), min);
            }
        return min;
    } 
}