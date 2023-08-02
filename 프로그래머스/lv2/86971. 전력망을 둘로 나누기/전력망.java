import java.util.*;

class Solution {
    ArrayList<Integer>[] map;    
    int cnt;
    
    public int solution(int n, int[][] wires) {
        init(n, wires);
        int answer = 101;
        for(int i=0; i<n-1; i++){
            int a = wires[i][0];
            int b = wires[i][1];
            
            map[a].add(b);
            map[b].add(a);
        }
        
        for(int i=0; i<n-1; i++){
            int a = wires[i][0];
            int b = wires[i][1];
            
            int v1 = cut(a, b);
            int v2 = cut(b, a);
            
            int abs = Math.abs(v1-v2);
            answer = Math.min(abs, answer);
        }
        
        return answer;
    }
    
    public int cut(int start, int cuting){
        boolean[] visited = new boolean[cnt+1];
        visited[cuting] = true;
        visited[start] = true;
        
        Queue<Integer> que = new ArrayDeque<>();
        que.add(start);
        int cnt = 0;
        while(!que.isEmpty()){
            int p = que.poll();
            cnt++;
            for(int next : map[p]){
                if(visited[next]){
                    continue;
                }
                visited[next] = true; 
                que.add(next);
                
            }            
        }
        
        return cnt;
        
    }
    
    public void init(int n, int[][] wires){
        map = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            map[i] = new ArrayList<>();
        }
        cnt = n;
    }
}