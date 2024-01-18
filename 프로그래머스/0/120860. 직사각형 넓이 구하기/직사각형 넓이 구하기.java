class Solution {
    public int solution(int[][] dots) {
        int answer = 0;
        
        int maxCol = -256;
        int minCol = 256;
        int maxRow = -256;
        int minRow = 256;
        
        for(int [] dot : dots){
            maxCol = Math.max(maxCol, dot[0]);
            minCol = Math.min(minCol, dot[0]);
            maxRow = Math.max(maxRow, dot[1]);
            minRow = Math.min(minRow, dot[1]);
            
        }
        
        answer = (maxCol-minCol)*(maxRow-minRow);
        
        return answer;
    }
}