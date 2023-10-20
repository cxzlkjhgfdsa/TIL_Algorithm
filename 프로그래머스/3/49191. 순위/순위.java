class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        
        boolean[][] win = new boolean[n+1][n+1];
        boolean[][] lose = new boolean[n+1][n+1];
        
        for(int [] game : results){
            
            win[game[0]][game[1]] = true;
            lose[game[1]][game[0]] = true;
        }
        
        
        for(int i = 1; i<= n; i++){
            for(int x = 1;  x<= n; x++){
                for(int y = 1; y <= n; y++){
                    if(win[x][i] && win[i][y])
                        win[x][y] = true;
                    
                    if(lose[x][i] && lose[i][y])
                        lose[x][y] = true;
                }
            }
        }
        
        
        for(int i = 1; i <= n; i++){
            int cnt = 0;
            
            for(int j = 1; j <= n; j++){
                if(win[i][j] || lose[i][j])
                    cnt++;
            }
            
            if(cnt == n-1)
                answer++;
        }
        
        
       
        
        return answer;
    }
}
