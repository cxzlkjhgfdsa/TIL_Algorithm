class Solution {
    public int solution(int[][] board) {
        int[] dx = {-1, -1, -1 , 0, 1, 1, 1, 0};
        int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};
        
        int answer = 0;
        
        boolean[][] safe= new boolean[board.length][board.length];
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                
                if(board[i][j] == 1){
                    safe[i][j] = true;
                    for(int k = 0; k < 8; k++){
                        int cx = i + dx[k];
                        int cy = j + dy[k];
                        
                        if(cx < 0 || cy < 0 || cx >= board.length || cy >= board.length)
                            continue;
                        safe[cx][cy]= true;
                    }
                }
                
            }
        }
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                if(!safe[i][j])
                    answer++;
            }
        }
        
        return answer;
    }
}