import java.util.*;

class Solution {
    
    public int solution(int n, int[][] edge) {
        
        int answer = 0;
        
        ArrayList<Integer>[] list = new ArrayList[n+1];
        
        for(int i = 1; i <= n; i++){
            list[i] = new ArrayList<>();
        }
        boolean[] visited = new boolean[n+1];
        
        for(int[] arr : edge){
            list[arr[0]].add(arr[1]);
            list[arr[1]].add(arr[0]);
        }
        
        ArrayList<Integer> count = new ArrayList<>();
        
        Queue<Pos> que = new ArrayDeque<>();
        visited[1] = true;
        que.add(new Pos(1, 0));
        
        while(!que.isEmpty()){
            
            Pos p = que.poll();
            count.add(p.cnt);
            
            for(int next : list[p.cur]){
                if(visited[next])
                    continue;
                visited[next] = true;
                que.add(new Pos(next, p.cnt+1));
            }
        }
        
        Collections.sort(count, Collections.reverseOrder());
        
        int max = count.get(0);
        
        
        for(int k : count){
            if(max == k)
                answer++;
            else
                break;
        }
        
        
        return answer;
    }
}

class Pos{
    int cur, cnt;
    public Pos(int cur, int cnt){
        this.cur = cur;
        this.cnt = cnt;
    }
}

