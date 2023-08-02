import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int n : scoville){
            pq.add(n);
        }
        while(true){
            if(pq.peek() >= K){
                break;
            }
            if(pq.size() <= 1){
                answer = -1;
                break;
            }
            answer++;
            int a = pq.poll();
            int b = pq.poll();
            
            int n = a + (b*2);
            pq.add(n);
        }
        return answer;
    }
}