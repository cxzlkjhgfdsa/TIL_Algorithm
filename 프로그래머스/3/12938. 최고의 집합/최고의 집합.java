import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        int[] answer;
        
        if(n > s){
            answer = new int[1];
            answer[0] = -1;
        }else{
            int k = s / n;
            int u = s % n;
            
            answer = new int[n];
            
            for(int i = n-1; i >= 0; i--){
                if(u > 0){
                    answer[i] = k + 1;
                    u--;
                }else{
                    answer[i] = k;
                }
            }
            
        }
        
        return answer;
    }
}