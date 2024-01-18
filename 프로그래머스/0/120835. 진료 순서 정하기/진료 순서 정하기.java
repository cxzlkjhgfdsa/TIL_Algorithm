import java.util.*;

class Solution {
    public int[] solution(int[] emergency) {
        int size = emergency.length;
        
        int[] answer = new int[size];
        int[] sorted = new int[size];
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < size; i++){
            sorted[i] = emergency[i];
        }
        
        Arrays.sort(sorted);
        int idx = 1;
        
        for(int i = size - 1; i>=0; i--){
            map.put(sorted[i], idx);
            idx++;
        }
        
        for(int i = 0; i < size; i++){
            answer[i] = map.get(emergency[i]);
        }
        
        return answer;
    }
}