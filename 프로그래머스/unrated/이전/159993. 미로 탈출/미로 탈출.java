import java.util.*;

class Solution {
    
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    
    public int solution(String[] maps) {
        int answer = -1;
        int col = maps.length;
        int row = maps[0].length();
        String[][]graph = new String[col][];
        pos start = null;
        pos end = null;
        
        for(int i=0; i<col; i++){
            graph[i] = maps[i].split("");
            for(int j=0; j<row; j++){
                if(graph[i][j].equals("S")){
                    start = new pos(i, j, 0, false);
                }else if(graph[i][j].equals("E")){
                    end = new pos(i, j, 0, false);
                }
            }
        }
        
        boolean[][][] visited = new boolean[col][row][2];
        Queue<pos> que = new ArrayDeque<>();
        que.add(start);
        visited[start.x][start.y][0] = true;
        
        while(!que.isEmpty()){
            pos p = que.poll();
            //System.out.println(p.x + " " + p.y + " "+p.key);
            
            if(p.x==end.x && p.y==end.y && p.key){
                answer = p.count;
            }
            
            for(int i=0; i<4; i++){
                
                int cx = p.x + dx[i];
                int cy = p.y + dy[i];
                
                if(cx<0 || cy<0 || cx >=col || cy>=row || graph[cx][cy].equals("X")){
                    continue;
                }
                
                if(p.key && visited[cx][cy][1]){
                    continue;
                }
                if(!p.key && visited[cx][cy][0]){
                    continue;
                }
                
                if(graph[cx][cy].equals("L")){
                    que.add(new pos(cx, cy, p.count+1, true));
                }else{
                    que.add(new pos(cx, cy, p.count+1, p.key));
                }
                
                if(p.key){
                    visited[cx][cy][1] = true;
                }else{
                    visited[cx][cy][0] = true;
                }               
                
                
            }    
            
        }       
               
        
        return answer;
    }
}

class pos{
    int x, y, count;
    boolean key;
    
    public pos(int x, int y, int count, boolean key){
        this.x = x;
        this.y = y;
        this.count = count;
        this.key = key;
    }   
    
}

