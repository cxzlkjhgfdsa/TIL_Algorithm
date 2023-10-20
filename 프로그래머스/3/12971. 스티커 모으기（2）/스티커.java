class Solution {
    public int solution(int sticker[]) {
        int answer = 0;
        
        int len = sticker.length - 1;
        
        if(len == 0){
            return sticker[0];
        }
        
        if(len == 1){
            return Math.max(sticker[0], sticker[1]);
        }
        
        int[] temp_stk = new int[len];
        int[] temp_stk2 = new int[len];
        
        for(int i = 0; i <len; i++){
            temp_stk[i] = sticker[i];
            temp_stk2[i] = sticker[i+1];
            
        }
        
        int[] dp1 = new int[len];
        int[] dp2 = new int[len];
        
        dp1[0] = temp_stk[0];
        dp1[1] = Math.max(dp1[0], temp_stk[1]);
        
        for(int i = 2; i < len; i++){
            dp1[i] = Math.max(temp_stk[i] + dp1[i-2] , dp1[i-1]);
        }
        
        dp2[0] = temp_stk2[0];
        dp2[1] = Math.max(dp2[0], temp_stk2[1]);
        
        for(int i = 2; i < len; i++){
            dp2[i] = Math.max(temp_stk2[i] + dp2[i-2] , dp2[i-1]);
        }
        
        answer = Math.max(dp1[len-1], dp2[len-1] );
        
        
        return answer;
    }
}