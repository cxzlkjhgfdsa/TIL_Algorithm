import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i : works){
            pq.add(i);
        }
        
        for(int i = 0; i < n; i++){
            if(pq.size() == 0)
                break;
            int k = pq.poll();
            if( k > 0){
                pq.add(k -1);
            }
        }
        
        while(!pq.isEmpty()){
            int k  = pq.poll();
            answer += k * k;
        }
        
        return answer;
    }
}

