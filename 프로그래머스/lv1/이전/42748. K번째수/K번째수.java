import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        
        int[] answer = new int[commands.length];
        for(int tc=0; tc<commands.length; tc++){
            
            int i = commands[tc][0];
            int j = commands[tc][1];
            int k = commands[tc][2];
            
            int[] ans = new int[j-i+1];
            int idx = 0;
            for(int a = i-1; a<j; a++){
                ans[idx] = array[a];
                idx++;
            }
            
            Arrays.sort(ans);
            answer[tc] = ans[k-1];
            
        }
        
        return answer;
    }
}