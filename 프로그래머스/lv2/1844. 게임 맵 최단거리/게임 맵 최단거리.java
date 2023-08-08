import java.util.*;

class Solution {   
    public int solution(int[][] maps) {
        
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        
        int n = maps.length;
        int m = maps[0].length;
        boolean[][] visited = new boolean[n][m];
        int answer = -1;
        
        Queue<Pos> pq = new ArrayDeque<>();
        pq.add(new Pos(0, 0, 1));
        visited[0][0] = true;
        
        while(!pq.isEmpty()){
            Pos p = pq.poll();

            if(p.x == n-1 && p.y == m-1){
                answer = p.dis;
                break;
            }
            
            for(int i=0; i<4; i++){
                int cx = p.x + dx[i];
                int cy = p.y + dy[i];
            
                if(cx < 0 || cx >= n || cy < 0 || cy >= m || visited[cx][cy] || maps[cx][cy] == 0)
                    continue;
                visited[cx][cy] = true;
                pq.add(new Pos(cx, cy, p.dis+1));
            }            
        }
        return answer;
    }
}

class Pos{
    int x, y, dis;
    
    public Pos(int x, int y, int dis){
        this.x = x;
        this.y = y;
        this.dis = dis;
    }
}