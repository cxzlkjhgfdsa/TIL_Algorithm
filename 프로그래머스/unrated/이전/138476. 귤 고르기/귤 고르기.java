import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        int[] tanger = new int[10000001];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0; i<tangerine.length; i++){
            tanger[tangerine[i]]++;
        }
        
        for(int i=0; i<10000001; i++){
            if(tanger[i]>0){
                pq.add(tanger[i]);
            }
        }
        
        int cnt = 0;
        while(k>0){
            Integer i = pq.poll();
            k -= i;
            cnt++;
        }
        
        answer = cnt;
        return answer;
    }
}
