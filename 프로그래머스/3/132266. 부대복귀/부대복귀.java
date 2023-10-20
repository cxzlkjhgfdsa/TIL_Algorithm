import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        
        
        ArrayList<Integer>[] map = new ArrayList[n+1];
        for(int i = 1; i <= n; i++){
            map[i] = new ArrayList<>();
        }
        
        for(int [] arr : roads){
            map[arr[0]].add(arr[1]);
            map[arr[1]].add(arr[0]);
        }
        
        
        int[] D = new int[n+1];
        Arrays.fill(D, 100000);
        D[destination] = 0;
        
        
        Queue<Integer> que = new ArrayDeque<>();
        boolean[] visited = new boolean[n+1];
        que.add(destination);
        visited[destination] = true;
        
        while(!que.isEmpty()){
            
            int p = que.poll();
            visited[p] = true;
            
            for(int next : map[p]){
                
                if(D[next] > D[p] + 1){
                    D[next] = D[p] + 1;
                    que.add(next);
                }
            }
            
        }
        
        for(int i = 0; i < sources.length; i++){
            answer[i] = D[sources[i]];
            
            if(answer[i] == 100000)
                answer[i] = -1;
        }
        
        
        
        return answer;
    }
}