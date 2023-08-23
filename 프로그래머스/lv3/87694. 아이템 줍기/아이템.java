import java.util.*;

class Solution {
    int answer = 0;
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        boolean[][] visited = new boolean[101][101];
        int[][] map = new int[101][101];
        
        for(int [] rect : rectangle){
            int lx = rect[0]*2;  //좌측하단 x
            int ly = rect[1]*2;  //좌측하단 y
            int rx = rect[2]*2;  //우측상단 x
            int ry = rect[3]*2;  //우측상단 y
            
            for(int i=lx; i<=rx; i++){  //테두리 2로 채움 ( 윗변, 아랫변 ) 만약 0 이 아니라면 ( 1 = 어떤 사각형의 내부 , 2 테두리 ) 고로 패스
                if(map[i][ly] == 0)
                    map[i][ly] = 2;
                if(map[i][ry] == 0)
                    map[i][ry] = 2;
            }
            
            for(int i=ly; i<=ry; i++){  // 좌변, 우변 테두리 2로 채움
                if(map[lx][i] == 0)
                    map[lx][i] = 2;
                if(map[rx][i] == 0)
                    map[rx][i] = 2;
                
            }
            
            for(int i=lx+1; i<rx; i++){  //내부 1로 채움
                for(int j=ly+1; j<ry; j++){
                    map[i][j] = 1;
                }
            }
        }
        
        // for(int i=0; i<22; i++){
        //     for(int j=0; j<22; j++){
        //         System.out.print(map[i][j]);
        //     }
        //     System.out.println();
        // }
        
        Queue<Point> que = new ArrayDeque<>();
        que.add(new Point(characterX*2, characterY*2, 0));
        visited[characterX*2][characterY*2] = true;
        
        while(!que.isEmpty()){
            Point p = que.poll();
            
            if(p.x == itemX*2 && p.y == itemY*2){
                answer = p.cnt;
                break;
            }
            
            for(int i=0; i<4; i++){
                int cx = p.x + dx[i];
                int cy = p.y + dy[i];
                
                if(cx < 0 || cx > 100 || cy < 0 || cy > 100)
                    continue;
                if(visited[cx][cy] || map[cx][cy] != 2)
                    continue;
                visited[cx][cy] = true;
                que.add(new Point(cx, cy, p.cnt+1));
            }
        }
        

        return answer/2;
    }
}

class Point{
    int x, y, cnt;
    public Point(int x, int y, int cnt){
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}
