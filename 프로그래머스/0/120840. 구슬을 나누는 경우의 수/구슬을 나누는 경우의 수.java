class Solution {
    public int solution(int balls, int share) {
        int answer = 0;
        
        int[][] comb = new int[31][31];
        
        for(int i = 0; i < 31; i++){
            comb[i][0] = 1;
        }
        
        for(int i = 1; i < 31; i++){
            for(int j = 1; j < 31; j++){
                comb[i][j] = comb[i-1][j] + comb[i-1][j-1];
            }            
        }
        
        answer = comb[balls][share];
        
        return answer;
    }
}