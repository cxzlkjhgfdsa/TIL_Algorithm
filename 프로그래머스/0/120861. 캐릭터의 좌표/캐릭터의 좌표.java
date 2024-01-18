class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int[] answer = new int[2];
        
        int x = 0;
        int y = 0;
        
        int maxUp = board[1]/2;
        int maxDown = board[1]/2*-1;
        int maxLeft = board[0]/2*-1;
        int maxRight = board[0]/2;
        
        for(String next : keyinput){
            switch(next){
                case "up":
                    if(y+1 <= maxUp)
                        y++;
                    break;
                case "down":
                    if(y-1 >= maxDown)
                        y--;
                    break;
                case "left":
                    if(x-1 >= maxLeft)
                        x--;
                    break;
                case "right":
                    if(x+1 <= maxRight)
                        x++;
                    break;
            }
        }
        
        answer[0] = x;
        answer[1] = y;
        
        return answer;
    }
}