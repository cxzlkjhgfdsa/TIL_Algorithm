import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        int size = computers.length;
        int row = computers[0].length;
        boolean[] visited = new boolean[size];
        Queue<Integer> que = new ArrayDeque<>();
        for(int i=0; i<size; i++){
            if(visited[i]){
                continue;
            }
            
            answer++;
            
            que.add(i);
            visited[i] = true;
            while(!que.isEmpty()){
                int current = que.poll();
                
                for(int cur=0; cur<row; cur++){
                    if(visited[cur] || computers[current][cur] == 0){
                        continue;
                    }
                    
                    que.add(cur);
                    visited[cur] = true;
                }                    
                
            }
            
            
            
        }
        
        
        return answer;
    }
}