import java.util.*;

class Solution {
    public int[] solution(int[][] score) {
        int[] answer = new int[score.length];
        
        int[] sum = new int[score.length];
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < score.length; i++){
            sum[i] = score[i][0] + score[i][1];
        }
        
        Arrays.sort(sum);
        
        int idx = 1;
        
        for(int i= sum.length-1; i >= 0; i--){
            if(map.get(sum[i]) == null)
                map.put(sum[i], idx);
            idx++;
        
        }
        
        for(int i = 0; i < answer.length; i++){
            answer[i] = map.get(score[i][0]+score[i][1]);
        }
        
        
        
        return answer;
    }
}