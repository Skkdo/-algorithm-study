class Solution {
    public String solution(String s) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        int num = 0;
        int sign = 1;
        boolean exist = false;
        
        for(int i = 0; i <= s.length(); i++) {
            if(i < s.length() && s.charAt(i) == '-'){
                sign = -1;
            }else if(i < s.length() && Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
                exist = true;
            }else {
                if(exist) {
                    int token = num * sign;
                    max = Math.max(max, token);
                    min = Math.min(min, token);
                }
                num = 0;
                sign = 1;
                exist = false;
            }
        }
        
        return min + " " + max;  
    }
}